package com.app.todoapp.services;

import com.app.todoapp.models.Task;
import com.app.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //    Read
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    //    create
    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    //    delete
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    //    update
    public void toggleTask(Long id) {
//        first finding task by id - if not found then show exception
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task Id"));
//        then reversing the task if 0 then 1 and if 1 then 0 like button
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task); // save task

    }
}
































