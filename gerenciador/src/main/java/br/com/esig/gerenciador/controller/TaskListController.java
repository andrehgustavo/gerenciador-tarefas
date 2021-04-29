package br.com.esig.gerenciador.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.esig.gerenciador.model.Priority;
import br.com.esig.gerenciador.model.Status;
import br.com.esig.gerenciador.model.Task;
import br.com.esig.gerenciador.repository.TaskRepository;

@Named
@ViewScoped
public class TaskListController {

	@Autowired
	private TaskRepository taskRepository;
	
	private List<Task> tasks;
	
	private Task task = new Task();
	
	@PostConstruct
	public void init() {
		tasks = taskRepository.findAll();
	}
	
	public void saveTask() {
		task.setDeadline(Date.valueOf(LocalDate.now()));
		task.setPriority(Priority.HIGH);
		task.setStatus(Status.IN_PROGRESS);
		taskRepository.save(task);
		tasks.add(task);
		task = new Task();
	}
	
	public void deleteTask(Task task) {
		taskRepository.delete(task);
		tasks.remove(task);
	}
	
//	Getters and Setters
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}
