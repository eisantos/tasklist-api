package br.com.esantos.tasklist.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_task;
	
	private String titulo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_status")
	private TaskStatus task_status;
	
	private String descricao;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	private Date data_criacao;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	private Date data_situacao;
	
	
	public Long getId_task() {
		return id_task;
	}
	public void setId_task(Long id_task) {
		this.id_task = id_task;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData_criacao() {
		return data_criacao;
	}
	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}
	public Date getData_situacao() {
		return data_situacao;
	}
	public void setData_situacao(Date data_situacao) {
		this.data_situacao = data_situacao;
	}
	
	public TaskStatus getTask_status() {
		return task_status;
	}
	public void setTask_status(TaskStatus task_status) {
		this.task_status = task_status;
	}
}
