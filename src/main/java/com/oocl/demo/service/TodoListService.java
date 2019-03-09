package com.oocl.demo.service;

import com.oocl.demo.repository.TodoListRepositpory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListService {
    private TodoListRepositpory repositpory;

    @Autowired
    public TodoListService(TodoListRepositpory repositpory){
        this.repositpory = repositpory;
    }




}
