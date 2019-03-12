package com.oocl.demo.repository;

import com.oocl.demo.domain.TodoItem;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dylan Wei
 * @date 2019-03-09 19:31
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TodoListRepositporyTest {
    @Autowired
    private TestEntityManager manager;

    @Autowired
    private TodoListRepositpory repositpory;

    @After
    public void reset(){
        this.manager.clear();
    }

    @Test
    public void should_total_size_increase_1_after_1_item_added(){
        //given
        TodoItem item = new TodoItem("do homework", false);
        int oldSize = this.repositpory.findAll().size();
        //when
        this.repositpory.save(item);
        //then
        int newSize = this.repositpory.findAll().size();
        assertThat(newSize, is(oldSize + 1));
    }

    @Test
    public void should_total_size_increase_3_after_item_list_with_3_items_inserted(){
        //given
        TodoItem item1 = new TodoItem("do homework", false);
        TodoItem item2 = new TodoItem("do homework", false);
        TodoItem item3 = new TodoItem("do homework", false);
        List<TodoItem> items = Arrays.asList(item1, item2, item3);
        int oldSize = this.repositpory.findAll().size();
        //when
        this.repositpory.saveAll(items);
        //then
        int newSize = this.repositpory.findAll().size();
        assertThat(newSize, is(oldSize + items.size()));
    }

    @Test
    public void should_total_size_decrease_1_after_1_items_deleted(){
        //given
        TodoItem item = new TodoItem("do homework", false);
        List<TodoItem> todoItems = this.repositpory.saveAll(Arrays.asList(item, item, item));
        int oldSize = this.repositpory.findAll().size();
        //when
        this.repositpory.delete(todoItems.get(0));
        //then
        int newSize = this.repositpory.findAll().size();
        assertThat(newSize, is(oldSize -1));
    }


}