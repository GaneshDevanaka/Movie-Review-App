# Movie-Review-App
The application has been containerized using Docker, with Spring Boot managing the backend and MongoDB serving as the database for storing review data and movie information. The frontend, built with React, interacts with the backend to handle data operations. For movie data, the application utilizes sample datasets from TMDB (The Movie Database) metadata. Key technical features include:

Backend: Developed with Spring Boot, handling API requests and business logic.
Database: MongoDB used for efficient storage and retrieval of review and movie data.
Frontend: React-based interface providing user interactions and data visualization.
Data Integration: Sample movie data integrated from TMDB for enhanced functionality and testing.
Containerization: Docker utilized to package and deploy both frontend and backend components.

# How to Run the Project
Prerequisites
Make sure you have Docker installed on your machine

# Steps to Run the Application
Clone the Repository First, clone this repository to your local machine and navigate to the project directory:

# Run the Application with Docker Compose To build and start the application, run the following command:
docker-compose up --build

This will build the Docker images for both the frontend and backend services, and start the containers.

Access the Application Once the containers are up and running, you can access the application in your browser:

Frontend (Full Application): Open http://localhost:3000 to view the frontend, which will handle the communication with the backend service.

Backend (API - Optional): If you want to access the backend API directly, it's available at http://localhost:8080.

#Database Connection Information
Please note that the database connection has been removed in this version due to the limitations of using a free trial of MongoDB. 

If you plan to use this application with a database, you will need to configure your own MongoDB connection in the backend service. 
