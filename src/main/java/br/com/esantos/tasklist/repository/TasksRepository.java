package br.com.esantos.tasklist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.esantos.tasklist.model.Task;

@RepositoryRestResource(collectionResourceRel = "task", path = "tasks")
public interface TasksRepository extends JpaRepository<Task, Long>  {
	
	/**
     * Método que retorna uma lista de tasks fazendo a busca pela descrição passada como parâmetro.
     *  
     * @param descricao
     * @return lista de Tasks
     */
    List<Task> findByDescricao(@Param("descricao") String descricao);
     
    /**
     * Método que retorna a task com apenas sua descricao fazendo a busca com o id passado como parâmetro.
     * 
     * @param id
     * @return task do id passado como parâmetro.
     
    @Query("SELECT t.descricao FROM task t where t.id_task = :id") 
  Task findDescricaoById(@Param("id") Long id);
     */  
    /**
     * Método que retorna uma lista de tasks fazendo a busca pela descricao passada como parâmetro e ordenando as 
     * tasks pela descricao.
     *  
     * @param name
     * @return lista de clientes
     */
    List<Task> findByDescricaoOrderByDescricao(@Param("descricao") String descricao);

}
