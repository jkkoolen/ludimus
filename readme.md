## Using Redis in Spring Boot 



### Build and run
mvn clean install

#### Configurations

Open the `application.properties` file and set your own configurations.

#### Prerequisites

- Java 8
- Maven > 3.0

#### From terminal

Go on the project's root folder, then type:

    $ mvn spring-boot:run

#### Redis
This app stores all data in a redis db which is a inmem db with persitence to disk


### Google drive access, 
The first time the google drive is accessed the api returns a url. This url must be openened
on the machine where this springboot applications runs to store the credentials on that machine.
For me this is already done. 
``