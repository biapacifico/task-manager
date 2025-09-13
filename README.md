# Task Manager

A **To-Do List** project built with **Spring Boot**, providing a REST API for task management, persistence with **MySQL**, and automatic documentation using **SpringDoc OpenAPI 3**.

---

## Technologies Used

- **Spring Boot** – Main framework for application development
- **Spring MVC** – For building REST controllers and endpoints
- **Spring Data JPA** – Database persistence with JPA abstraction
- **MySQL** – Relational database for storing tasks
- **SpringDoc OpenAPI 3** – Automatic API documentation (Swagger UI)

---

## Features

- Create, read, update, and delete tasks
- Filter tasks by status (completed or pending)
- Interactive API documentation with Swagger UI

---

## How to Run

1. **Clone the repository**:

```bash
git clone <repository-url>
cd task-manager
```

2. **Set up the MySQL database**:

Edit `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/task_manager
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. **Run the application**:

```bash
./mvnw spring-boot:run
```

3. **Access the API**:
- REST Endpoints: `http://localhost:8080/tasks`
- Swagger UI: `http://localhost:8080/swagger-ui.html`

---

## API Endpoints

- **Create task:**
```
  POST /tasks {"name": "string", "description": "string", "priority": 1}
 
  [
      {
        "id": 1,
        "name": "string",
        "description": "string",
        "done": false,
        "priority": 1
      }
  ]
```

- **List all tasks:**
```
  GET /tasks
  
  [
      {
        "id": 1,
        "name": "string",
        "description": "string",
        "done": false,
        "priority": 1
      }
  ]
```

- **Update task:**
```
  PUT /task {"name": "string", "description": "string", "done": true, "priority": 2}
  
  [
      {
        "id": 1,
        "name": "string",
        "description": "string",
        "done": true,
        "priority": 2
      }
  ]
```

- **Remove task:**
```
  DELETE /tasks/1
  
  []
```

- **Filter task by status:**
```
  GET /tasks/status?done=true
  
  [
      {
        "id": 1,
        "name": "string",
        "description": "string",
        "done": true,
        "priority": 2
      }
  ]
```