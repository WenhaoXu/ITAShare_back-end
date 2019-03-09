package com.oocl.demo.repository;
import com.oocl.demo.domain.TodoItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Dylan Wei
 * @date 2019-03-09 19:31
 */
@RunWith(SpringRunner.class)
@DataJpaTest
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
    public void should_get_total_number_of_3_items(){
        //given
        TodoItem item = new TodoItem("do homework", false);
        int oldSize = this.repositpory.findAll().size();
        //when
        this.repositpory.save(item);
        //then
        int newSize = this.repositpory.findAll().size();
        assertThat(newSize, is(oldSize + 1));
    }

}