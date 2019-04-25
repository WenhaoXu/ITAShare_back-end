package com.oocl.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.oocl.demo.domain.OperationLog;
import com.oocl.demo.domain.TodoItem;
import com.oocl.demo.repository.TodoListRepositpory;
import com.oocl.demo.sender.MessageSender;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class TodoListService {

    @Autowired
    private ObjectMapper objectMapper;

    private TodoListRepositpory repositpory;

    @Autowired
    private MessageSender sender;

    @Value("${solace.topic.test-topic}")
    private String topic;

    @Autowired
    public TodoListService(TodoListRepositpory repositpory) {
        this.repositpory = repositpory;
    }

    public TodoItem addTodoItem(TodoItem item) throws JsonProcessingException {
        item.setType("未完成");
        TodoItem todoItem = this.repositpory.save(item);
        sendOperationLogMessage("add", todoItem);
        return todoItem;
    }


    public TodoItem updateTodoItems(TodoItem item) throws JsonProcessingException {
        TodoItem todoItem = this.repositpory.save(item);
        sendOperationLogMessage("update", todoItem);
        return todoItem;
    }

    public List<TodoItem> getItems(TodoItem item) throws JsonProcessingException {
        List<TodoItem> todoItems = repositpory.findAll(Example.of(item));
        sendOperationLogMessage("search", todoItems);
        return todoItems;
    }

    public TodoItem getItemById(Long id) {
        return repositpory.findById(id).get();
    }

    public boolean deleteItem(TodoItem item) throws JsonProcessingException {
        item = getItemById(item.getId());
        repositpory.deleteById(Long.parseLong(item.getId().toString()));
        sendOperationLogMessage("delete", item);
        return true;
    }

    private void sendOperationLogMessage(String type, TodoItem todoItem) throws JsonProcessingException {
        sendOperationLogMessage(type, Lists.newArrayList(todoItem));
    }

    private void sendOperationLogMessage(String type, List<TodoItem> todoItems) throws JsonProcessingException {
        OperationLog operationLog = new OperationLog();
        operationLog.setOperation(type);
        operationLog.setData(objectMapper.writeValueAsString(todoItems));
        operationLog.setCreatetime(String.valueOf(LocalDateTime.now()));
        sender.sendMessageToTopic(topic, objectMapper.writeValueAsString(operationLog));
    }
}
