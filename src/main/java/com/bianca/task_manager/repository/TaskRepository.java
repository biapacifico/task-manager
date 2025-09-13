package com.bianca.task_manager.repository;

import com.bianca.task_manager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}