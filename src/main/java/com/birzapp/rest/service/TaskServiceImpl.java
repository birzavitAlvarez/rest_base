package com.birzapp.rest.service;

import com.birzapp.rest.entity.Task;
import com.birzapp.rest.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository repository;

    @Override
    @Transactional
    public void insert(Task item) {
        repository.save(item);
    }

    @Override
    @Transactional
    public void update(Task item) {
        repository.save(item);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Task findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Task> findAll() {
        return repository.findAll();
    }

}

