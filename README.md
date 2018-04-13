# Network Client Service (A calculator that supports add, subtract…)

# Requirement

>Server application that accepts requests over the network and sends those request to second server. Have the second server respond to the requests of the client via the first server.
>
>The request should be a simple operation e.g. multiple two numbers.
>The application should be able to handle multiple concurrent requests.
>
>The exercise can be over engineered to show specific design choices.
>
>Write as if this was a production piece of code.
>


The application consists in 2 servers listening in 2 different ports for REST POST requests.
For simplicity both request accept same body and return same type result.


# Technologies
-  Spring Boot Framework.
-  Maven, as build automation tool. 
 -  Git, control version.
-  Mockito, test framework. Integrated in Spring Boot.

# Design
-  Use of Spring RestTemplate for communication. 
# Design Considerations
- Current Implementation is developed as synchronized(blocking way) so each request is blocked until it gets the response. It uses Spring RestTemplate,  that is thread-safe.
For current requirements this is acceptable, however if new requirements of scaling or adding a new complex operation that could take some time to process we should implement the rest controller an async  non-blocking way using AMQP.(Rabbit MQ)
In current implementation there is no service registry, however if new services are added service registry should be considered. Ex:- Netflix Eureka, Apache Zookeeper.

# Structure
Client Input Server consists of following :-
- Rest Controller
  - Accepts POST request in a simple JSON format, for example `{ "numbers": [89, 91] }`. There user can specify the a list of numbers that will be involve in the mathematical operations specified in request (pathParams) such as Add, Subtract, Multiply….. 
  - Request Validation. If an invalid operation requested or If the array of numbers is empty. A custom error will be displayed with custom error code explaining the reason.
 - Invokes Business Logic to do the operation

- Service
- Contains a business logic to sends a POST request to Functional Server. It gets the URL of Functional Server from application properties. 

- Data Transfer Objects (DTO’s). 
 - For sending the numbers for validation to validator.
- For sending the numbers for functional operation.

- Custom Exceptions and Validations. 

Functional Server consists of following :-
- Rest Controller
  - Used in inter-process of servers and process requests from Client Input Server
  - Accepts POST request in a simple JSON format. 
  - Request Validation. If an invalid operation requested or If the array of numbers is empty. A custom error will be displayed with custom error code explaining the reason.
 - Invokes Business Logic to do the operation

- Service
- Contains a business logic to perform pre-defined operations based on request. 

- Data Transfer Objects (DTO’s). 
 - For sending the numbers for validation to validator.
- For sending the numbers for functional operation.

- Custom Exceptions and Validations.

Note :- Functional Server contains some duplicate code for simplicity and keeping in mind that Functional Server end point can be invoked by its own. 

# Test
Both the servers contains unit tests to test requests and business logic. Tests can be executed using ‘mvn test’ command.

#Logging
Both the servers contains logging file and implemented for daily log rotations.

#packaging
Both the servers contains assembly file for packaging an 



Endpoints :

- Client Input Server 
http://localhost:8080/userinput/{operation}

Valid operations are :- add, subtract, multiply, divide 

- Functional Server 
http://localhost:8080/functional/{operation}

Valid operations are :- add, subtract, multiply, divide 




## How to execute it
Requires Java 8 and Maven.

First clone the project: `git clone https://github.com/jagdishaswani/codetest.git`.

- Running the servers from spring-boot run mvn command

Navigate to main folder: `cd \${PROJECT_HOME}\FunctionalServer`.
* From command line run:  `mvn spring-boot:run`

Navigate to main folder: `cd \${PROJECT_HOME}\UserInputServer`.
* From command line run:  `mvn spring-boot:run` 

*Above commands will start the servers.

- Running the servers from executable jar.

-FunctionalServer
Navigate to main folder: `cd \${PROJECT_HOME}\FunctionalServer`.
* From command line run:  `mvn clean package` for generating the jar.
* `cd \${PROJECT_HOME}\FunctionalServer\target`
* From command line run `java -jar FunctionalServer-1.0.0.RELEASE.jar`

-UserInputServer
Navigate to main folder: `cd \${PROJECT_HOME}\UserInputServer`.
* From command line run:  `mvn clean package` for generating the jar.
* `cd \${PROJECT_HOME}\UserInputServer\target`
* From command line run `java -jar UserInputServer-1.0.0.RELEASE.jar` 



UserInputServer starts in port 8080, this port can be changed in file */resources/application.properties* property *server.port*
FunctionalServer starts in port 8090, this port can be changed in file */resources/server2.properties* property *server.port*

For testing it: POST request to url `http://localhost:8080/userinput/multiply` with body
```
{"numbers": [10, 10]}
```
