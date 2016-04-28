package com.quickChat;

import com.quickChat.generator.MessageGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@RestController
public class App 
{
    @Autowired
    private MessageGeneratorService messageGenerator;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @RequestMapping("/time/now")
    public String currentTime() {
        return new Date().toString();
    }

    @RequestMapping("/messages/test")
    public List<String> getMessages() {
        return Arrays.asList("one", "two", "three");
    }

    @RequestMapping("/messages/new")
    public String getNewMessage() {
        return messageGenerator.getNewMessage();
    }

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
