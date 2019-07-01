package com.tts.DoneIt.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tasks {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String task;
	private String note;
	private String assigned;
	
	@Enumerated(value=EnumType.STRING)
	private Priority priority;
	
	@Enumerated(value=EnumType.STRING)
	private Status status;
	
	private String owner;
	
	//Args Constructor
		public Tasks(Long id, String task, String note, String assigned, Priority priority, Status status, String owner) {
		super();
		this.id = id;
		this.task = task;
		this.note = note;
		this.assigned = assigned;
		this.priority = priority;
		this.status = status;
		this.owner = owner;
	}
	
	//No Args Constructor
	public Tasks () {
		
	}

	//Setters & Getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	//ToString
	@Override
	public String toString() {
		return "Tasks [id=" + id + ", task=" + task + ", note=" + note + ", assigned=" + assigned + ", priority="
				+ priority + ", status=" + status + ", owner=" + owner + "]";
	}

}
