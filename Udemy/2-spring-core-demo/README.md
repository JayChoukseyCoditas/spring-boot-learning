# Spring Container

**Primary Functions**
- Create and manage objects (IoC)
- Inject object's dependencies (DI)

**Injection Types**
- Constructor injection
    - Use this when you have required dependencies
    - Generally recommended by the spring.io dev team as first choice
- Setter Injection
    - Use this when you have optional dependencies
    - If dependency is not provided, your app can provide reasonable default logic
- Field Injection(not recommended)

**AutoWiring**
- For DI, Spring can use autowiring
- Spring will look for a class that matches
    - matches by type: class or interface
- Spring will inject it automatically ... hence it is autowired
- Example
    - Injecting a Coach implementation
    - Spring will scan for @Components
    - Any one implements the Coach interface
    - If so, let's inject them. For eg, CricketCoach

**Component Scanning**

*Annotations*
- @SpringBootApplication is composed of the following annotations
  - @EnableAutoConfiguration: 
    - Enables Spring Boot's auto-configuration support
  - @ComponentScan: 
    - Enables component scanning of current package
    - Also, recursively scans sub-packages
  - @Configuration:
    - Able to register extra beans with @Bean 
    - or Import other configuration classes

*More on Component Scanning*
- By default, Spring Boot starts component scanning
  - From same packages as your main Spring Boot application
  - Also scans sub-packages recursively
- This implicitly defines a base package 
  - Allows to leverage default component scanning
  - No need to explicitly reference the base package name
- Default Scanning is fine if everything is under our base package("com.example.spring_core_demo")
- But what about other packages 
  - Use this @SpringBootApplication(scanBasePackages={"com.example.spring_core_demo", "com.example.util", ... "other packages"})

**@Primary and @Qualifier**
- @Primary 
  - leaves it up to the implementation classes
  - could have the issue of multiple @Primary classes leading to an error
- @Qualifier
  - allows to you be very specific on which bean you want 
- In general, @Qualifier is recommended
  - more specific
  - higher priority

**@Lazy**
- By default, when our application starts, all beans are initialized
  - @Component, etc
- Spring will create an instance and make the available
- Using @Lazy, Bean is only initialized if needed for Dependency Injection
- To configure other beans for lazy initialization 
  - We would need to add @Lazy to each class
- We can set a global configuration property as well if we have large number of classes

**NOTE : For dependency resolution Spring creates instance of TennisCoach first(in our case) then create instance of DemoController and injects the TennisCoach** 

**Bean Scopes**
- Scope refers to the lifecycle of a bean
- How long does the bean live?
- How many instances are created?
- How is bean shared?
- Default Scope : Singleton
  - It is cached in memory
  - All dependency injections for the bean will reference the SAME bean
- Additional Spring Bean Scopes 
  - singleton : create a single instance for the bean.
  - prototype : creates a new bean instance for each container request.
  - request : scoped to an HTTP request. Only for web apps.
  - session : scoped to an HTTP web session. Only used for web apps.
  - application : Scoped to a web ServletContext. Only used for web apps.
  - websocket : Scoped to a web socket. Only used for web apps.

**Bean Lifecycle**
1. Container Started
2. Bean Instantiated 
3. Dependencies Injected
4. Internal Spring Processing 
5. Your Custom Init Method
6. Bean Is Ready For Use/ Container Is Shutdown
7. Your Custom Destroy Method
8. STOP

- Bean Lifecycle Methods/ Hooks
  - You can add custom code during **bean initialization**
    - Calling custom business logic methods
    - Setting up handles to resources (db, sockets, file, etc.)
  - You can add custom code during bean destruction 
    - Calling custom business logic method
    - Clean up handles to resources (db, sockets, files, etc.)

- Development Process
  - Define your methods for init and destroy
  - Add annotations: @PostConstruct and @PreDestroy

**NOTE : For "prototype" scoped beans, Spring does not call the destroy method**
**NOTE : Spring does not manage the complete lifecycle of a prototype bean**

**Java Config Bean**
- If we have no special Annotations on a class like @Component 
- Development Process
  - Create @Configuration class
  - Define @Bean method to configure the bean
  - Inject the bean into our controller
- Use case for @Bean
  - Make an existing third-party class available for spring framework
  - You may not have access to the source code of third-party class
  - However, you would like to use the third-party class as a Spring bean