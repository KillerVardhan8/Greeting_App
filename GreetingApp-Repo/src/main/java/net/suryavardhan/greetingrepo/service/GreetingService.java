package net.suryavardhan.greetingrepo.service;

import net.suryavardhan.greetingrepo.entity.GreetingMessage;
import net.suryavardhan.greetingrepo.repository.GreetingRepository;
import net.suryavardhan.greetingrepo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class GreetingService {
	@Autowired
    private GreetingRepository greetingRepository;

    public String generateGreeting(User user) {
        boolean hasFirst = user.getFirstName() != null && !user.getFirstName().isEmpty();
        boolean hasLast = user.getLastName() != null && !user.getLastName().isEmpty();

        String message;
        if (hasFirst && hasLast) {
            message = "Hello, " + user.getFirstName() + " " + user.getLastName() + "!";
        } else if (hasFirst) {
            message = "Hello, " + user.getFirstName() + "!";
        } else if (hasLast) {
            message = "Hello, " + user.getLastName() + "!";
        } else {
            message = "Hello World!";
        }
        
        

        greetingRepository.save(new GreetingMessage(message));
        return message;
    }
    
    public GreetingMessage saveGreetingMessage(GreetingMessage greetingMessage) {
        return greetingRepository.save(greetingMessage);
    }
    
    public Optional<GreetingMessage> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }
    
    public List<GreetingMessage> getAllGreetingMessages() {
        return greetingRepository.findAll();
    }
    
    public GreetingMessage updateGreetingMessage(Long id, String newMessage) {
        Optional<GreetingMessage> optionalMessage = greetingRepository.findById(id);

        if (optionalMessage.isPresent()) {
            GreetingMessage message = optionalMessage.get();
            message.setMessage(newMessage);
            return greetingRepository.save(message);
        } else {
            throw new RuntimeException("Greeting with ID " + id + " not found.");
        }
    }
    
    public void deleteGreetingMessage(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
        } else {
            throw new RuntimeException("Greeting with ID " + id + " not found.");
        }
    }
}


