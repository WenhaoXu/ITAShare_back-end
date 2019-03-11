package com.oocl.demo.controller;

import com.oocl.demo.domain.TodoItem;
import com.oocl.demo.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Howells
 * @DATE 03/08/2019
 */
@RestController
public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    @GetMapping("/todoItems")
    public List<TodoItem> get() {
        return todoListService.getAllItems();
    }

    @PutMapping("/todoItems")
    public TodoItem put(@RequestBody TodoItem todoList) {
       return todoListService.updateTodoItems(todoList);
    }

    @PostMapping("/todoItems")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItem createItem(@RequestBody TodoItem item){
        return this.todoListService.addTodoItem(item);
    }

    @DeleteMapping("todoItems")
    public  Boolean delete(@RequestBody TodoItem item){
        return this.todoListService.deleteItem(item);

    }
}
