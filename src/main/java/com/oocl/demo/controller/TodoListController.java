//package com.oocl.demo.controller;
//
//import com.oocl.demo.domain.TodoItem;
//import com.oocl.demo.service.TodoListService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * @author Howells
// * @DATE 03/08/2019
// */
//@RestController
//public class TodoListController {
//    @Autowired
//    private TodoListService todoListService;
//
//    @GetMapping("/todo")
//    public List<TodoItem> get() {
//
//        return todoListService.getAllItems();
//    }
//
//    @PostMapping("/todo")
//    public TodoItem post(@RequestParam String title) {
//        TodoItem todoList = new TodoItem(title, false);
//        return  todoListService.insertTodoItems(todoList);
//
//    }
//
//    @PutMapping("/todo")
//    public TodoItem put(@RequestParam String id, @RequestParam String title, @RequestParam Boolean finished) {
//        TodoItem todoList = new TodoItem(id, title, finished);
//       return todoListService.updateTodoItems(todoList);
//    }
//}
