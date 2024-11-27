
# **User Management System with Spring Boot and MyBatis**

### 🚀 **Overview**
This project is a robust **User Management System** built with **Spring Boot** and **MyBatis**. 
It offers a comprehensive suite of RESTful APIs to manage user data, including features for user creation, 
retrieval, updating, and deletion. Designed for scalability and efficiency, the system also supports batch 
operations and fuzzy search capabilities, making it an excellent choice for enterprise-grade applications.

---

## **Key Features**
1. **RESTful API Endpoints**
   - CRUD operations for user management.
   - Batch processing for inserting, updating, and deleting users.
   - Advanced query support: search by name, age, and fuzzy search.

2. **High Performance with MyBatis**
   - Optimized SQL queries for efficient database interaction.
   - Support for batch inserts and updates using MyBatis' dynamic SQL.

3. **Custom Response Handling**
   - Consistent response format with `BaseResponse`.
   - Distinction between success and failure scenarios.

4. **Scalability**
   - Modular structure with a clear separation of concerns (Controller, Service, Mapper, DTO, and POJO).

5. **Validation and Error Handling**
   - Centralized exception handling for clean and maintainable code.
   - Input validation for secure data processing.

6. **Prebuilt Data Simulation**
   - Automatically generate 100 users for testing purposes.

---

## **Technologies Used**
| Technology         | Description                                                                 |
|---------------------|-----------------------------------------------------------------------------|
| **Java 8**         | Core language for developing the application.                              |
| **Spring Boot 2.3** | Framework for building microservices and RESTful APIs.                    |
| **MyBatis**        | Persistence framework for managing SQL queries and database interactions. |
| **H2 Database** (or MySQL)| Lightweight database for development and testing.                     |
| **Lombok**         | Simplifies Java code with annotations like `@Data` and `@Getter`.          |
| **Swagger**        | API documentation and testing.                                             |

---

## **Project Structure**
```
src/main/java
├── com.mybatis.springboot
│   ├── controller       # REST controllers for handling HTTP requests
│   ├── dto              # Data Transfer Objects for standardized responses
│   ├── mapper           # MyBatis mappers for database interaction
│   ├── pojo             # Plain Old Java Objects representing entities
│   ├── service          # Interfaces for business logic
│   └── service.impl     # Implementation of business logic
└── resources
    ├── mapper           # MyBatis SQL mapper XML files
    ├── static           # Static files (e.g., HTML, CSS, JavaScript)
    └── application.yml  # Spring Boot configuration
```

---

## **API Documentation**
### **Base URL:** `http://localhost:8082`

| Method | Endpoint               | Description                                      |
|--------|-------------------------|--------------------------------------------------|
| `GET`  | `/user`                | Get all users.                                   |
| `GET`  | `/api/selectById`      | Retrieve a user by ID.                          |
| `GET`  | `/api/selectByName`    | Search users by name.                           |
| `GET`  | `/api/selectByLikeName`| Perform a fuzzy search for users by name.       |
| `POST` | `/api/insert`          | Add a new user.                                 |
| `POST` | `/api/insertMany`      | Add multiple users in a batch.                  |
| `POST` | `/api/insertUsers`     | Automatically generate and add 100 users.       |
| `PUT`  | `/api/update`          | Update user details.                            |
| `PUT`  | `/api/updateUsers`     | Update multiple users in a batch.               |
| `DELETE`| `/api/delete`         | Delete a user by ID.                            |
| `DELETE`| `/api/deleteIds`      | Delete multiple users by IDs.                   |

---

## **Setup Instructions**

### Prerequisites
- **Java 8 or higher**
- **Maven**
- **MySQL Database** (or use H2 for testing)

### Steps to Run the Application
1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/user-management-system.git
   cd user-management-system
   ```

2. **Configure Database**
   - Edit `application.yml` to set up your database connection:
     ```yaml
     spring:
       datasource:
         url: jdbc:mysql://localhost:3306/userdb
         username: your-username
         password: your-password
       jpa:
         hibernate:
           ddl-auto: update
     ```

3. **Build the Application**
   ```bash
   mvn clean install
   ```

4. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the Application**
   - API: `http://localhost:8082`
   - Swagger UI: `http://localhost:8082/swagger-ui/`

---

## **Sample Data**
### Default Test Data
Run the `/api/insertUsers` endpoint to generate 100 sample users:
- Example User:
  ```json
  {
      "id": 1,
      "name": "name0",
      "age": 0
  }
  ```

---

## **Error Handling**
| Error Code | Description             |
|------------|-------------------------|
| `10000`    | Operation successful.   |
| `50000`    | Operation failed.       |

### Example Error Response
```json
{
    "isSuccess": false,
    "code": 50000,
    "message": "User not found",
    "data": null
}
```

---

## **Future Enhancements**
1. Add JWT-based authentication for secure API access.
2. Implement pagination for large user datasets.
3. Enhance fuzzy search with advanced filtering options.
4. Integrate frontend using React or Angular for a complete user interface.

---

## **Contributors**
- **Xinyue Zhang** (Author and Developer)

---

## **License**
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
