package org.itstep.entity;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ToDoItem {
    private String Id;
    private String title;
    private Date deadline;
    private Integer priority;

    public ToDoItem() {
        Id = UUID.randomUUID().toString();
    }
}
