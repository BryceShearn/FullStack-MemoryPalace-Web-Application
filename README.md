# Memory Palace Application

<img src="https://images.unsplash.com/photo-1562932831-afcfe48b5786?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1389&q=80" width="100%"></img> 

## Purpose Overview
This Application was created to help users improve memory through the use of a "Mind Palace" or "Memory Palace" referencing the Ancient Greek Strategy known as 'The Method of Loci'. If you've ever heard someone say "In the first place", this is precisely what they were referencing! Practicing this strategy regularly can significantly increase the recollection of information through the use of familiar smatial environments. The goal of this project is to help practice this method through repetition using their visible Mind Palace Map as a reference to their improvement! This is a Two Step implementation Application to which Step 1 has been completed. Step 2 will begin on April 9th 2021 which will create and implement the Front-End GUI via Angular JS.

### Technology Overview:

This program is designed to be a REST API that creates, reads, updates and deletes user and beverage data from a database built using MySQL Workbench and connecting with using Spring Data JPA.

## How to Run
1. The user begins by logging in or creating their account
2. The user is then able to create or enter their Familiar Spatial MAIN Object (ex. A large Familiar Location like your Home)
3. Upon entering the Familiar Spatial MAIN Object the user will be allowed to add or delete rooms to their MAIN Object.
4. Upon entering individual rooms, the user will be able to place Stimulating and Engaging Objects.
5. Once all items are placed in their respective rooms, the user can display an overview of their Mind Palace.

TODO: LINK TO DEPLOYED APP

## REST API

| HTTP Method |          Resource URI             | Request Body                      |       Returns             |
|-------------|-----------------------------------|-----------------------------------|---------------------------|
| GET         |`api/users/{userId}/rooms`         | Lists all rooms for user          | List&lt;Room&gt;          |
|-------------|-----------------------------------|-----------------------------------|---------------------------|
| GET         |`api/rooms/{roomId}/items`         | Lists all items in room for user  | List&lt;Item&gt;          |
|-------------|-----------------------------------|-----------------------------------|---------------------------|
| POST        |`api/rooms/{roomId}/items`         | Add a room for user               | Room Updated Object       |
|-------------|-----------------------------------|-----------------------------------|---------------------------|
| POST        |`api/rooms/{roomId}/items`         | Add an item to room for user      | Item Updated Object       |
|-------------|-----------------------------------|-----------------------------------|---------------------------|
| DEL         |`api/users/{userId}/rooms/{roomId}`| Delete a room for user            | Boolean verifying deletion|
|-------------|-----------------------------------|-----------------------------------|---------------------------|
| DEL         |`api/rooms/{roomId}/items/{itemId}`| Delete an item from room for user | Boolean verifying deletion|
|-------------|-----------------------------------|-----------------------------------|---------------------------|

### Technologies used:

Java, Java Persistence API, REST API, Spring Boot, Gradle, MySQL Workbench, Postman, JSON, Apache, Tomcat, AWS, Atom, Git, and GitHub.

### Topics implemented:

-   Spring REST annotations.

-   Spring Data JPA to perform all CRUD operations.

-   Send and receive JSON.

-   Tomcat 8 on AWS EC2 Instance.

-   Object-Relational Mapping (ORM).

-   Relational Database: SQL Database creation using MySQL Workbench.

-   Object-Oriented Programming in Java: Abstraction, Polymorphism, Inheritance, and Encapsulation.

-   Test Driven Development using JUNIT Juniper.

### Lessons learned:

This project helped me better grasp the capabilities of REST API by allowing me to better learn how to:

-   Create a JPA Project

    -   Create a Java entity class POJO that models your database table.
    -   Map your POJO using JPA.

-   Configure a Spring Boot app to publish a REST API.
    -   Use Spring REST annotations.
    -   Use Spring Data JPA to perform all CRUD operations.
    -   Send and receive JSON.

