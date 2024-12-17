# Weather Fetcher Application

This is a Java Spring Boot application that fetches weather data for US postal codes and stores request history in a database.

## Features
- Fetch current weather for a US postal code.
- Store request history in an H2 database.
- View request history by user or postal code.

## Setup
1. Clone the repository.
2. Add your API key in `WeatherService.java`.
3. Build and Compile with `mvn clean install`.
4. Run the application with `mvn spring-boot:run`.

## API Endpoints
1. `POST /api/weather/fetch` - Fetch weather data.
   - Parameters: `postalCode` (required), `user` (required)
2. `GET /api/weather/history` - View history.
   - Parameters: `userName` (optional)
   - Parameters: `postCode` (optional)

## Testing
Run tests with:
```bash
mvn test

## Following endpoints can be verified once the app is up and running

1. Health check API: you can check health of the back end spring boot server using following url

http://localhost:8080/actuator/health

2. You can fetch the Weather details of US using US postal codes, need to pass the user and postcode details

http://localhost:8080/api/weather/fetch?userName=Fazul&postalCode=00501

3. You can fetch the history of Weather details of particular postal codes, need to pass postcode details

http://localhost:8080/api/weather/fetch?userName=Fazul&postalCode=00501

4. You can fetch the history of Weather details of particular user, need to pass postcode details

http://localhost:8080/api/weather/historyByUserName?userName=Fazul
