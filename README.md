# WorkTimeLoggingServer
Main function
This is the entry point for running the HTTP server for managing employee log data.

Usage
To start the server, simply run the Main class. The server will listen on port 8080 by default.

Once the server is running, you can send HTTP requests to it using any client library or tool, such as cURL, Postman, or Python's requests library. The server supports the following HTTP endpoints:

GET /enter?id=<employee_id>: Logs the entrance time for an employee with the specified ID.
GET /exit?id=<employee_id>: Logs the exit time for an employee with the specified ID.
GET /info?id=<employee_id>: Returns a JSON object containing the log data for the employee with the specified ID.
GET /info: Returns a JSON object containing the log data for all employees.
The server responds with an HTTP 200 OK status code if the request was successful, and an HTTP 500 Internal Server Error status code if an error occurred. The response body contains the requested data in JSON format.


Dependencies
The Main function requires the following dependencies to be on the classpath:

com.sun.net.httpserver.HttpServer: The built-in Java HTTP server library.
org.json.*: The JSON library used for parsing and generating JSON data.
