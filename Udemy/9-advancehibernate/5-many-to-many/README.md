**Join Table**
- A table that provides a mapping between two tables
- It has foreign keys for each table to define the mapping relationship


**More @JoinTable**
- @JoinTable tells Hibernate
  - Look at the course_id column in the **course_student** table
  - For other side(inverse), look at the student id column in the **course_student** table
  - Hibernate use this information to find relationship between course and students

**More on "inverse"**
- In this context, we are defining relationship in the **Course** class
- The **Student** class is on the "other side" ... so it is considered the "inverse"
- "Inverse" refers to the "other side" of the relationship

**Owning Side and Inverse/Non-Owning Side**
- Every many-to-many association has two sides:
  - The owning side and the inverse/non-owning side
- If the association is bidirectional
  - Either side may be designated as the owning side
  - The non-owning side must use the mappedBy element of the ManyToMany annotation
  - To specify the relationship field or property of the owning side

**More: mappedBy**
- **mappedBy** tells Hibernate
  - Look at the students property in the **Course** class
  - Use information from the **Course** class @JoinTable
  - To help find associated courses for student