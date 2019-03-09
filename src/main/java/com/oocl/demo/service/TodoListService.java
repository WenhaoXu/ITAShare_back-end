package com.oocl.demo.service;

import com.oocl.demo.domain.TodoItem;
import com.oocl.demo.repository.TodoListRepositpory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TodoListService {
    private TodoListRepositpory repositpory;

    @Autowired
    public TodoListService(TodoListRepositpory repositpory){
        this.repositpory = repositpory;
    }

    public void addTodoItem(TodoItem item){
        item.setCreated(new Date());
        System.out.println(this.repositpory.save(item));
    }


}
