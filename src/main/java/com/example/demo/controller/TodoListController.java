package com.example.demo.controller;

import com.example.demo.domain.TodoItem;
import com.example.demo.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author Howells
 * @DATE 03/08/2019
 */
@RestController("/TodoList")
public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    @GetMapping
    public List<TodoItem> getAllItems(){
        return  todoListService.getAllItems();
    }

    @PostMapping
    public List<TodoItem> addTodoList(@RequestBody List<TodoItem> list){
        return todoListService.insertTodoItems(list);
    }

    @PutMapping
    public boolean updateTodoList(@RequestBody List<TodoItem> list){
        return todoListService.updateTodoItems(list);
    }

    @DeleteMapping
    public boolean deleteItems(@RequestBody List<String> ids){
        return  todoListService.deleteItems(ids);
    }
}
