# Spot-Alert 🚨

Spot-Alert is a **full-stack incident reporting and alert management system** designed to enable citizens to report incidents and allow authorities to monitor, verify, and respond through a centralized admin interface.

The project is built as a **distributed system with clear separation of concerns**, consisting of three independently maintained repositories:

* **User-facing frontend** (citizens)
* **Spring Boot backend** (core business logic & APIs)
* **Admin panel** (police / authority dashboard)

This repository acts as the **authoritative project anchor**, providing system-level documentation, architecture, and role attribution.

---

## 🔗 Repositories

| Component         | Description                                     | Repository                                                                                                       |
| ----------------- | ----------------------------------------------- | ---------------------------------------------------------------------------------------------------------------- |
| **Backend API**   | Spring Boot REST APIs, authentication, database | [https://github.com/atharv0825/Spot-Alert-Backend](https://github.com/atharv0825/Spot-Alert-Backend)             |
| **User Frontend** | Citizen reporting UI, alert viewing             | [https://github.com/atharv0825/Spot-Alert-Frontend](https://github.com/atharv0825/Spot-Alert-Frontend)           |
| **Admin Panel**   | Police/admin dashboard for incident management  | [https://github.com/alfajmahabri/Spot-Alert-Admin-Panel](https://github.com/alfajmahabri/Spot-Alert-Admin-Panel) |

---

## ⚙️ Technology Stack

### Backend

* Java 17
* Spring Boot
* Spring Security
* RESTful APIs
* MySQL / relational database

### Frontend (User Panel)

* React
* JavaScript / HTML / CSS
* API integration with backend

### Admin Panel

* React
* Role-based dashboards
* Incident verification and status management

---

## 🧩 Component-wise Breakdown

### 1️⃣ Backend – Spot-Alert-Backend

**Repository:** [https://github.com/atharv0825/Spot-Alert-Backend](https://github.com/atharv0825/Spot-Alert-Backend)

#### Responsibilities

* User authentication and authorization
* Incident CRUD operations
* Status tracking (reported, verified, resolved)
* API exposure for frontend and admin panel

#### Key Features

* REST API design following MVC architecture
* Secure endpoints using Spring Security
* Centralized business logic
* Database schema for users, incidents, and alerts

#### Role Attribution

* Co-developed backend APIs and data flow
* Participated in API design, testing, and integration

---

### 2️⃣ User Frontend – Spot-Alert-Frontend

**Repository:** [https://github.com/atharv0825/Spot-Alert-Frontend](https://github.com/atharv0825/Spot-Alert-Frontend)

#### Responsibilities

* Citizen-facing interface
* Incident reporting forms
* Viewing alert status updates

#### Key Features

* Clean UI for quick reporting
* Backend API integration
* Responsive layout

#### Role Attribution

* UI development and backend integration support
* Feature implementation and testing

---

### 3️⃣ Admin Panel – Spot-Alert-Admin-Panel

**Repository:** [https://github.com/alfajmahabri/Spot-Alert-Admin-Panel](https://github.com/alfajmahabri/Spot-Alert-Admin-Panel)

#### Responsibilities

* Authority-only access
* Incident monitoring and verification
* Status updates and administrative actions

#### Key Features

* Secure admin login
* Incident dashboards
* Filtering, reviewing, and managing reports
* Central control interface for authorities

#### Role Attribution

* **Primary owner and developer**
* Designed admin workflows
* Implemented dashboards and API integration

---

## 🔐 Security & Access Control

* Role-based access (User vs Admin)
* Backend-enforced authorization
* Admin endpoints restricted to authorized personnel

---

## 🚀 Setup Overview (High Level)

1. Clone backend and configure database
2. Start Spring Boot server
3. Run frontend and admin panel separately
4. Connect both clients to backend API

Detailed setup steps are available in each repository.

---

## 📌 Why Multiple Repositories?

This project intentionally uses **multiple repositories** to:

* Reflect real-world microservice-like separation
* Enable parallel development
* Allow independent deployments
* Improve maintainability and scalability

---

## 📄 License

This project is developed for academic and learning purposes.
