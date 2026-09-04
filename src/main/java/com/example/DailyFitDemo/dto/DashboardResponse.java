package com.example.DailyFitDemo.dto;

import java.time.LocalDate;

public class DashboardResponse {

    private LocalDate date;
    private int totalTasks;
    private int completedTasks;
    private int pendingTasks;
    private double completionPercentage;

    public DashboardResponse(
            LocalDate date,
            int totalTasks,
            int completedTasks,
            int pendingTasks,
            double completionPercentage
    ) {
        this.date = date;
        this.totalTasks = totalTasks;
        this.completedTasks = completedTasks;
        this.pendingTasks = pendingTasks;
        this.completionPercentage = completionPercentage;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public int getPendingTasks() {
        return pendingTasks;
    }

    public double getCompletionPercentage() {
        return completionPercentage;
    }
}