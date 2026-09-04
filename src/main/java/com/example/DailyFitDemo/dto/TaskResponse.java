package com.example.DailyFitDemo.dto;
import java.time.LocalDate;

public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDate taskDate;

    public TaskResponse(Long id, String title, String description, boolean completed,LocalDate taskDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.taskDate = taskDate;
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
}