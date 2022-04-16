# FIBONACCI SPIRAL MATRIX

# OBJECTIVE

The objective of this project is to create a matrix, in which the numbers inside the matrix will be those of the Fibonacci sequence. For this, the user is asked as a starting point to insert the number of rows and columns, from this the matrix is created. The backend is built with Java Spring Boot, and in its frontend Angular, which is embedded in the application. The database is H2.

# MANUAL INSTALLATION

* To execute a new version of the Fibonacci Spiral Matrix project:

- Execute "maven clean install" in the Fibonacci Spiral Matrix project.


- Doing this will automatically copy the jar file to the target folder in the docker compose project (Dockerfiles/target)

* The application at startup should populate the database and create the tables.

# ENDPOINTS

Standalone: http://localhost:8080

Docker: http://localhost:9000

API:

* http://localhost:8080/api/auth/signup
* http://localhost:8080/api/auth/signin
* http://localhost:8080/api/auth/signout
* http://localhost:8080/spiral?rows=5&cols=5

# PORTS

Standalone

* 8080 -> Spring Application

Docker

* 9000 -> Spring Application running internally on port 8080

# FUTURE UPGRADES

1- Add route guards, so that the user cannot simply access the path of his/her choice.

2- When performing a signout invalidate JWT Token in the backend.

3- Add the necessary configuration to handle refresh token.

4- Registration with mail verification.

5- Error handling system.

6- Extend existing roles system (ADMIN, USER), and the permissions of each one.

7- Verify browser support (Chrome, Safari, Firefox, Edge, iOS, IE9+)

# CONSIDERATIONS TO KEEP IN MIND IN THE FUTURE

* As Docker is use, it would be necessary to consider a Docker vulnerability scanning tool, to prevent new vulnerabilities and different hacking scenarios on libraries and operating systems.


* Verify the internal quality of a system by performing static analysis of source code automatically, looking for patterns with errors, bad practices or incidents, using a tool such as SonarQube.


* Employ a tool to identify vulnerabilities of dependencies, so that possible threats can be detected early.
  

* Perform an analysis to determine the possible scalability of the application, and thus establish the necessary resources.


* When considering the deployment of the application in the cloud, evaluate the requirements of the application with the existing options (AWS, AZURE, G.CLOUD), taking into account computing resources, security, storage, support, costs.

# ARCHITECTURE DIAGRAM

![Frontend Angular](https://user-images.githubusercontent.com/10815551/163680428-2580b27c-6670-4cc2-a832-bd2d793b11c2.png)

![Backend Java Spring Boot](https://user-images.githubusercontent.com/10815551/163680434-0366dde5-f635-4084-8c63-43139a886d30.png)

# FIBONACCI SPIRAL MATRIX SEQUENCE DIAGRAM

![Fibonacci Spiral Matrix Sequence Diagram](https://user-images.githubusercontent.com/10815551/163624215-9bffc38e-6799-4fae-bf68-ea336e9bb9c2.png)

# SCREENSHOTS

![2022-04-15 12_12_31-AngularNodejsExample](https://user-images.githubusercontent.com/10815551/163607725-6910d2b8-aba1-4295-94a6-f28144853c65.png)

![2022-04-15 12_12_44-AngularNodejsExample](https://user-images.githubusercontent.com/10815551/163607737-d606b288-5dba-4d1e-b388-44591034811b.png)

![2022-04-15 12_13_10-AngularNodejsExample](https://user-images.githubusercontent.com/10815551/163607747-bd440b45-05fb-4636-9670-72edfe01756b.png)

![2022-04-15 12_13_33-AngularNodejsExample](https://user-images.githubusercontent.com/10815551/163607762-6eaf8d50-23b3-49c8-8590-9771b643e0bc.png)

![2022-04-15 12_13_45-AngularNodejsExample](https://user-images.githubusercontent.com/10815551/163607830-9d360ee4-5951-4663-bfe1-3f717ea4683f.png)


