package com.oocl.demo.service;

import com.oocl.demo.domain.TodoItem;
import com.oocl.demo.repository.TodoListRepositpory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Dylan Wei
 * @date 2019-03-09 23:06
 */
public class TodoListServiceTest {
    private TodoListRepositpory repositpory;

    private TodoListService todoListService;

    @Before
    public void beforeEach(){
        this.repositpory = mock(TodoListRepositpory.class);
        this.todoListService = new TodoListService(this.repositpory);
    }

    @Test
    public void should_added_item_successfully(){
        //given
        TodoItem item = new TodoItem("do homework", false);
        //when
        this.todoListService.addTodoItem(item);
        //then
        verify(this.repositpory).save(item);
    }
}