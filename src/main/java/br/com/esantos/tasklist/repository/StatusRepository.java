package br.com.esantos.tasklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.esantos.tasklist.model.TaskStatus;

@RepositoryRestResource(collectionResourceRel = "task_status", path = "task_status")
public interface StatusRepository extends JpaRepository<TaskStatus, Long>  {


}
