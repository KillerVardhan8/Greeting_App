# Spring Boot Greeting App – REST API Project

This project demonstrates a basic RESTful API built using Spring Boot. It exposes endpoints to return greeting messages and serves as a starter template for anyone learning Spring Boot's web capabilities.

## Table of Contents

- [Overview](#overview)
  - [GreetingApp](#greetingapp)
  - [GreetingApp-2.0](#greetingapp-20)
  - [GreetingApp-Repo](#greetingapp-repo)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [How to Run](#how-to-run)
- [Next Steps](#next-steps)

## Overview

### GreetingApp
- A simple Spring Boot project with a basic REST controller.
- Returns plain string responses like "Hello, World!".
- Demonstrates the use of `@RestController` and `@GetMapping`.

### GreetingApp-2.0
- Uses a `Greeting` class to return JSON responses.
- Implements Lombok for boilerplate code reduction.
- Demonstrates `@GetMapping` with query parameters for dynamic responses.

### GreetingApp-Repo
- Clean, modular structure using `controller` and `model` packages.
- Acts as a reusable REST API base project.
- Prepares the foundation for future enhancements like validation, error handling, etc.

## Technologies Used

- Java 17 or later
- Spring Boot
- Spring Web (REST API)
- Lombok
- Maven
- Spring Tool Suite (STS) / IntelliJ IDEA

## Features

- Exposes REST endpoints for greeting messages.
- Handles dynamic user input using path/query parameters.
- Returns responses in both plain text and JSON formats.
- Suitable for beginners exploring REST APIs with Spring Boot.

## How to Run

1. **Clone the Repository**
   ```bash
   git clone https://github.com/KillerVardhan8/Greeting_App.git
   cd Greeting_App
