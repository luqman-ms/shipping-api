# shipping-api

## System Requirements

Before you begin, ensure you have met the following requirements:

- **Java 11**: You must have Java 11 or a later compatible version installed on your system. You can download and install Java 11 from the official Oracle website or use OpenJDK.

  ```bash
  # Check your Java version
  java -version

### Step 1: Build a JAR File

* Open a terminal or command prompt and navigate to the directory of root project folder `cd shipping-api`. 
* Run the following command to build a JAR file:
  ```bash 
  mvn clean package spring-boot:repackage

### Step 2: Build a Docker Image

* Navigate to the directory containing Dockerfile `cd shipping-api`. 
* Run the following command to build a Docker image:
   ```bash 
   docker build -t shipping-api .

### Step 3: Run a Docker Container

* After building the Docker image, run a Docker container from it using the following command:
  ```bash 
  docker run -p 8080:8080 shipping-api

###  Step 4: Access Swagger UI
Open a web browser and go to the following URL: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

###  Step 5: Authentication

This API requires an API key to access certain endpoints. Please include your API key in the request header as follows:

- **Header**: `X-Api-Key`
- **Value**: `Ky4OZCyLwVVMrSbhuBRr5xtgxubeP59o`
