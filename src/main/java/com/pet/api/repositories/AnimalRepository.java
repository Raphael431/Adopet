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
 
   	@Query("SELECT a FROM animal a WHERE a.usuario.id = :idusuario")
   	List<Animal> findByUserId(@Param("idusuario") int idusuario);

   	@Query("SELECT FROM animal WHERE ativo = true")
   	List<Animal> listar();
   	
   	@Query("UPDATE animal SET ativo = false WHERE id = :idanimal")
   	void adotado(@Param("idanimal") int idanimal);
   	
   	@Query("SELECT FROM animal WHERE porte = :dado")
   	Optional<List<Animal>> selecPorte(@Param("dado") String dado);
   	
   	@Query("SELECT FROM animal WHERE idade = :dado")
   	Optional<List<Animal>> selectIdade(@Param("dado") String dado);
   	
   	@Query("SELECT FROM animal WHERE tipo = :dado")
   	Optional<List<Animal>> selectTipo(@Param("dado") String dado);
   	 		
   	@Query("SELECT FROM animal WHERE tipo = :dado1 AND raca = :dado2")
   	Optional<List<Animal>> selectRaca(@Param("dado1") String dado1, @Param("dado2") String dado2);
   	
     	
}
