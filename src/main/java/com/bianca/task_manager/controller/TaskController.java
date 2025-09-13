package com.bianca.task_manager.controller;

import com.bianca.task_manager.entity.Task;
import com.bianca.task_manager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    //constructor injection
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    List<Task> create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @GetMapping
    List<Task> listAll() {
        return taskService.listAll();
    }

    @PutMapping
    List<Task> update(@RequestBody Task task) {
        return taskService.update(task);
    }

    @DeleteMapping("{id}")
    List<Task> delete(@PathVariable("id") Long id) {
        return taskService.delete(id);
    }

    @GetMapping("/status")
    List<Task> findByDone(@RequestParam boolean done) {
        return taskService.findByDone(done);
    }
}