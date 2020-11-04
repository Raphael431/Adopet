package com.pet.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pet.api.entities.Animal;
import com.pet.api.entities.Usuario;
import com.pet.api.repositories.AnimalRepository;
import com.pet.api.repositories.UsuarioRepository;
import com.pet.api.utils.ConsistenciaException;

public class AnimalService {

	
	@Autowired
	private AnimalRepository AnimRp;
	
	private static final Logger log = LoggerFactory.getLogger(AnimalService.class);
	
	public Optional<Animal> buscarPorId(int id) throws ConsistenciaException {
     	
     	log.info("Service: buscando um animal com o id: {}", id);
     	
     	Optional<Animal> user = AnimRp.findById(id);
     	
     	if (!user.isPresent()) {

            	log.info("Service: Nenhum animal com id: {} foi encontrado", id);
            	throw new ConsistenciaException("Nenhum animal com id: {} foi encontrado", id);

     	}
     	
     	return user;
     	
	}
	
	
	public Animal salvar(Animal anim) throws ConsistenciaException {
     	
     	log.info("Service: salvando o animal: {}", anim);
     	
     	if (anim.getId() > 0)
            	buscarPorId(anim.getId());
     	
    
            	return AnimRp.save(anim);
  
	}
	
	public void Adopted(Animal anim) throws ConsistenciaException{
		
		if(anim.getId() > 0)
			
			buscarPorId(anim.getId());
		
			AnimRp.adotado(anim.getId());
		
	}
	
	public Optional<List<Animal>> BuscarPorColuna(int opc, String dado, String dado2 )
			 throws ConsistenciaException  {
		
		Optional<List<Animal>> lista = Optional.of((new ArrayList<Animal>()));
		
		
		
		if(opc == 1) {
			
			lista = AnimRp.selectTipo(dado);
			
		}
		if(opc == 1 || dado2 != null) {
			
			lista = AnimRp.selectRaca(dado, dado2);
		}
		if(opc == 2) {
			
			lista = AnimRp.selecPorte(dado);
			
		}
		if(opc == 3) {
			
			
			lista = AnimRp.selectIdade(dado);
			
		}
		
		if (!lista.isPresent() || lista.get().size() < 1) {
			
        	log.info("Service: Nenhum animal encontrado com os seguintes dados: {}", dado);
        	throw new ConsistenciaException("Nenhum animal encontrado com o seguinte dado: {}", dado);
 	}
		
		return lista;	
	}
	
	public void ListagemInicial(){
		
		AnimRp.listar();
		
		
	}
	
	public void ListagemPorUsuario(int id) {
	
		AnimRp.findById(id);
	}
	}
