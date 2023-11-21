package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting/{name}/{surname}")
	public Greeting greeting(@PathVariable String name, @PathVariable String surname) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name, surname));
	}
}
