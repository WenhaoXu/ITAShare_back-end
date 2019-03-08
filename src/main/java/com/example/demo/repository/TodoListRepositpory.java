package com.example.demo.repository;

import com.example.demo.domain.TodoItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Howells
 * @DATE 03/08/2019
 */
@Repository
public interface TodoListRepositpory extends MongoRepository<TodoItem,String> {
}
