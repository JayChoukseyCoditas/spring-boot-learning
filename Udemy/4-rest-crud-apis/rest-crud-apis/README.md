**REST over HTTP**
- Most common use of REST is over HTTP
- Leverage HTTP methods for CRUD operations
  - POST : Create a new entity
  - GET : Read a list of entities or single entity
  - PUT : Update an existing entity
  - DELETE : Delete an existing entity

**HTTP Messages**
- Three main part of Request message:
  - Request line : the HTTP command
  - Header variables : request metadata
  - Message body : contents of message
  - Three main part of Response message
      - Request line : server protocol and status code
      - Header variables : response metadata
      - Message body : contents of message

**HTTP Response - Status Codes**
- 100-199 : Informational
- 200-299 : Successful
- 300-399 : Redirection
- 400-499 : Client error
- 500-599 : Server error

**MIME Content Types**
- The message format is described by MIME content type 
  - Multipurpose Internet Mail-Extension
- Basic Syntax : type/subtype
- Examples
  - text/html,text/plain
  - application/json,application/xml

**Java JSON Data Binding**
- Data binding is the process of converting JSON data to a Java POJO
  - JSON <-------(data binding)------> Java POJO
- Also known as Serialization/Deserialization, Marshalling/Unmarshalling

**JSON Data Binding with Jackson**
- Spring uses the Jackson Project behind the scenes
- Jackson handles data binding between JSOM and Java POJO
- Spring Boot Started Web automatically includes dependency for Jackson

**Jackson Data binding**\
{\
&emsp;"id" : 14,\
&emsp;"firstName" : "Mario",     -----------------> Java POJO\
&emsp;"lastName" : "Rossi",      <----------------- (Student)\
&emsp;"active" : true\
}

**JSON to Java POJO**
- Convert JSON to Java POJO ... call setter methods on POJO (Jackson will do this work)
- **NOTE** : Jackson calls the setXXX methods. It does NOT access internal private fields directly

**Java POJO to JSON**
- Convert Java POJO to JSON ... call getter methods on POJO

**Spring and Jackson Support**
- When building Spring REST applications
- Spring will automatically handle Jackson Integration
- JSON data being passed to REST controller is converted to POJO
- Java object being returned from REST controller is converted to JSON

**Path Variables**
- Retrieve a single student by id
- **GET** /api/students/**{studentId}** --> Known as a "path variable"
  - /api/students/0
  - /api/students/1
  - /api/students/2

**Spring REST Exception Handling**
- for each controller 
  - REST Client(start point) -------(/api/students/999)-----> REST Service(End point) -----> Throws Exception -----(throws exception)-----> Exception Handler --------> Rest Client(start point)
- for global
  - Rest Client(start point ) -------(/api/students/999)-----> Controller Advice(intermediate point) ----> REST Service(end point) ------(throws exception)------> Controller Advice(Exceptional Handlers) --------> REST Client

