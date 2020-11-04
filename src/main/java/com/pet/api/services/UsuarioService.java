package com.pet.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pet.api.entities.Usuario;
import com.pet.api.repositories.UsuarioRepository;
import com.pet.api.utils.ConsistenciaException;

public class UsuarioService {

	
	@Autowired
	private UsuarioRepository UserRp;
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);
	
	public Optional<Usuario> buscarPorId(int id) throws ConsistenciaException {
     	
     	log.info("Service: buscando um Usuario com o id: {}", id);
     	
     	Optional<Usuario> user = UserRp.findById(id);
     	
     	if (!user.isPresent()) {

            	log.info("Service: Nenhum usuario com id: {} foi encontrado", id);
            	throw new ConsistenciaException("Nenhum usuario com id: {} foi encontrado", id);

     	}
     	
     	return user;
     	
	}
	
	
	public Usuario salvar(Usuario user) throws ConsistenciaException {
     	
     	log.info("Service: salvando o usuario: {}", user);
     	
     	if (user.getId() > 0)
            	buscarPorId(user.getId());
     	
     	try {
            	return UserRp.save(user);
     	} catch (DataIntegrityViolationException e) {
            	
            	log.info("Service: O email: {} já está cadastrado para outro usuario", user.getId());
            	throw new ConsistenciaException("O email: {} já está cadastrado para outro usuario", user.getEmail());
            	
     	}
	}
	
	public void Block(Usuario user) throws ConsistenciaException{
		
		if(user.getId() > 0)
			
			buscarPorId(user.getId());
		
			UserRp.Bloquear(user.getId());
		
	}
	}
