# E-commerce Microservices Application

## Description
This project is an e-commerce application that leverages microservices architecture. It includes product management, inventory management, order processing, notifications, and payment processing services. The application is built using Java 17, Spring Boot 3.2.5, and incorporates several microservices patterns such as API Gateway, Service Discovery with Eureka, Circuit Breaker with Resilience4j, Spring Cloud Config Server, synchronous and asynchronous communication using Kafka, logging, Spring Security, observability, monitoring, and Dockerization.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Microservices Architecture](#microservices-architecture)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/your-repo.git
Navigate to the project directory:
bash
Copy code
cd your-repo
Build the services:
bash
Copy code
./mvnw clean install
Run Docker Compose to start the services:
bash
Copy code
docker-compose up --build
Ensure you have the following prerequisites installed:

Java 17
Docker and Docker Compose
Apache Kafka
Maven
Usage
Access the API Gateway:
Open your browser and go to http://localhost:8080.

API Endpoints:

Product Service: http://localhost:8080/products
Inventory Service: http://localhost:8080/inventory
Order Service: http://localhost:8080/orders
Notification Service: http://localhost:8080/notifications
Payment Service: http://localhost:8080/payments

## Microservices Architecture
* API Gateway: Acts as the single entry point for all clients.
* Discovery Service (Eureka): Registers and discovers microservices.
* Config Server: Centralized configuration management.
* Product Service: Manages product information.
* Inventory Service: Manages inventory levels.
* Order Service: Handles order processing.
* Notification Service: Sends notifications.
* Payment Service: Processes payments.
* Circuit Breaker (Resilience4j): Provides fault tolerance.
* Logging: Centralized logging using ELK stack.
Observability and Monitoring: Metrics and monitoring using Prometheus and Grafana.
