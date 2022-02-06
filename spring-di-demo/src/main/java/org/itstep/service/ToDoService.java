package org.itstep.service;

import org.itstep.entity.ToDoItem;
import org.itstep.rpository.ToDoRepository;

import java.util.Date;

public class ToDoService {
    private final ToDoRepository repository;

    public ToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public void validateAndSave(ToDoItem item) {
        validateToDoItem(item);
        repository.save(item);
    }

    private void validateToDoItem(ToDoItem item) {
        if (item.getDeadline() == null && item.getDeadline().after(new Date())) {
            throw new IllegalArgumentException("Date should not be future");
        }
        if (item.getTitle() == null || item.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title should not be blank or empty");
        }
        if(item.getPriority() < 0 || item.getPriority() > 10) {
            throw  new IllegalArgumentException("Priority should not be less 0 or higher 10");
        }
    }
}
