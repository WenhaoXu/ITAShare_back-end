package com.oocl.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.demo.DemoApplication;
import com.oocl.demo.domain.TodoItem;
import com.oocl.demo.service.TodoListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Dylan Wei
 * @date 2019-03-09 23:21
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DemoApplication.class)
@ComponentScan(basePackages = "com")
public class TodoListControllerTest {
    @MockBean
    private TodoListService todoListService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    private static final String url = "/todoItems";

    @Test
    public void should_return_201_after_item_added_successfully() throws Exception {
//        given
        TodoItem item = new TodoItem("do homework", false);
        when(this.todoListService.addTodoItem(any())).thenReturn(item);
//        when & then
        mockMvc.perform(
                post(url).content(mapper.writeValueAsString(item)).contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andExpect(content().string(mapper.writeValueAsString(item)));
    }

}