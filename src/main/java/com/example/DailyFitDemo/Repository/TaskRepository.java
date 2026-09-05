package com.example.DailyFitDemo.Repository;

import com.example.DailyFitDemo.Model.Category;
import com.example.DailyFitDemo.Model.Priority;
import com.example.DailyFitDemo.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTaskDate(LocalDate taskDate);

    List<Task> findByCategory(Category category);

    List<Task> findByPriority(Priority priority);

    List<Task> findByTitleContainingIgnoreCase(String keyword);
}