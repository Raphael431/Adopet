package com.pet.api.repositories;
 
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.pet.api.entities.Animal;

 
@Transactional(readOnly = true)
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
 
   	@Query("SELECT a FROM Animal a WHERE a.usuario.id = :idusuario")
   	List<Animal> findByUserId(@Param("idusuario") int idusuario);

   	@Query("SELECT FROM Animal WHERE ativo = true")
   	List<Animal> listar();
   	
   	@Query("UPDATE Animal SET ativo = false WHERE id = :idanimal")
   	void adotado(@Param("idanimal") int idanimal);
   	
   	
}
