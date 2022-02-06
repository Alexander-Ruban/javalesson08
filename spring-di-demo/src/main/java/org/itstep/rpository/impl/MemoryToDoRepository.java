package org.itstep.rpository.impl;

import org.itstep.entity.ToDoItem;
import org.itstep.rpository.ToDoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryToDoRepository implements ToDoRepository {
    private final List<ToDoItem> toDoItems;

    public MemoryToDoRepository(int size) {
        this.toDoItems = new ArrayList<>(size);
    }

    @Override
    public void save(ToDoItem entity) {
        toDoItems.add(entity);
    }

    @Override
    public ToDoItem update(ToDoItem entity) {
        Optional<ToDoItem> first = toDoItems.stream().filter(e -> e.getId().equals(entity.getId())).findFirst();
        first.ifPresent(e -> {
            e.setTitle(entity.getTitle());
            e.setPriority(entity.getPriority());
            e.setDeadline(entity.getDeadline());
        });
        return first.orElseThrow();
    }

    @Override
    public List<ToDoItem> findAll() {
        return new ArrayList<>(toDoItems);
    }

    @Override
    public ToDoItem findById(String id) {
        return toDoItems.stream().filter(e -> e.getId().equals(id)).findFirst().orElseThrow();
    }
}
