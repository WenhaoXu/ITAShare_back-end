package com.example.demo.repository;

import com.example.demo.domain.TodoList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Howells
 * @DATE 03/08/2019
 */
@Repository
public interface TodoListRepositpory extends MongoRepository<TodoList,String> {
}
