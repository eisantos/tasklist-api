package br.com.esantos.tasklist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TaskStatus {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_status;
	
	private String descricao;
	
	private int idnativo;
	
	private String sgl_status;
	
	
	public String getSgl_status() {
		return sgl_status;
	}
	public void setSgl_status(String sgl_status) {
		this.sgl_status = sgl_status;
	}
	public Long getId_status() {
		return id_status;
	}
	public void setId_status(Long id_status) {
		this.id_status = id_status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIdnativo() {
		return idnativo;
	}
	public void setIdnativo(int idnativo) {
		this.idnativo = idnativo;
	}
}


