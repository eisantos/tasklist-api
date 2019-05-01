package br.com.esantos.tasklist.resource;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esantos.tasklist.model.Task;
import br.com.esantos.tasklist.repository.TasksRepository;

@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/tasks")
public class TasksResource {

	@Autowired
	private TasksRepository tasks;
	
	@PostMapping
	private Task adicionar(@Valid @RequestBody Task task) {
		
		Date hoje = new Date();		
		task.setData_situacao(hoje);
		task.setData_criacao(hoje);
		return tasks.save(task);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> atualizar (@PathVariable Long id, @Valid @RequestBody Task taskDetalhes){
		Task taskExistente = tasks.findOne(id);
		
		if (taskExistente == null) {
			return ResponseEntity.notFound().build();
		}
		taskDetalhes.setData_criacao(taskExistente.getData_criacao());
		Date hoje = new Date();		
		taskDetalhes.setData_situacao(hoje);
		
		BeanUtils.copyProperties(taskDetalhes, taskExistente, "data_criacao");
		
		final Task updatedTask = tasks.save(taskExistente);
		return ResponseEntity.ok(updatedTask);
		
	}
	
	@GetMapping
	private List<Task> listar(){
		return tasks.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> buscar (@PathVariable Long id){
		Task task = tasks.findOne(id);
		
		if (task == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(task);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		try {
			tasks.delete(id);
			return ResponseEntity.noContent().build();
	    } catch (EmptyResultDataAccessException ex) {
	       	return ResponseEntity.notFound().build();
	    }
		
	}
}
