package br.com.esantos.tasklist.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esantos.tasklist.model.TaskStatus;
import br.com.esantos.tasklist.repository.StatusRepository;

@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/status")
public class StatusResource {

	@Autowired
	private StatusRepository statusRepository;
		
	@GetMapping
	private List<TaskStatus> listar(){
		return statusRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskStatus> buscar (@PathVariable Long id){
		TaskStatus taskStatus = statusRepository.findOne(id);
		
		if (taskStatus == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(taskStatus);
	}
	
}
