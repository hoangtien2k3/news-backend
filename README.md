![name_logo](name_logo.png)

# News-Backend Microservice

Version：1.0.3（Date：2024-03-11）

## Introduction ⚡ = 💗💎❤️

Welcome to the backend component of `news-microservice`. This Java backend is designed to handle the server-side logic
and data processing for my application.

## Features 🌀

- ✅ Using `Microservices` as a high level architecture

## Getting Started

Follow these steps to set up and run the backend:

1. Clone the repository:

```bash
   git clone https://github.com/hoangtien2k3/news-backend.git
```

#### 1. Navigate to the project directory:

```bash
  cd project-name-backend
```

#### 2. Build the project:

```bash
  # Using Maven
  mvn clean install
  
  # Using Gradle
  gradle build
```

#### 3. Configure the database:

- Update `application.properties` or `application.yml` with your database connection details.

#### 4. Run the application:

```bash
  # Using Maven
  mvn spring-boot:run
  
  # Using Gradle
  gradle bootRun
```

## The Complete Project Folder Structure

```text
src
└── main
    ├── java
    │   └── com
    │       └── example
    │           ├── controller              // Controller/API
    │           ├── model                   // Model/entities
    │           ├── repository              // Repository (JPA)
    │           ├── service                 // Service layer
    │           │   ├── impl                // Implementation của service
    │           │   └── NewsService.java    // Service logic data
    │           └── MainApplication.java    // Spring Boot application class
    └── resources
        ├── application.properties          // Config
        ├── schema.sql                      // Script create table (using JDBC)
        └── data.sql                        // Template data
```

## Example API Request and Response 🚀

- ✅ Signup
    - Request:
      ```text
      curl --location --request POST 'http://localhost:8080/api/auth/signup' \
      --data-urlencode 'name=TestUsername' \
      --data-urlencode 'username=test' \
      --data-urlencode 'email=test@gmail.com' \
      --data-urlencode 'password=test' \
      --data-urlencode 'roles=["ADMIN"]'
      ```
    - Response:
      ```json
      {
        "message": "Username signup successfully."
      }
      ```

- ✅ Login:
    - Request:
        ```text
        curl --location --request POST 'http://localhost:8080/login' \
        --data-urlencode 'email=test@gmail.com' \
        --data-urlencode 'password=test'
        ```
    - Response:
        ```json
        {
           "id": 1,
           "token": "access_token",
           "type": "Bearer",
           "name": "TestUsername",
           "username": "test",
           "email": "test@gmail.com",
           "roles": [
               {
                   "authority": "ADMIN"
               }
           ]
        }
        ```

- ✅ news
    - Request:
      ```text
      curl --location --request GET 'http://localhost:9090/api/news' \
      --header 'Authorization: Bearer access_token'
      ```
    - Response:
      ```json
      [
        {
           "title": "Bộ trưởng Giao thông Vận tải: 'Xây cao tốc phải có trạm dừng nghỉ'",
           "link": "https://vnexpress.net/bo-truong-giao-thong-van-tai-xay-cao-toc-phai-co-tram-dung-nghi-4718836.html",
           "img": "https://i1-vnexpress.vnecdn.net/2024/03/05/bo-truong-thang-1871-170965365-7191-8931-1709655295.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=WR6GddepVipQNOYDWY4wVw",
           "pubDate": "Wed, 06 Mar 2024 00:00:00 +0700"
        }
      ]
      ```

## Technologies Used

- `Java`: The primary programming language.
- `Spring Boot`: Framework for building Java-based enterprise applications.
- `Maven/Gradle`: Build tools for managing dependencies and building the project.
- `Database`: Choose and specify the database system used (e.g., MySQL, PostgreSQL).
- `Other Dependencies`: List any additional dependencies or libraries used.

## API Documentation

Document the API endpoints and their functionalities. You can use tools like `Swagger` for
automated `API documentation`.

## Contributing

If you would like to contribute to the development of this project, please follow our contribution guidelines.

## License

This project is licensed under the [`MIT License`](LICENSE).

```text
MIT License
Copyright (c) 2024 Hoàng Anh Tiến
```

## Contributors ✨

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center"><a href="https://www.linkedin.com/in/hoangtien2k3/"><img src="https://avatars.githubusercontent.com/u/122768076?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Hoàng Anh Tiến</b></sub></a><br /><a href="https://github.com/hoangtien2k3/news-app/commits?author=hoc081098" title="Code">💻</a> <a href="#maintenance-hoangtien2k3" title="Maintenance">🚧</a> <a href="#ideas-hoangtien2k3" title="Ideas, Planning, & Feedback">🤔</a> <a href="#design-hoangtien2k3" title="Design">🎨</a> <a href="https://github.com/hoangtien2k3/news-app/issues?q=author%hoangtien2k3" title="Bug reports">🐛</a></td>
  </tr>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->
