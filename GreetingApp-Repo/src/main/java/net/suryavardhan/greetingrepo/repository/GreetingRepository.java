package net.suryavardhan.greetingrepo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import net.suryavardhan.greetingrepo.entity.GreetingMessage;


public interface GreetingRepository extends JpaRepository<GreetingMessage, Long>{

}
