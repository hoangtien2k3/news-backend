<div style="display: flex; justify-content: center;">
    <img src="news_app_logo_round.png" alt="name_logo" style="width: 80px; height: auto; margin-right: 10px;" />
    <img src="name_logo.png" alt="name_logo" style="width: 400px; height: auto; margin-right: 10px;" />
</div>

# News-Backend Microservice
Version：1.0.0（Date：2024-03-11）

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

```text
cd news-backend
```

#### 2. Build the project:

```text
# Using Maven
mvn clean install
```

#### 3. Configure the database:

- Create the following database:
    ```sql
    CREATE DATABASE userservice;
    CREATE DATABASE newsservice;
    CREATE DATABASE searchservice;
    CREATE DATABASE notificationservice; 
    ```
- Update `application.yml` with your database connection details (Change [username]() and [password]()).

#### 4. Run the application:

- service run order:
    - config-service
    - discovery-service
    - api-service
    - user-serivce
    - search-service
    - notification-service
    - news-service

```text
# Using Maven
mvn spring-boot:run
```

## Configure `docker-compose` connect [Zipkin](https://zipkin.io/) server:

- Move to `news-backend` folder
    ```text
    cd news-backend
    ```

- Open `docker desktop`
- Run the `docker-compose` file on the terminal
    ```text
    docker-compose up -d 
    ```
  ![img_run_docker_compose.png_](img_run_docker_compose.png)

- Container docker desktop
  ![img_docker_desktop.png](img_docker_desktop.png)

- access to server:
    - zipkin: http://localhost:9411/zipkin/
    - eureka: http://localhost:8761/

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

## Diagram News-Backend

![diagram.png](diagram.png)

## Example API Request and Response 🚀

- ✅ Signup
    - Request:
      ```text
      curl --location --request POST 'http://localhost:8080/api/auth/signup' \
      --data-urlencode 'name=Hoang Anh Tien' \
      --data-urlencode 'username=hoanganhtien' \
      --data-urlencode 'email=hoanganhtien@gmail.com' \
      --data-urlencode 'password=12345678' \
      --data-urlencode 'roles=["USER"]'
      ```
    - Response:
      ```json
      {
        "code": 200,
        "message": "success",
        "data": {
          "id": 5,
          "name": "Hoang Anh Tien",
          "username": "hoanganhtien",
          "email": "hoanganhtien@gmail.com",
          "roles": [
            "USER"
          ],
          "timestamps": {
            "created_at": "2024-04-04T01:23:45.992125",
            "updated_at": "2024-04-04T01:23:45.992147"
          }
        }
      }
      ```

- ✅ Login:
    - Request:
        ```text
        curl --location --request POST 'http://localhost:8080/login' \
        --data-urlencode 'email=hoanganhtien@gmail.com' \
        --data-urlencode 'password=12345678'
        ```
    - Response:
        ```json
        {
           "code": 200,
           "message": "success",
           "data": {
               "authenticated": true,
              "token": "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJob2FuZ3RpZW4yazMuY29tIiwic3ViIjoiaG9hbmdhbmh0aWVuIiwiZXhwIjoxNzE0NzYwODIzLCJpYXQiOjE3MTIxNjg4MjMsInNjb3BlIjoiVVNFUiJ9.pdsyUBc-3rZbO0mmOS2SMK3mUri-0LQOjbAWZkUCJZAnUk8SuLpQotfo-NnYp4M613UJF76iVYI9Qf9BWFZtew"
           }
        }
        ```

- ✅ news
    - Request:
      ```text
      curl --location --request GET 'http://localhost:9090/api/news/full' \
      --header 'Authorization: Bearer access_token'
      ```
    - Response:
      ```json
      {
         "code": 200,
         "message": "success",
         "totalRecords": 730,
         "data": [
             {
                 "title": "Bộ trưởng Giao thông Vận tải: 'Xây cao tốc phải có trạm dừng nghỉ'",
                 "link": "https://vnexpress.net/bo-truong-giao-thong-van-tai-xay-cao-toc-phai-co-tram-dung-nghi-4718836.html",
                 "img": "https://i1-vnexpress.vnecdn.net/2024/03/05/bo-truong-thang-1871-170965365-7191-8931-1709655295.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=WR6GddepVipQNOYDWY4wVw",
                 "pubDate": "Wed, 06 Mar 2024 00:00:00 +0700"
             }
         ]
      }
      ```

## Technologies Used

- `Java`: The primary programming language.
- `Spring Boot`: Framework for building Java-based enterprise applications.
- `Maven/Gradle`: Build tools for managing dependencies and building the project.
- `Database`: Choose and specify the database system used (e.g., MySQL, PostgreSQL).
- `Other Dependencies`: List any additional dependencies or libraries used.

## Frontend - (Android App):

Clone this repository: https://github.com/hoangtien2k3/news-app

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
    <td align="center"><a href="https://www.linkedin.com/in/hoangtien2k3/"><img src="https://avatars.githubusercontent.com/u/122768076?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Hoàng Anh Tiến</b></sub></a><br /><a href="https://github.com/hoangtien2k3/news-app/commits?author=hoangtien2k3" title="Code">💻</a> <a href="#maintenance-hoangtien2k3" title="Maintenance">🚧</a> <a href="#ideas-hoangtien2k3" title="Ideas, Planning, & Feedback">🤔</a> <a href="#design-hoangtien2k3" title="Design">🎨</a> <a href="https://github.com/hoangtien2k3/news-app/issues?q=author%hoangtien2k3" title="Bug reports">🐛</a></td>
  </tr>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->
<!-- ALL-CONTRIBUTORS-LIST:END -->