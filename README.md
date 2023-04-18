# CSC1004-JavaProj
Java project for grading.

I didn't use the standard naming required since I seperated my frontend and backend, and this is the back end application.

The front application can be found [here](https://github.com/AlexDWasTaken/JavaMessager-front). 
Note that this repository is currently private.

# Regarding comments

Actually, springboot made my project pretty clean.

Most code is self-explanatory. I only wrote a few lines to describe what each part does.

# Run the project

Nothing special. Please note the app runs on port 8080, and you need a mysql server running on port 3306.

Please create a user called springuser with password called 'ThePassword'. The source database should be called db_example.

# Regarding structure

- package Configuration contains the configuration classes for socket and cross-origin policy.
- package Controller contains for classes
  - apiTest: test whether the application is running
  - AuthController: control the authentication behavior
  - SocketController: receive and send messages
  - UserController: handle login and register behavior
- package DAO interacts with Mysql using Spring Data JPA
- package DTO includes the Entity user, which works with Spring Data JPA
- package Requests models the requests sent by user
- package Result models the requests to be sent back to user
- JwtUtils handles the token parsing process
