**Hibernate**
- A framework for persisting/saving Java objects in a database
- Benefits
  - Hibernate handles all the low-level SQL
  - Minimizes the amount of JDBC code you have to develop
  - Hibernate provides the Object-to-Relational Mapping(ORM)

**Object-To-Relational Mapping (ORM)**
- The developer defines mapping between class and database table

**JPA**
- Jakarta Persistence API(JPA) ... previously known as Java Persistence API
- Standard API for Object-To-Relational Mapping (ORM)
- Only a specification
  - Defines a set of interfaces
  - Requires an implementation to be usable

**Hibernate/JPA and JDBC relation**
- Hibernate/JPA uses for all database communications

**EntityManager vs JpaRepository**
- EntityManger
  - Need low-level control over the db operations and want to write custom queries
  - Provides low-level access to JPA and work directly with JPA entities
  - Complex queries that required advanced features such as native SQL queries or stored procedure calls
  - When you have custom requirements that are not easily handled by higher-level abstractions
- JpaRepository
  - If you want high-level of abstraction, use JpaRepository
  - Provides commonly used CRUD operations out of the box, reducing the amount of code you need to write
  - Additional features such as pagination, sorting
  - Generate queries based on method names
  - Can also create custom queries using @Query