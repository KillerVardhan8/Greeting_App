package net.suryavardhan.greeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.suryavardhan.greeting.model.Greeting;
import net.suryavardhan.greeting.service.GreetingService;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {
	
	private final GreetingService greetingService;
	
	@Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
	// GET request
    @GetMapping
    public Greeting getGreeting() {
        return new Greeting("Hello from GET method!");
    }

    // POST request
    @PostMapping
    public Greeting postGreeting(@RequestBody Greeting greeting) {
        return new Greeting("Received via POST: " + greeting.getMessage());
    }

    // PUT request
    @PutMapping
    public Greeting putGreeting(@RequestBody Greeting greeting) {
        return new Greeting("Updated via PUT: " + greeting.getMessage());
    }

    // DELETE request
    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting("Deleted successfully!");
    }
    
    

    @GetMapping("/greet")
    public String greetFromService() {
        return greetingService.getGreetingMessage();
    }

}
