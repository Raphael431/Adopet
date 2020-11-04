package com.pet.api.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.pet.api.entities.Usuario;

public class AnimalDto {
	
private int id;
   	
   	@NotEmpty(message = "Tipo não pode ser vazio.")
   	private String tipo;
   	
   	@NotEmpty(message = "Raça não pode ser vazio.")
   	private String raca;
   	
   	@NotEmpty(message = "Porte de validade não pode ser vazio.")
   	private String porte;
   	
   	@NotEmpty(message = "Idade não pode ser vazio.")
   	@Length(min = 1, max = 2,
   	message = "Idade deve ter no mínimo 1 e no máximo 2 caracteres numéricos")
   	private String idade;
   	
	@NotEmpty(message = "Ativo não pode ser vazio.")
   	private boolean ativo;
	
	private Usuario usuario;
   	
   	public int getId() {
         	return id;
   	}
   	
   	public void setId(int id) {
         	this.id = id;
   	}
   	
   	public String getTipo() {
         	return tipo;
   	}
   	
   	public void setTipo(String tipo) {
         	this.tipo = tipo;
   	}
   	
   	public String getRaca() {
         	return raca;
   	}
   	
   	public void setRaca(String raca) {
         	this.raca = raca;
   	}
   	
   	
   	public String getPorte() {
         	return porte;
   	}
   	
   	public void setPorte(String porte) {
         	this.porte = porte;
   	}
	
     public String getIdade() {
		    return idade;
		
	}
	public void setIdade(String idade) {
		    this.idade = idade;
		
	}
	
       public boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
		
	}
   	
	@Override
   	public String toString() {
         	return "Animal[" + "id=" + id + ","
                       	+ "tipo=" + tipo + ","
                       	+ "raça=" + raca + ","
                       	+ "porte=" + porte + ","
                       	+ "idade=" + idade + ","
                       	+ "ativo=" + ativo + ","
                       	+ "usuario=" + usuario + "]";
   	}

 
   	
}
