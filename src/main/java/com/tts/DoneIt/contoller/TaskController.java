package com.tts.DoneIt.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tts.DoneIt.model.Tasks;
import com.tts.DoneIt.repository.TaskRepo;

@RequestMapping
@Controller
public class TaskController  {
	
	@Autowired
	private TaskRepo taskRepo;
	
	@GetMapping("/")
	public String index(Tasks tasks, Model model) {
		model.addAttribute("chores", taskRepo.findAll());
		return "index";
	}
	
	@GetMapping("/new")
	public String newTask(Tasks tasks) {
		return "new";
	}
	
	@PostMapping("/new")
	public String addNewTasks(Tasks tasks, Model model) {
	taskRepo.save(tasks);
	model.addAttribute("task", tasks.getTask());
	model.addAttribute("assigned", tasks.getAssigned());
	model.addAttribute("priority", tasks.getPriority());
	model.addAttribute("status", tasks.getStatus());
	model.addAttribute("note", tasks.getNote());
	
	return "result";
	}
	
	@DeleteMapping("/{id}")
    public String deleteTaskWithId(@PathVariable Long id, Tasks tasks) {
        taskRepo.deleteById(id);
        return "index";

    }
	
	@GetMapping("/{id}")
	public String showTask(@PathVariable Long id, Model model) {
		Tasks choreList = taskRepo.findById(id).orElse(null);
		model.addAttribute("chores", choreList);
		return "show";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editTask(@PathVariable Long id, Model model) {
		Tasks choreList = taskRepo.findById(id).orElse(null);
		model.addAttribute("chores", choreList);
		return "edit";
	}
	
	@PutMapping("/{id}")
	public String editTaskById(@PathVariable Long id, Model model, Tasks tasks) {
		Tasks storedTasks = taskRepo.findById(id).orElse(null);
			storedTasks.setAssigned(tasks.getAssigned());
			storedTasks.setOwner(tasks.getOwner());
			storedTasks.setTask(tasks.getTask());
			storedTasks.setPriority(tasks.getPriority());
			storedTasks.setStatus(tasks.getStatus());
			storedTasks.setNote(tasks.getNote());
			taskRepo.save(storedTasks);
			model.addAttribute("task", storedTasks.getTask());
			model.addAttribute("assigned", storedTasks.getAssigned());
			model.addAttribute("owner", storedTasks.getOwner());
			model.addAttribute("priority", storedTasks.getPriority());
			model.addAttribute("status", storedTasks.getStatus());
			model.addAttribute("note", storedTasks.getNote());
			return "result";
			
			
	}
}
	



