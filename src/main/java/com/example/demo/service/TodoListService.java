package com.example.demo.service;

import com.example.demo.domain.TodoItem;
import com.example.demo.repository.TodoListRepositpory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Howells
 * @DATE 03/08/2019
 */
@Service
public class TodoListService {
    @Autowired
    private TodoListRepositpory repositpory;

    public List<TodoItem> insertTodoItems(List<TodoItem> items){
         repositpory.insert(items);
        return items;
    }

    public  boolean updateTodoItems(List<TodoItem> items){
        repositpory.saveAll(items);
        return true;
    }

    public  boolean deleteItems( List<String> idList){
        Iterable<TodoItem> items = repositpory.findAllById(idList);
        repositpory.deleteAll(items);
        return true;
    }

    public List<TodoItem> getAllItems() {
        return repositpory.findAll();
    }


}
