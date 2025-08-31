**Components of a Spring MVC Application**
- Web Pages : A set of web pages to layout UI components
- Beans : A collection of Spring beans (controllers, services, etc...)
- Spring Configuration : XML, Annotations or Java

**Spring MVC Front Controller**

- Web Browser ---> Front Controller --(model)--> Controller --(model)--> View Template ---> Web Browser 
  - Front Controller known as *Dispatcher Servlet*
    - Part of Spring Framework
    - Already developed by Spring Dev Team
  - We will create 
    - Model Objects
    - View Templates
    - Controller Classes

**Controller**
- Code created by developer
- Contains business logic
  - Handle the request
  - Store/retrieve data(db, web service/...)
  - Place data in model
- Send to appropriate view template

**Model**
- Model contains data
- Store/retrieve data via backend systems
  - database, web service, etc...
  - Use Spring bean if you like
- Place your data in the model
  - Data can be any Java object/collection

**View Template**
- Spring MVC is flexible
  - Supports many view templates
- Recommended : Thymeleaf
- Developer creates a page
  - Displays data
- Other view templates supported
  - Groovy, Velocity, Freemarker, etc...

**Spring Model**
- The Model is a container for your application data
- In your Controller
  - You can put anything in the model
  - strings, objects, info from databases, etc...
- Your View page can access data from the model