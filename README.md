# Smart Lost & Found Backend

A Spring Boot REST API backend for a Smart Lost & Found Management System.  
The application allows users to report lost and found items, find potential matches using AI-based matching, and submit claims for found items.

## 🚀 Features

- User Registration & Login
- JWT Authentication
- BCrypt Password Encryption
- Lost Item Management
- Found Item Management
- AI-based Item Matching
- Claim Management
- User Management
- Dashboard Statistics
- RESTful APIs

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman

## 🏗️ Project Structure

```text
src/main/java/com/smartlostfound
│
├── controller
├── service
├── repository
├── entity
├── dto
├── security
└── exception

**The project follows a layered architecture:**

Controller
    ↓
Service
    ↓
Repository
    ↓
MySQL Database
🔐 Authentication

**The application uses JWT-based authentication.**

Register
   ↓
Password Encryption
   ↓
Login
   ↓
JWT Token
   ↓
Protected APIs

For protected APIs, use:

**Authorization: Bearer <JWT_TOKEN>**
📡 **Main APIs**
Authentication
POST /api/auth/register
POST /api/auth/login
**Lost Items**
POST   /api/lost-items
GET    /api/lost-items
GET    /api/lost-items/{id}
DELETE /api/lost-items/{id}
**Found Items**
POST   /api/found-items
GET    /api/found-items
GET    /api/found-items/{id}
DELETE /api/found-items/{id}
**Claims**
POST /api/claims
GET  /api/claims
GET  /api/claims/my
PUT  /api/claims/{id}/approve
PUT  /api/claims/{id}/reject
**Dashboard**
GET /api/dashboard
Users
GET    /api/users
GET    /api/users/{id}
DELETE /api/users/{id}
🤖 AI Matching

**The system compares attributes of lost and found items such as:**

Title
Category
Brand
Color
Location

and generates a potential match score.

**🗄️ Database**

MySQL is used as the database.

Main entities include:

User
Role
LostItem
FoundItem
Claim
⚙️ Setup
1. Clone the repository
git clone <your-repository-url>
2. Configure MySQL

**Create the database and update application.properties:**

spring.datasource.url=jdbc:mysql://localhost:3306/smart_lost_found
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
3. Run the application
mvn spring-boot:run

The backend will run on:

http://localhost:8080
🧪 API Testing

**APIs were tested using Postman, including:**

Registration
Login & JWT Authentication
Lost Items
Found Items
AI Matching
Claims
Dashboard
User Management
📌 Project Status

Backend development is almost complete and ready for frontend integration.


**Bas `<your-repository-url>` aur `YOUR_PASSWORD` ko GitHub README me actual values se replace mat karna**—password ko kabhi public repository me mat daalna. `YOUR_PASSWORD` placeholder hi rehne do.
