package br.com.esig.gerenciador.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.esig.gerenciador.model.Owner;
import br.com.esig.gerenciador.model.Priority;
import br.com.esig.gerenciador.model.Status;
import br.com.esig.gerenciador.model.Task;
import br.com.esig.gerenciador.repository.OwnerRepository;
import br.com.esig.gerenciador.repository.TaskRepository;

@Named
@ViewScoped
public class TaskFormController {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	private List<Task> tasks;
	
	private List<Owner> owners;
	
	private Task task = new Task();
	
	private String date;
	
	@PostConstruct
	public void init() {
		tasks = taskRepository.findAll();
		owners = ownerRepository.findAll();
	}
	
	public Priority[] getPriorities() {
		return Priority.values();
	}

	public void saveTask() {
		task.setDeadline(Date.valueOf(date));
		//Se for nova tareva seta o status para "em progresso", se não continua o status.
		if(task.getId()==null) {
			task.setStatus(Status.IN_PROGRESS);		
		}
		//salva no banco
		taskRepository.save(task);
		tasks.add(task);
		//zera as os campos linkados.
		task = new Task();
		date = "";
	}
	
	public void deleteTask(Task task) {
		taskRepository.delete(task);
		tasks.remove(task);
	}
	
//	########## Getters and Setters###############################
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
	
	public List<Owner> getOwners() {
		return owners;
	}

	public void setOwners(List<Owner> owners) {
		this.owners = owners;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
