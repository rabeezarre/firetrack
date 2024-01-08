# FireTrack - Wildfire Management System

## Table of Contents
- [About](#about)
  - [Features](#features)
  - [Sub-Systems](#sub-systems)
- [Project Status](#project-status)
- [Deployment](#deployment)
- [Technology Stack](#technology-stack)
- [Installation and Setup](#installation-and-setup)
- [Usage](#usage)
  - [Important Links](#important-links)
- [Contributing](#contributing)
- [License](#license)
- [Authors and Acknowledgment](#authors-and-acknowledgment)


## About
FireTrack is an integrated wildfire management system designed to assist in the monitoring, early detection, and efficient response to wildfires. Developed by rabeezarre, the project encompasses both frontend and backend components and uses a variety of technologies including Spring Boot, Java 17, Gradle, Vue.js, SCSS, and Bootstrap.

### Features
- Real-time monitoring of forest conditions.
- Tracking points inspections in the forest using mobile devices.
- Timely emergency alerts for rapid response to wildfire incidents.

### Sub-Systems
- **Web**: Interactive map displaying tracking points information.
- **Mobile**: Tracking service for marking checked tracking points in real-time.
- **Backend**: Centralized database for web and mobile interfaces, built with Spring Boot using Java 17 and Gradle.
- **Embedded Programming**: Utilizes LoRaWAN protocol for scalable data sharing.

## Project Status
In Progress

## Deployment
FireTrack is deployed on CleverCloud. Access the live application here: [firetrack.cleverapps.io](https://firetrack.cleverapps.io/)

## Technology Stack
- Backend: Java 17, Spring Boot, Gradle
- Frontend: Vue.js, SCSS, Bootstrap
- Database: H2 Database
- API Documentation: Swagger

## Installation and Setup
### Backend
1. Clone the backend repository: `git clone https://github.com/rabeezarre/firetrack-backend.git`
2. Navigate to the project directory: `cd firetrack-backend`
3. Build the project using Gradle: `./gradlew build`
4. The backend uses the build version of the frontend. To redeploy, add the build files to `src/main/resources/static`.

### Frontend
1. Clone the frontend repository: `git clone https://github.com/rabeezarre/firetrack-frontend.git`
2. Navigate to the project directory: `cd firetrack-frontend`
3. Install dependencies: `npm install`
4. To compile and hot-reload for development: `npm run serve`
5. To compile and minify for production: `npm run build`
6. To lint and fix files: `npm run lint`
7. After building for production, copy the build files to the backend's `src/main/resources/static` directory.

## Usage

FireTrack provides various RESTful API endpoints:


### User Controller
- **GET** `/api/users/{userId}`: Retrieve user details by user ID.
- **PUT** `/api/users/{userId}`: Update user details.
- **DELETE** `/api/users/{userId}`: Delete a user.
- **POST** `/api/users/register`: Register a new user.
- **POST** `/api/users/login`: User login.

### Tracking Point Controller
- **GET** `/api/trackingPoints/{pointId}`: Get details of a specific tracking point.
- **PUT** `/api/trackingPoints/{pointId}`: Update a tracking point.
- **DELETE** `/api/trackingPoints/{pointId}`: Delete a tracking point.
- **GET** `/api/trackingPoints`: Retrieve all tracking points.
- **POST** `/api/trackingPoints`: Create a new tracking point.

### Alert Controller
- **PUT** `/api/alerts/{alertId}`: Update an alert.
- **GET** `/api/alerts`: Get all alerts.
- **POST** `/api/alerts`: Create a new alert.
- **GET** `/api/alerts/trackingPoint/{pointId}`: Get alerts for a specific tracking point.
- **GET** `/api/alerts/active`: Retrieve active alerts.

### Sensor Data Controller
- **POST** `/api/sensorData`: Submit new sensor data.
- **GET** `/api/sensorData/{pointId}`: Retrieve sensor data for a specific point.

### Scanning History Controller
- **GET** `/api/scanningHistory`: Get all scanning history records.
- **POST** `/api/scanningHistory`: Create a new scanning history record.
- **GET** `/api/scanningHistory/user/{userId}`: Get scanning history by user.
- **GET** `/api/scanningHistory/point/{pointId}`: Get scanning history for a specific point.

### Important Links
- Swagger UI for API documentation: `/swagger-ui/index.html#/`
- H2 Database Console: `/h2-console/`

## Contributing

We welcome contributions from everyone who is interested in improving or enhancing FireTrack. Here are some ways you can contribute:

1. **Reporting Bugs**
2. **Suggesting Enhancements**
3. **Submitting Pull Requests**
4. **Code Reviews**
5. **Documentation**

### Contribution Guidelines

- Respect the code of conduct.
- Before starting work on a significant change, please open an issue for discussion.
- Keep the changes small and focused; larger changes are harder to review and merge.

## License
This project is licensed under the MIT License.

## Authors and Acknowledgment
- Author: rabeezarre [GitHub user](https://github.com/rabeezarre)

For more details and updates, please refer to the [backend repository](https://github.com/rabeezarre/firetrack-backend) and the [frontend repository](https://github.com/rabeezarre/firetrack-frontend) on GitHub.
