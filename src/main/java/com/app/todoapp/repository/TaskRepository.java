package com.app.todoapp.repository;

import com.app.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

//            JpaRepository<Entity class, wrapper type of Primary key>
public interface TaskRepository extends JpaRepository<Task, Long> {

}
