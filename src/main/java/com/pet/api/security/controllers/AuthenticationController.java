package com.pet.api.security.controllers;
 
import javax.validation.Valid;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.pet.api.security.utils.JwtTokenUtil;
import com.pet.api.response.Response;
import com.pet.api.security.dtos.JwtAuthenticationDto;
import com.pet.api.security.dtos.TokenDto;
 
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {
 
   	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
 
   	@Autowired
   	private AuthenticationManager authenticationManager;
 
   	@Autowired
   	private JwtTokenUtil jwtTokenUtil;
 
   	@Autowired
   	private UserDetailsService userDetailsService;
   	
   	@PostMapping
   	public ResponseEntity<Response<TokenDto>> gerarTokenJwt(@Valid @RequestBody JwtAuthenticationDto authenticationDto,
                	BindingResult result) {
 
         	Response<TokenDto> response = new Response<TokenDto>();
 
         	try {
 
                	log.info("Gerando token para o email {}.", authenticationDto.getEmail());
 
                	if (result.hasErrors()) {
 
                       	for (int i = 0; i < result.getErrorCount(); i++) {
                       	   	response.adicionarErro(result.getAllErrors().get(i).getDefaultMessage());
                       	}
 
         	          	log.info("Controller: Os campos obrigatórios não foram preenchidos");
                       	return ResponseEntity.badRequest().body(response);
 
                	}
 
                	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                              	authenticationDto.getEmail(), authenticationDto.getSenha()));
 
                	SecurityContextHolder.getContext().setAuthentication(authentication);
 
                	UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDto.getEmail());
                	String token = jwtTokenUtil.obterToken(userDetails);
 
                	response.setDados(new TokenDto(token));
 
                	return ResponseEntity.ok(response);
 
         	} catch (BadCredentialsException e) {
 
                	log.info("Controller: Usuário ou senha inválido!");
                	response.adicionarErro("Usuário ou senha inválido!");
                	return ResponseEntity.badRequest().body(response);
 
         	} catch (Exception e) {
 
                	log.error("Controller: Ocorreu um erro na aplicação: {}", e.getMessage());
                	response.adicionarErro("Ocorreu um erro na aplicação: {}", e.getMessage());
                	return ResponseEntity.status(500).body(response);
 
         	}
 
   	}
 
}
