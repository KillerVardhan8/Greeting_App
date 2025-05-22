package net.suryavardhan.greetingrepo.controller;

import net.suryavardhan.greetingrepo.entity.GreetingMessage;
import net.suryavardhan.greetingrepo.model.User;
import net.suryavardhan.greetingrepo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import java.util.List;


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

    @GetMapping
    public String greetDefault() {
        return greetingService.generateGreeting(new User());
    }
    
    @PostMapping("/message")
    public GreetingMessage saveCustomMessage(@RequestBody GreetingMessage greetingMessage) {
        return greetingService.saveGreetingMessage(greetingMessage);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<GreetingMessage> getGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/all")
    public List<GreetingMessage> getAllGreetings() {
        return greetingService.getAllGreetingMessages();
    }
    
    @PutMapping("/update/{id}")
    public GreetingMessage updateGreeting(@PathVariable Long id, @RequestParam String message) {
        return greetingService.updateGreetingMessage(id, message);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreetingMessage(id);
        return "Greeting message with ID " + id + " has been deleted.";
    }

}
