**Application Architecture**
- Employee REST Controller  <------> Employee Service
- Employee Service <-------> Employee DAO (JPA)
- Employee DAO (JPA) <------> Database

**Common Pitfall - Partial Update Employee**
- If we only partial update ... only the email address
- Notice the other fields will be null

**Partial Updates - Patch**
- For partial updates, need to use HTTP PATCH
- Comparison 
  - PUT : Replaces the entire resource
  - PATCH : Modifies only specified parts of resource(partial)
- Benefits of PATCH
  - Efficiency : Reducing bandwidth by sending only partial changes 
  - Flexibility : Allows multiple partial updates in a single request

**ObjectMapper**
- ObjectMapper is a helper class in the Jackson library for JSON processing
- ObjectMapper provides following support
  - Converts Java objects to JSON and vice versa
  - Allows merging of JSON nodes
  - Provides type safety for conversions : Java <-> JSON
- The ObjectMapper is preconfigured by Spring Boot