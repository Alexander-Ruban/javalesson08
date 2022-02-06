package org.itstep;


import org.itstep.entity.ToDoItem;
import org.itstep.service.ToDoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
        ToDoService service = appContext.getBean(ToDoService.class);
        service.validateAndSave(new ToDoItem("Learn Spring Core", new Date(2022, Calendar.FEBRUARY, 13), 8));
        System.out.println(service.findAll());
    }
}
