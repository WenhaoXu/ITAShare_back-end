package com.example.demo.service;

import com.example.demo.domain.TodoItem;
import com.example.demo.repository.TodoListRepositpory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Howells
 * @DATE 03/08/2019
 */
@Service
public class TodoListService {
    @Autowired
    private TodoListRepositpory repositpory;

    public TodoItem insertTodoItems(TodoItem item){
         repositpory.insert(item);
        return item;
    }

    public TodoItem updateTodoItems(TodoItem item){
        repositpory.save(item);
        return item;
    }


    public List<TodoItem> getAllItems() {
        return repositpory.findAll();
    }


}
