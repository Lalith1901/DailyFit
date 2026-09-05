package com.example.DailyFitDemo.Service;

import com.example.DailyFitDemo.Exception.TaskNotFoundException;
import com.example.DailyFitDemo.Model.Task;
import com.example.DailyFitDemo.Repository.TaskRepository;
import com.example.DailyFitDemo.dto.TaskRequest;
import com.example.DailyFitDemo.dto.TaskResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponse> getAllTasks() {

        List<Task> tasks = taskRepository.findAll();

        return tasks.stream()
                .map(task -> new TaskResponse(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.isCompleted(),
                        task.getTaskDate(),
                        task.getPriority(),
                        task.getCategory()
                ))
                .toList();
    }

    public TaskResponse createTask(TaskRequest request) {

        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.isCompleted());
        task.setTaskDate(request.getTaskDate());
        task.setPriority(request.getPriority());
        task.setCategory(request.getCategory());

        Task savedTask = taskRepository.save(task);

        return new TaskResponse(
                savedTask.getId(),
                savedTask.getTitle(),
                savedTask.getDescription(),
                savedTask.isCompleted(),
                savedTask.getTaskDate(),
                savedTask.getPriority(),
                savedTask.getCategory()
        );
    }

    public TaskResponse getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task not found with id: " + id));

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getTaskDate(),
                task.getPriority(),
                task.getCategory()
        );
    }

    public TaskResponse updateTask(Long id, TaskRequest request) {

        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task not found with id: " + id));

        existingTask.setTitle(request.getTitle());
        existingTask.setDescription(request.getDescription());
        existingTask.setCompleted(request.isCompleted());
        existingTask.setTaskDate(request.getTaskDate());
        existingTask.setPriority(request.getPriority());
        existingTask.setCategory(request.getCategory());

        Task updatedTask = taskRepository.save(existingTask);

        return new TaskResponse(
                updatedTask.getId(),
                updatedTask.getTitle(),
                updatedTask.getDescription(),
                updatedTask.isCompleted(),
                updatedTask.getTaskDate(),
                updatedTask.getPriority(),
                updatedTask.getCategory()
        );
    }

    public void deleteTask(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task not found with id: " + id));

        taskRepository.delete(task);
    }

    public List<TaskResponse> getTasksByDate(LocalDate taskDate) {

        List<Task> tasks = taskRepository.findByTaskDate(taskDate);

        return tasks.stream()
                .map(task -> new TaskResponse(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.isCompleted(),
                        task.getTaskDate(),
                        task.getPriority(),
                        task.getCategory()
                ))
                .toList();
    }
}