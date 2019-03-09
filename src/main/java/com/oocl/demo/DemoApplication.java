package com.oocl.demo;

import com.oocl.demo.repository.TodoListRepositpory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    @Autowired
    private TodoListRepositpory repositpory;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
