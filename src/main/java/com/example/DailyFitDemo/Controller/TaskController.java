package com.example.DailyFitDemo.Controller;

import com.example.DailyFitDemo.Model.Task;
import com.example.DailyFitDemo.Service.TaskService;
import com.example.DailyFitDemo.dto.TaskRequest;
import com.example.DailyFitDemo.dto.TaskResponse;
import org.springframework.web.bind.annotation.*;
import com.example.DailyFitDemo.dto.TaskResponse;
import com.example.DailyFitDemo.Model.Category;
import com.example.DailyFitDemo.Model.Priority;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public TaskResponse createTask(@Valid @RequestBody TaskRequest request) {
        return taskService.createTask(request);
    }

    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequest request) {

        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
    @GetMapping("/date/{taskDate}")
    public List<TaskResponse> getTasksByDate(
            @PathVariable LocalDate taskDate) {

        return taskService.getTasksByDate(taskDate);
    }
    @GetMapping("/category/{category}")
    public List<TaskResponse> getTasksByCategory(
            @PathVariable Category category
    ) {
        return taskService.getTasksByCategory(category);
    }
    @GetMapping("/priority/{priority}")
    public List<TaskResponse> getTasksByPriority(
            @PathVariable Priority priority
    ) {
        return taskService.getTasksByPriority(priority);
    }
    @GetMapping("/search")
    public List<TaskResponse> searchTasks(
            @RequestParam String keyword
    ) {
        return taskService.searchTasks(keyword);
    }
}