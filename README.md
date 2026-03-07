
# Football Management Microservices Backend 🏟️⚽🔥

[![My Skills](https://skillicons.dev/icons?i=py,docker,spring,postgres,git,github,idea,mongodb,kafka,postman)](https://skillicons.dev)


A **modern, scalable microservices architecture** for comprehensive football management. This backend system provides a robust foundation for building complete football management platforms with support for all key stakeholders including teams, players, matches, tournaments, and more.

---

## ✨ Features

🔹 **Modular Microservices Architecture** - Each domain has its own service (Teams, Players, Matches, Tournaments, etc.)
🔹 **Multi-Database Support** - PostgreSQL for relational data, MongoDB for flexible document storage
🔹 **Secure Authentication** - Keycloak integration for robust user management
🔹 **Event-Driven Architecture** - Built with Spring Cloud Stream for real-time updates
🔹 **Service Discovery** - Eureka server for dynamic service registration and load balancing
🔹 **API Gateway** - Unified entry point with routing, security, and request aggregation
🔹 **Centralized Configuration** - Config Server for environment-specific configurations
🔹 **Comprehensive CRUD Operations** - Full support for all football management operations
🔹 **Dockerized** - Complete containerized deployment with Docker Compose
🔹 **AI Integration** - Built-in AI explainer service for data interpretation
🔹 **Monitoring & Observability** - Ready for integration with monitoring tools
🔹 **OpenAPI/Swagger Support** - Automatic API documentation generation

---

## 🛠️ Tech Stack

### Core Technologies
- **Language**: Java 21
- **Framework**: Spring Boot 3.4+
- **Microservices**: Spring Cloud (Netflix Eureka, Config Server, Gateway)
- **Databases**: PostgreSQL, MongoDB
- **Authentication**: Keycloak
- **Event Streaming**: Apache Kafka (via Spring Cloud Stream)
- **Containerization**: Docker
- **Orchestration**: Docker Compose

### Supporting Tools
- **Build Tool**: Maven
- **Code Generation**: Lombok, MapStruct
- **Database Migration**: Flyway
- **API Documentation**: SpringDoc OpenAPI
- **Testing**: JUnit 5, Mockito
- **Monitoring**: Zipkin (ready for integration)
- **AI Services**: FastAPI (Python)

---

## 📦 Installation

### Prerequisites

Before you begin, ensure you have the following installed:
- [Java JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Maven 3.9+](https://maven.apache.org/install.html)
- [Docker Desktop](https://www.docker.com/products/docker-desktop/) (with WSL2 backend recommended)
- [Git](https://git-scm.com/downloads)
- [Python 3.8+](https://www.python.org/downloads/) (for AI services)

### Quick Start with Docker Compose

1. **Clone the repository**:
   ```bash
   git clone https://github.com/kerfaiyass54/football-app-back.git
   cd football-app-back
   ```

2. **Build all microservices**:
   ```bash
   mvn clean package
   ```

3. **Start the services with Docker Compose**:
   ```bash
   docker-compose up --build
   ```

4. **Access the services**:
   - **API Gateway**: [http://localhost:8080](http://localhost:8080)
   - **Keycloak Admin Console**: [http://localhost:7080](http://localhost:7080)
   - **PostgreSQL**: [http://localhost:5433](http://localhost:5433) (via pgAdmin at [http://localhost:5050](http://localhost:5050))
   - **MongoDB**: [http://localhost:27018](http://localhost:27018) (via Mongo Express at [http://localhost:8081](http://localhost:8081))
   - **AI Explainer Service**: [http://localhost:8000](http://localhost:8000)

### Alternative: Local Development Setup

1. **Set up databases**:
   - PostgreSQL: Configure connection in `application.yml` files
   - MongoDB: Configure connection in `application.yml` files

2. **Configure Keycloak**:
   - Download Keycloak from [https://www.keycloak.org/download](https://www.keycloak.org/download)
   - Import the realm configuration from `config/keycloak/realm-export.json`

3. **Run microservices**:
   ```bash
   # Start Config Server
   cd config-server
   mvn spring-boot:run

   # In separate terminals, start each microservice:
   cd builder && mvn spring-boot:run
   cd discovery-server && mvn spring-boot:run
   cd gateway && mvn spring-boot:run
   # ... and so on for all microservices
   ```



## 🔧 Configuration

### Environment Variables

Configure these in your `.env` file or directly in the microservice `application.yml` files:

```
# Database Configuration
DB_POSTGRES_HOST=postgresql
DB_POSTGRES_PORT=5432
DB_POSTGRES_USER=admin
DB_POSTGRES_PASSWORD=admin

DB_MONGO_HOST=mongodb
DB_MONGO_PORT=27017
DB_MONGO_USER=admin
DB_MONGO_PASSWORD=admin

# Keycloak Configuration
KEYCLOAK_URL=http://localhost:7080
KEYCLOAK_REALM=football-app
KEYCLOAK_CLIENT_ID=football-app-client
KEYCLOAK_CLIENT_SECRET=your-client-secret

# Service Discovery
EUREKA_SERVER=http://localhost:8761/eureka
```

### Configuration Files

Each microservice has its own `application.yml` file. Example from `builder/src/main/resources/application.yml`:

```yaml
spring:
  config:
    import: optional:configserver:http://localhost:8888
  application:
    name: builder-service
  data:
    mongodb:
      host: mongodb
      port: 27017
      database: football_db
      username: admin
      password: admin
    jpa:
      properties:
        hibernate:
          ddl-auto: update
```

### Customization Options

1. **Database Configuration**:
   - Modify connection strings in `application.yml` files
   - Add custom Flyway migrations in `databases_postgresql/init/`

2. **Security**:
   - Configure Keycloak realms and clients
   - Set up JWT validation in the gateway

3. **Performance**:
   - Adjust connection pools in `application.yml`
   - Configure caching strategies

4. **Monitoring**:
   - Add Zipkin tracing configuration
   - Set up Prometheus metrics endpoints

---

## 🤝 Contributing

We welcome contributions from the community! Here's how you can help:

### Getting Started

1. **Fork the repository** and create your feature branch:
   ```bash
   git checkout -b feature/your-feature
   ```

2. **Install dependencies**:
   ```bash
   mvn clean install
   ```

3. **Build and test**:
   ```bash
   mvn package
   ```

### Development Guidelines

1. **Code Style**:
   - Follow Java Code Conventions
   - Use Lombok for boilerplate reduction
   - Keep methods under 20 lines where possible
   - Use consistent logging (SLF4J)

2. **Project Structure**:
   - Each microservice should be self-contained
   - Follow the existing structure for new services
   - Keep configuration centralized where possible

3. **Testing**:
   - Write unit tests for all new functionality
   - Include integration tests for critical paths
   - Test all endpoints with Postman/Newman

4. **Documentation**:
   - Update README with new features
   - Add Swagger/OpenAPI documentation
   - Document any breaking changes

### Pull Request Process

1. **Ensure all tests pass**:
   ```bash
   mvn test
   ```

2. **Update documentation** if applicable

3. **Create a descriptive pull request**:
   - Explain the changes made
   - Reference any related issues
   - Mention any breaking changes

4. **Wait for feedback** and be prepared to make changes

---

