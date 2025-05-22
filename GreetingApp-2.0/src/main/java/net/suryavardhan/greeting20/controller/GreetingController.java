package net.suryavardhan.greeting20.controller;

import net.suryavardhan.greeting20.user.User;
import net.suryavardhan.greeting20.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {

	    private final GreetingService greetingService;

	    @Autowired
	    public GreetingController(GreetingService greetingService) {
	        this.greetingService = greetingService;
	    }

	    @PostMapping
	    public String greetUser(@RequestBody User user) {
	        return greetingService.generateGreeting(user);
	    }

	    // Optional GET fallback
	    @GetMapping
	    public String greetDefault() {
	        return greetingService.generateGreeting(new User());
	    }
	}

