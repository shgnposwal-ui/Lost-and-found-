# Smart Lost & Found Backend

A Spring Boot REST API backend for a Smart Lost & Found Management System.
The application allows users to report lost and found items, find potential matches using AI-based matching, and submit claims for found items.

## Features

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

## Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman

## Project Structure

src/main/java/com/smartlostfound
│
├── controller
│   ├── auth
│   ├── item
│   ├── claim
│   ├── user
│   └── dashboard
│
├── service
│   ├── auth
│   ├── item
│   ├── claim
│   └── user
│
├── repository
│   ├── auth
│   ├── item
│   └── claim
│
├── entity
│   ├── auth
│   ├── item
│   └── claim
│
├── dto
│   ├── auth
│   ├── item
│   └── claim
│
├── security
└── exception

## Layered Architecture
Controller
     ↓
Service
     ↓
Repository
     ↓
MySQL Database

## Authentication
Register
   ↓
Password Encryption
   ↓
Login
   ↓
JWT Token
   ↓
Protected APIs

## Main APIs
## Authentication
POST /api/auth/register
POST /api/auth/login
## Lost Items
POST   /api/lost-items
GET    /api/lost-items
GET    /api/lost-items/{id}
DELETE /api/lost-items/{id}
## Found Items
POST   /api/found-items
GET    /api/found-items
GET    /api/found-items/{id}
DELETE /api/found-items/{id}
## Claims
POST /api/claims
GET  /api/claims
GET  /api/claims/my
PUT  /api/claims/{id}/approve
PUT  /api/claims/{id}/reject
## Dashboard
GET /api/dashboard
## Users
GET    /api/users
GET    /api/users/{id}
DELETE /api/users/{id}
## AI Matching
The system compares attributes of lost and found items such as:
Title
Category
Brand
Color
Locatio
The matching system generates a potential match score for items.
## Database
MySQL is used as the database.
Main entities:
User
Role
LostItem
FoundItem
Claim
## Configure MySQL
Create the database and update application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/smart_lost_found
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
## Project Status
Backend development is almost complete and ready for frontend integration.
