package org.itstep.service;

import org.itstep.entity.ToDoItem;
import org.itstep.rpository.ToDoRepository;

import java.util.Date;
import java.util.List;

public class ToDoService {
    private ToDoRepository repository;

    public ToDoService() {
    }

    public ToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public void setRepository(ToDoRepository repository) {
        this.repository = repository;
    }

    public void validateAndSave(ToDoItem item) {
        validateToDoItem(item);
        repository.save(item);
    }

    private void validateToDoItem(ToDoItem item) {
        if ( item.getDeadline().before(new Date())) {
            throw new IllegalArgumentException("Date should not be past");
        }
        if (item.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title should not be blank or empty");
        }
        if(item.getPriority() < 0 || item.getPriority() > 10) {
            throw  new IllegalArgumentException("Priority should not be less 0 or higher 10");
        }
    }

    public List<ToDoItem> findAll() {
        return repository.findAll();
    }
}
