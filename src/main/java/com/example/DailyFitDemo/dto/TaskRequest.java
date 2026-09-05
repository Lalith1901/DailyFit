package com.example.DailyFitDemo.dto;

import com.example.DailyFitDemo.Model.Priority;
import jakarta.validation.constraints.NotBlank;
import com.example.DailyFitDemo.Model.Category;

import java.time.LocalDate;

public class TaskRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;
    private LocalDate taskDate;
    private boolean completed;
    private Priority priority;
    private Category category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}