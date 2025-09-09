**Aspect-Oriented-Programming**
- Programming technique based on concept of an Aspect
- Aspect encapsulates cross-cutting logic
- "Concern" means logic/functionality

**Aspect**
- Aspect can be reused at multiple locations
- Same aspect/class ... applied based on configuration

**AOP Solution**
- Apply the Proxy design pattern
- [Main App] <----------> [AOP Proxy] <-------------[Logging Aspect]--[Security Aspect]---------> Target Object

**Benefits of AOP**
- Code for Aspect is defined in a single class
  - Much better than being scattered everywhere
  - Promotes code reuse and easier to change
- Business code in your application is cleaner
  - Only applies to business functionality : addAccount
  - Reduces code complexity
- Configurable
  - Based on configuration, apply Aspects selectively to different parts of app
  - No need to make changes to main application code ... very important!

**Additional AOP Use Cases**
- Most common
  - logging, security, transactions
- Audit logging
  - who, what, when, where
- Exceptional handling
  - log exception and notify DevOps team via SMS/email
- API Management
  - how many times has a method been called user
  - analytics: what are peak times? what is average load? who is top user?

**AOP: Advantages and Disadvantages**
- Advantages
  - Reusable modules
  - Resolve code tangling
  - Resolve code scatter
  - Applied selectively based on configuration
- Disadvantages
  - Too many aspects and app flow is hard to follow
  - Minor performance cost for aspect execution (run-time weaving)

**AOP Terminology**
- **Aspect:** module of code for a cross-cutting concern(logging, security, ...)
- **Advice:** What action is taken and when it should be applied 
- **Join Point:** When to apply code during program execution
- **Pointcut:** A predicate expression for where advice should be applied

**Advice Types**
- **Before advice:** run before the method
- **After (finally) advice:** run after the method(finally)
- **After returning advice:** run after the method(success execution)
- **After throwing advice:** run after method(if exception thrown)
- **Around advice:** run before and after method

**Weaving**
- Connecting aspects to target objects to create an advised object
- Different types of weaving
  - Compile-time, load-time or run-time
- Regarding performance: run-time weaving is the slowest

**AOP Frameworks**
- Two leading AOP Frameworks for Java
  - Spring AOP
  - AspectJ

**Spring AOP Support**
- Spring provides AOP support 
- Key component of spring
  - Security, transactions, caching, etc.
- Uses run-time weaving of aspects 
  - [Main App] <----------> [AOP Proxy] <-------------[Logging Aspect]--[Security Aspect]---------> Target Object

**AspectJ**
- Original AOP framework, released in 2001 
- Provides complete support for AOP 
- Rich support for 
  - join points: method-level, constructor, field
  - code weaving: compile-time, post compile-time and load-time

**Spring AOP Comparison**
- Advantages:
  - Simpler to use than AspectJ
  - Use Proxy pattern
  - Can migrate to AspectJ when using @Aspect annotation
- Disadvantages:
  - Only supports method-level join points
  - Can only apply aspects to beans created by Spring app context
  - Minor performance cost for aspect execution(run-time weaving)

**AspectJ Comparison**
- Advantages:
  - Supports all join points
  - Works with any POJO, not just beans from app context
  - Faster performance compared to Spring AOP
  - Complete AOP support
- Disadvantages 
  - Compile-time weaving requires extra compilation step
  - AspectJ pointcut syntax can become complex

**Comparing Spring AOP and AspectJ**
- Spring AOP only supports
  -  Method-level join points
  - Run-time code weaving(slower than AspectJ)
- AspectJ supports
  - join points: method-level, constructor, field
  - weaving: compile-time, post compile-time and load-time
- Spring AOP is a light implementation of AOP
- Solves common problems in enterprise applications

**@BeforeAdvice - Use Cases**
- Most Common
  - logging, security, transactions
  - Spring @Transactional uses AOP behind the scenes : begin transaction/commit transaction
- Audit logging
  - who, what, when, where
- API Management
  - how many times has a method been called user 
  - analytics: what are peak times? what is average load? who is top user?
- Eg:
  - Main App <------------> AOP Proxy <-------------Logging Aspect-----------> Target Object(Account DAO)
  - Logging Aspect : Run custom code BEFORE the Target Object method call

**Spring Boot AOP Starter**
- Add the dependency for Spring Boot AOP Starter
  - <groupId>org.springframework.boot</groupId>
  - <artifactId>spring-boot-starter-aop</artifactId>
- Since this dependency is part of our pom.xml
  - Spring Boot will **automatically** enable support for AOP
  - No need to explicitly use @EnableAspectJAutoProxy ... we get it for free

**Pointcut Expression Language**
- Spring AOP uses AspectJ's pointcut expression language
- execution(modifier-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
- The pattern is optional if it has "?"

**Pointcut Expression Examples**
- Match on method names 
  - Match only **addAccount** method in **AccountDAO** class
    - `@Before("execution(public void com.example.aop.dao.AccountDAO.addAccount())")`
    - modifier: **public**
    - return type: **void**
    - declarative type: **com.example.aop.dao.AccountDAO**
    - method: **addAccount()**
  - Match any **addAccount()** method in **any** class
    - `@Before("execution(public void addAccount())")`
  - Match on method names(using wildcards)
    - Match names **starting** with **add** in any class
    - `@Before("execution(public void add*())")`
    - `@Before("execution(public VerificationResult processCreditCard*())")`
  - Use wildcards on return type
    - `@Before("execution(public * processCreditCard*())")`
  - Modifier is optional ... so you don't have to list it
    - `@Before("execution(* processCreditCard*())")`

**Parameter Pattern Wildcards**
- For param-pattern
  - **()** - matches a method with no argumendowts
  - **(*)** - matches a method with one argument of any type
  - **(..)** - matches a method with 0 or more arguments of any type
- Examples:
  - **Match on method parameters**
    - Match **addAccount** methods with **no arguments** :
      -  `@Before("execution(* addAccount())")`
    - Match **addAccount** methods that have **Account** param
      - `@Before("execution(* addAccount(com.example.aop.Account))")`
    - Match **addAccount** methods with **any number of arguments**
      -  `@Before("execution(* addAccount(..))")`
  - **Match on methods in a package**
    - Match any method in our DAO package:**com.example.aop.dao**
      - `@Before("execution(* com.example.aop.dao.*.*(..))")`
