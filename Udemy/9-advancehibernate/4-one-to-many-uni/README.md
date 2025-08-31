**Advance Mappings**
- One-to-One
- One-to-Many, Many-to-One
- Many-to-Many

**One-to-One Mapping**
- An instructor can have an "instructor detail" entity
- Similar to an "instructor profile"
- Instructor --------> Instructor Detail

**One-to-Many, Many-to-One Mapping**
- An instructor can have many courses 
- Instructor ----> Courses, Courses <-------- Instructor 

**Many-to-Many Mapping**
- A student can have many students
- A student can have many courses 
- Courses <------> Students

**Primary Key and Foreign Key**
- Primary key : identify a unique row in a table
- Foreign Key : 
  - Link tables together
  - a field in one table that refers to primary key in another table
  - Eg, 
    - Table : instructor (id(PK), first_name, last_name, instructor_detail_id(FK))
    - Table : instructor_detail(id(PK), youtube_channel, hobby)
    - "instructor_detail_id" of instructor table has link with "id" in instructor_detail table

**Cascade**
- You can cascade operations    
- Apply the same operation to related entities
- If we delete an **instructor**, we should also delete their instructor_detail
  - This is known as "CASCADE DELETE"

**Cascade Delete**
- It depends on the use case
- If we delete a student so should we delete the course, he enrolled - NO WAY!

**Fetch Types : Eager vs Lazy Loading**
- When we fetch/retrieve data, should we retrieve EVERYTHING?
- Eager will retrieve everything
- Lazy will retrieve on request

**Uni-Directional**
- We have "instructor" from which we can load/access the "instructor detail"

**Bi-Directional**
- We have "instructor" and "instructor detail" we can access/load information from any table to another table

**More on Foreign Key**
- Main purpose is to preserve relationship between tables
  - Referential Integrity
- Prevents operation that would destroy relationship
- Ensures only valid data is inserted into the foreign key column
  - Can only contain valid reference to primary key in another table

**Entity Lifecycle**
- Detach : If entity is detached, it is not associated with Hibernate session
- Marge : If instance is detached from session, then merge will reattach to session
- Persist : Transitions new instances to managed state. Next flush/commit will save in db
- Remove : Transitions managed entity to be removed. Next flush/commit will delete from db
- Refresh : Reload/sync object with data from db. Prevents stale data

**@OneToOne - Cascade Types**
- PERSIST : If entity is persisted/saved, related entity will also be persisted 
- REMOVE : If entity is removed/deleted, related entity will also be deleted
- REFRESH : If entity is refreshed, related entity will also be refreshed
- DETACH : If entity is detached(not associated with session) then related entity will also be detached
- MERGE : If entity is merged, then related entity will also be merged
- ALL : All of the above cascade types

**mappedBy in @OneToOne Annotation**
- Eg, @OneToOne(mappedBy="instructorDetail") : refers to "instructorDetail" property in "Instructor" class
- mappedBy tells Hibernate
  - Look at the instructorDetail property in the Instructor class
  - Use information from the Instructor class @JoinColumn
  - To help find associate instructor