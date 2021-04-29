package br.com.esig.gerenciador.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.esig.gerenciador.model.Priority;
import br.com.esig.gerenciador.model.Task;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TaskRepositoryTest {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testSaveTask() {
		//configuration
		Task task = new Task("Teste de banco", "Testar a função salvar no banco", Priority.HIGH);
		
		//action
		Task taskSaved = taskRepository.save(task);
		
		//verification
		assertNotNull(taskSaved.getId());
	}
	
//	@Test
//	public void testFindTaskByTitle() {
//		//configuration
//		Task task = new Task("Teste de banco", "Testar a função salvar no banco", Priority.HIGH);
//		entityManager.persist(task);
//		
//		//action
//		Task taskReturned = taskRepository.findByTitle("Teste de banco");
//		
//		//verification
//		assertThat(taskReturned.getTitle(), task.getTitle());
//		assertThat(taskReturned.getDescription()).isEqualTo(task.getDescription());
//	}
//	
//	@Test
//	public void testFindAllTaskByPriority() {
//		//configuration
//		Task task1 = new Task("Teste de banco 1", "Testar a função salvar no banco 1", Priority.MEDIUM);
//		Task task2 = new Task("Teste de banco 2", "Testar a função salvar no banco 2", Priority.LOW);
//		Task task3 = new Task("Teste de banco 3", "Testar a função salvar no banco 3", Priority.MEDIUM);
//		
//		//action
//		entityManager.persist(task1);
//		entityManager.persist(task2);
//		entityManager.persist(task3);
//		
//		List<Task> taskListReturned = taskRepository.findAllByPriority(Priority.MEDIUM);
//		
//		//verification
//		assertEquals(taskListReturned.size(),2);
//		assertThat(taskListReturned.get(0).getTitle()).isEqualTo(task1.getTitle());
//		assertThat(taskListReturned.get(0).getDescription()).isEqualTo(task1.getDescription());
//		assertThat(taskListReturned.get(1).getTitle()).isEqualTo(task3.getTitle());
//		assertThat(taskListReturned.get(1).getDescription()).isEqualTo(task3.getDescription());
//		
//	}

}
