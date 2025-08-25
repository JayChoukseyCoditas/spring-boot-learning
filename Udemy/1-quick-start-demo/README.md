# Spring Boot Task

**User and Details**
- Super Admin (created by default)
  - Has right to create admin 
- Admin
  - can create/updated/read/delete participants
  - can create/updated/read/delete conference(venue, other details)
- Participants
  - field for interested as input 
  - conference details 

**About Conference**
- Status (Upcoming(can see by all), Past(can only visible to past participants only), Ongoing(by all))
- Mode (Online/ Offline)
- Venue 
- Date and Time
- Duration
- Domain

**Suggestions**
- USE LIQUIBASE : Helpful in DB migration **(Must do)**
- MAKE UPDATE TABLE FALSE FOR HIBERNATE **(Must do)**
- RBAC METRICS **(Must do)**
- USE JWT(at last) 
- Convert monolithic to microservices

**Steps**
1. Make the functional requirement
2. What are the common things between all 
3. Schema Design
4. API Design
5. Add Security