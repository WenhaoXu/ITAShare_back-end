package com.oocl.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oocl.demo.domain.TodoItem;
import com.oocl.demo.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    @GetMapping("/todoItems")
    public List<TodoItem> get(String filter) throws JsonProcessingException {
        TodoItem item = new TodoItem();
        if (!filter.equals("全部"))
            item.setType(filter);
        return todoListService.getItems(item);
    }

    @PostMapping("/todoItems")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItem createItem(@RequestBody TodoItem item) throws JsonProcessingException {
        return this.todoListService.addTodoItem(item);
    }

    @PutMapping("/todoItems")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem(@RequestBody TodoItem todoItem) throws JsonProcessingException {
        todoListService.updateTodoItems(todoItem);
    }

    @PatchMapping("/todoItems")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItemContent(@RequestBody TodoItem item) throws JsonProcessingException {
        TodoItem oldItem = todoListService.getItemById(item.getId());
        item.setType(oldItem.getType());
        todoListService.updateTodoItems(item);
    }


    @DeleteMapping("todoItems")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@RequestBody TodoItem item) throws JsonProcessingException {
        return this.todoListService.deleteItem(item);
    }
}
