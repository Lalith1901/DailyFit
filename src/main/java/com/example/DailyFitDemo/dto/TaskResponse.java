package com.example.DailyFitDemo.dto;

import com.example.DailyFitDemo.Model.Priority;
import java.time.LocalDate;
import com.example.DailyFitDemo.Model.Category;

public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDate taskDate;
    private Priority priority;
    private Category category;

    public TaskResponse(
            Long id,
            String title,
            String description,
            boolean completed,
            LocalDate taskDate,
            Priority priority,
            Category category
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.taskDate = taskDate;
        this.priority = priority;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public Priority getPriority() {
        return priority;
    }
    public Category getCategory() {
        return category;
    }

}