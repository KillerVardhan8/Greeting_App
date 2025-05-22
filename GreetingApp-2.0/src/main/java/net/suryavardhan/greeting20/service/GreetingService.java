package net.suryavardhan.greeting20.service;

import org.springframework.stereotype.Service;
import net.suryavardhan.greeting20.user.User;

@Service
public class GreetingService {
	public String generateGreeting(User user) {
        boolean hasFirst = user.getFirstName() != null && !user.getFirstName().isEmpty();
        boolean hasLast = user.getLastName() != null && !user.getLastName().isEmpty();

        if (hasFirst && hasLast) {
            return "Hello, " + user.getFirstName() + " " + user.getLastName() + "!";
        } else if (hasFirst) {
            return "Hello, " + user.getFirstName() + "!";
        } else if (hasLast) {
            return "Hello, " + user.getLastName() + "!";
        } else {
            return "Hello World!";
        }
    }

}
