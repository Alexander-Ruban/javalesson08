package org.itstep.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
public class ToDoItem {
    private String id;
    @NonNull
    private String title;
    @NonNull
    private Date deadline;
    @NonNull
    private Integer priority;

    public ToDoItem(String title, Date date, Integer priority) {
        id = UUID.randomUUID().toString();
        this.title = title;
        deadline = date;
        this.priority = priority;
    }
}
