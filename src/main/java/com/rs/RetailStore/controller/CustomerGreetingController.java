package com.rs.RetailStore.controller;

import com.rs.RetailStore.model.Greeting;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/v1")
public class CustomerGreetingController {
    private static final String greetingContentTemplate = "Hello, %s %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "gender", defaultValue = "0") boolean gender,
                             @RequestParam(value = "customerName", defaultValue = "Customer") String customerName
                            ) {

        return new Greeting(counter.incrementAndGet(),
                String.format(greetingContentTemplate, gender ? "Mr." : "Ms.", customerName));
    }
}
