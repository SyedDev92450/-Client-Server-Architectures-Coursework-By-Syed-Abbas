# -Client-Server-Architectures-Coursework-By-Syed-Abbas

Intro :
The Smart Campus is a RESTful web service made using JAX-RS to help manage a university’s smart infrastructure. The system is based around three core entities: Room, Sensor, and Sensor Reading, which show the places on campus, sensors are deployed within them, and the data collected from those devices.

API Design Overview

The Smart Campus application is a RESTful service built using JAX-RS (Jersey) that manages three core resources: Rooms, Sensors, and Sensor Readings. The API follows this structure: where sensors are linked to rooms, and readings are accessed through sensors using a sub-resource pattern (/sensors/{sensorId}/readings). The application can do CRUD operations, filtering (e.g., by sensor type), and there is consistency when updating a sensor’s current Value whenever a new reading is added. It also has error handling using custom exceptions (409, 422, 403, 500) and logging for all requests and responses.

Build and Run Instructions

To build and run the project, first click on the green button that says "code" and download the project as a zip file, then unzip it before opening the project in NetBeans. You will need to have JDK and Apache Tomcat installed before running the project. Next, you can run the project directly from the IDE by right-clicking the project and selecting Run. Once deployed, you can then access the application at http://localhost:8080/Smart_Campus/api/v1. To run tests on the API, open Postman, and make sure that the header is set to Content-Type: application/json and then run the test. You can check on the NetBeans output that all requests and responses are logged.

Here are five sample curl commands:

Discovery Endpoint:
curl -X GET http://localhost:8080/Smart_Campus/api/v1

Get All Rooms:
curl -X GET http://localhost:8080/Smart_Campus/api/v1/rooms

Get Specific Room:
curl -X GET http://localhost:8080/Smart_Campus/api/v1/rooms/LIB-301

Get All Sensors: 
curl -X GET http://localhost:8080/Smart_Campus/api/v1/sensors

Get Sensor Readings (Sub-resource):
curl -X GET http://localhost:8080/Smart_Campus/api/v1/sensors/TEMP-001/readings


Coursework Question Answer's:

Part 1 Answers :

1.1:

I used JAX-RS, and this creates a new instance of a resource class for every incoming request, which helps make sure the thread is contained as each request works with its own object class. I stored the data in static memory using the MockDatabase class, meaning the data is shared across all requests like a singleton. However, this may cause problems if multiple requests are made to modify the data at the same time. Real-life scenarios need synchronisation to stop any data issues.

1.2:

Hypermedia allows the API responses to have links that show clients what actions they can take next, making the API easy to navigate due to it being self-descriptive. Compared to static documentation, clients can find more available endpoints through responses, such as the Discovery endpoint, which gives users links to /rooms and /sensors. This improves the user experience and develops the API without breaking the existing clients.

Part 2 Answers :

2.1:

Returning only the ID reduces the size of the response and saves the network bandwidth, but it needs the client to make more specified requests to retrieve full details, making it more complex. However, returning the full room objects, this makes it easier for clients to find more relevant data in one response. But having the full room object means higher bandwidth usage; overall, by using it, this improves the usability for the clients.


2.2:

The delete operation in the API is idempotent, as by repeating the same request it does not change the final state. As shown in the application, if a room without sensors is deleted, the first request removes it successfully, and any repeated requests will return a 422 error since the room no longer exists, but, as I mentioned, this does not directly affect the system state, as it remains unchanged. If a room has active sensors, every delete request will return a 409 Conflict, and the room will never be removed. As the outcome does not change, the API is idempotent.

Part 3 Answers :

3.1:

The @Consumes(MediaType.APPLICATION_JSON) annotation makes sure that the API uses JSON input for POST requests. If a client sends invalid JSON input, the request may cause a runtime error, which is handled by the generic exception mapper and returned as a 500 Internal Server Error. If the JSON is valid but has incorrect data (shown in my video), such as an invalid roomId, the API throws a LinkedResourceNotFoundException and returns a 422 error. This makes sure that the right exception handler is used depending on the situation given.

3.2:

Using @QueryParam for filtering (i.e., /api/v1/sensors?type=CO2) is better as it clearly represents a query operation on a collection, compared to defining a new resource path. Query parameters are more dynamic, allowing for multiple filters to be combined without overcomplicating the URLs. However, putting filters in the path (i.e., /sensors/type/CO2) makes the filter more difficult to extend as more filters are added.  So, by using the query parameter, this is good as it finds the resource (/sensors), then the query modifies or adjusts it, for better searching and filtering.

Part 4 Answers :

4.1:

The sub-resource locator pattern improves the API by making the code more modular. This can be seen in the project where SensorResource handles sensors, while SensorReadingResource handles readings, preventing one class from becoming too large and complex. By doing this, the code is easier to read and extend, as new features for readings can be added without affecting the sensor logic. 

Part 5 Answers :

2:

HTTP 422 is better because the request itself is valid, but the data inside it is incorrect. This is seen in my video, when creating a sensor with a roomId that does not exist, the endpoint is correct, and the request format is valid, but the resource is missing. So by using an HTTP 422 response, this is more accurate than a 404 response, as a 404 response is normally used when the endpoint itself does not exist.

4:

Exposing the stack traces can show sensitive internal information such as class names, file paths, and the system structure. Attackers can use this information to understand how the system works and find vulnerabilities to exploit. To stop this, the API uses a generic exception mapper to hide internal errors and return a safe message instead.

5:

Using JAX-RS filters for logging is better as it cements the logging logic instead of repeating it in every resource. The filter is used to automatically log the HTTP method, request URI, and response status for every request, making sure there is consistency in the API. This reduces code duplication and makes the system easier to maintain.

