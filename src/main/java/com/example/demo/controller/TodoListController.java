package com.example.demo.controller;

import com.example.demo.domain.TodoList;
import com.example.demo.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Howells
 * @DATE 03/08/2019
 */
@RestController("/TodoList")
public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    @GetMapping("/todo")
    public List<TodoList> get() {

        return todoListService.getAllItems();
    }

    @PostMapping("/todo")
    public TodoList post(@RequestParam String title) {
        TodoList todoList = new TodoList(title, false);
        return  todoListService.insertTodoItems(todoList);

    }

    @PutMapping("/todo")
    public TodoList put(@RequestParam String id,@RequestParam String title,@RequestParam Boolean finished) {
        TodoList todoList = new TodoList(id, title, finished);
       return todoListService.updateTodoItems(todoList);
    }
}
