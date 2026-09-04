package com.example.DailyFitDemo.Repository;

import com.example.DailyFitDemo.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTaskDate(LocalDate taskDate);


}
