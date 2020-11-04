package com.pet.api.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UsuarioDto {
	
private int id;
   	
   	@NotEmpty(message = "Nome não pode ser vazio.")
   	@Length(min = 5, max = 100,
   	message = "Nome do usuário deve ter no mínimo 5 e no máximo 100 caracteres.")
   	private String nome;
   	
   	@NotEmpty(message = "Senha não pode ser vazio.")
   	private String senha;
   	
   	@NotEmpty(message = "Email de validade não pode ser vazio.")
   	private String email;
   	
   	@NotEmpty(message = "Telefone não pode ser vazio.")
   	@Length(min = 8, max = 11,
   	message = "Nome do usuário deve ter no mínimo 5 e no máximo 100 caracteres.")
   	private String telefone;
   	
	@NotEmpty(message = "Ativo não pode ser vazio.")
   	private boolean ativo;
   	
   	public int getId() {
         	return id;
   	}
   	
   	public void setId(int id) {
         	this.id = id;
   	}
   	
   	public String getNome() {
         	return nome;
   	}
   	
   	public void setNome(String nome) {
         	this.nome = nome;
   	}
   	
   	public String getSenha() {
         	return senha;
   	}
   	
   	public void setSenha(String senha) {
         	this.senha = senha;
   	}
   	
   	
   	public String getEmail() {
         	return email;
   	}
   	
   	public void setEmail(String email) {
         	this.email = email;
   	}
	
     public String getTelefone() {
		    return telefone;
		
	}
	public void setTelefone(String telefone) {
		    this.telefone = telefone;
		
	}
	
    public boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
		
	}
   	
   	@Override
   	public String toString() {
         	return "Usuario[" + "id=" + id + ","
                       	+ "nome=" + nome + ","
                       	+ "senha=" + senha + ","
                       	+ "email=" + email + ","
                       	+ "telefone=" + telefone + ","
                       	+ "ativo=" + ativo + "]";
   	}
 
   	
}
