package com.ats.repository;

import com.ats.entity.Task;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TaskRepository implements PanacheRepository<Task> {

    @Transactional
    public void addTask(Task newTask){
        persist(newTask);
    }
}
