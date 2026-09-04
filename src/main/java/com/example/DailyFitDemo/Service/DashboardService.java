package com.example.DailyFitDemo.Service;

import com.example.DailyFitDemo.Model.Task;
import com.example.DailyFitDemo.Repository.TaskRepository;
import com.example.DailyFitDemo.dto.DashboardResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DashboardService {

    private final TaskRepository taskRepository;

    public DashboardService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public DashboardResponse getDashboard(LocalDate date) {

        List<Task> tasks = taskRepository.findByTaskDate(date);

        int totalTasks = tasks.size();

        int completedTasks = 0;

        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks++;
            }
        }

        int pendingTasks = totalTasks - completedTasks;

        double completionPercentage = 0;

        if (totalTasks > 0) {
            completionPercentage =
                    Math.round(
                            ((double) completedTasks / totalTasks) * 100 * 100.0
                    ) / 100.0;
        }

        return new DashboardResponse(
                date,
                totalTasks,
                completedTasks,
                pendingTasks,
                completionPercentage
        );
    }
}