package com.oocl.demo.service;

import com.oocl.demo.domain.TodoItem;
import com.oocl.demo.repository.TodoListRepositpory;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

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

    @Test
    public void should_Update_Todo_Items() {
        //given
        TodoItem todoItem = mock(TodoItem.class);
        //when
        todoListService.updateTodoItems(todoItem);
        //then
        verify(repositpory).save(todoItem);
    }

    @Test
    public void should_Get_All_Items() {
        //given
        Collections.singletonList(mock(TodoItem.class));
        //when
        todoListService.getAllItems();
        //then
        verify(repositpory).findAll();
    }

    @Test
    public void should_delete_Item_By_Id(){
        //given
        TodoItem todoItem = mock(TodoItem.class);
        //when
        todoListService.deleteItem(todoItem);
        //then
        verify(repositpory).deleteById(todoItem.getId());
    }

}