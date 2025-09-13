package com.bianca.task_manager.service;

import com.bianca.task_manager.entity.Task;
import com.bianca.task_manager.repository.TaskRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    //constructor injection
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> create(Task task){
        taskRepository.save(task);
        return listAll();
    }

    public List<Task> listAll(){
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
        return taskRepository.findAll(sort);
    }

    public List<Task> update(Task task){
        taskRepository.save(task);
        return listAll();
    }

    public List<Task> delete(Long id){
        taskRepository.deleteById(id);
        return listAll();
    }
}