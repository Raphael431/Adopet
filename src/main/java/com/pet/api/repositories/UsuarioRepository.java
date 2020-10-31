package com.pet.api.repositories;
 
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
 
import com.pet.api.entities.Usuario;
 
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
   	
   	
   	@Transactional
   	@Modifying(clearAutomatically = true)
   	@Query("UPDATE Usuario SET senha = :novasenha WHERE id = :idusuario")
   	void alterarSenhaUsuario(@Param("novasenha") String novasenha, @Param("idusuario") int idusuario);
   	
   	
   	@Transactional
   	@Modifying(clearAutomatically = true)
   	@Query("UPDATE usuario SET telefone = :novonum WHERE id = :idusuario")
   	void AtualizarData(@Param("novonum") String novonum, @Param("idusuario") int idusuario);
   	
   	
   	@Transactional
   	@Modifying(clearAutomatically = true)
   	@Query("UPDATE usuario SET ativo = false WHERE id = :idusuario")
   	void Bloquear(@Param("idusuario") int idusuario );
   	

}