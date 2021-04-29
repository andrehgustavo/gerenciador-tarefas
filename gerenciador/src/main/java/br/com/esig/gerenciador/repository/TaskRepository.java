package br.com.esig.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.esig.gerenciador.model.Priority;
import br.com.esig.gerenciador.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	public Task findByTitle(String title);
	
	public List<Task> findAllByPriority(Priority priority);
}
