package com.birzapp.rest.service;

import com.birzapp.rest.entity.Task;
import java.util.Collection;

public interface TaskService {
    public abstract void insert(Task task);
    public abstract void update(Task task);
    public abstract void delete(Long id);
    public abstract Task findById(Long id);
    public abstract Collection<Task> findAll();
}
