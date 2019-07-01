package com.tts.DoneIt.repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.DoneIt.model.Tasks;

public interface TaskRepo extends CrudRepository<Tasks, Long>{
	
	
}
