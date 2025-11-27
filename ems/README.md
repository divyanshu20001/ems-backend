# Employee Management System (EMS)

A RESTful API-based Employee Management System built with Spring Boot and PostgreSQL for managing employee records efficiently.

## 📋 Features

- Create new employee records
- RESTful API architecture
- PostgreSQL database integration
- Data validation support
- Lombok integration for cleaner code

## 🛠️ Technologies Used

- **Java 17**
- **Spring Boot 3.5.7**
- **Spring Data JPA** - Database operations
- **PostgreSQL** - Relational database
- **Lombok** - Reduces boilerplate code
- **Maven** - Dependency management

## 📦 Prerequisites

Before running this application, ensure you have:

- Java 17 or higher installed
- PostgreSQL 12+ installed and running
- Maven 3.6+ (or use provided Maven wrapper)
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd ems
```

### 2. Configure Database

Create a PostgreSQL database:

```sql
CREATE DATABASE ems;
```

Update `src/main/resources/application.properties` with your database credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ems
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build the Project

Using Maven wrapper:

```bash
./mvnw clean install
```

Or using Maven:

```bash
mvn clean install
```

### 4. Run the Application

```bash
./mvnw spring-boot:run
```

Or:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 📡 API Endpoints

### Employee Operations

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| POST | `/employee/create` | Create new employee | EmployeeDto |

### Sample Request

**POST** `/employee/create`

```json
{
  "empName": "John Doe",
  "department": "Engineering",
  "salary": 75000.00
}
```

### Sample Response

```json
{
  "empId": "1",
  "empName": "John Doe",
  "department": "Engineering",
  "salary": 75000.00
}
```

## 📁 Project Structure

```
ems/
├── src/
│   ├── main/
│   │   ├── java/com/java/ems/
│   │   │   ├── controller/       # REST Controllers
│   │   │   ├── dto/              # Data Transfer Objects
│   │   │   ├── entity/           # JPA Entities
│   │   │   ├── repository/       # Database Repositories
│   │   │   ├── service/          # Business Logic
│   │   │   │   └── impl/         # Service Implementations
│   │   │   └── exception/        # Custom Exceptions
│   │   └── resources/
│   │       └── application.properties
│   └── test/                     # Test Cases
├── pom.xml
└── README.md
```

## 🔧 Configuration

### Application Properties

Key configurations in `application.properties`:

```properties
spring.application.name=ems
spring.datasource.url=jdbc:postgresql://localhost:5432/ems
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 🧪 Testing

Run tests using:

```bash
./mvnw test
```

## 🐛 Troubleshooting

### Common Issues

1. **Database Connection Error**
   - Ensure PostgreSQL is running
   - Verify database credentials in `application.properties`
   - Check if database `ems` exists

2. **Port Already in Use**
   - Change the port in `application.properties`:
     ```properties
     server.port=8081
     ```

3. **Lombok Not Working**
   - Enable annotation processing in your IDE
   - Install Lombok plugin for your IDE

## 📝 Future Enhancements

- [ ] Add GET, UPDATE, and DELETE operations
- [ ] Implement pagination and sorting
- [ ] Add search and filter functionality
- [ ] Integrate Spring Security for authentication
- [ ] Add Swagger/OpenAPI documentation
- [ ] Implement exception handling
- [ ] Add comprehensive unit and integration tests
- [ ] Add logging framework

## 👤 Author

**Divyanshu**

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

⭐ Star this repository if you find it helpful!

