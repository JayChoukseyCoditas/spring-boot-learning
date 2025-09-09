**Pointcut Declarations**
- To reuse Pointcut Expressions, we can create Pointcut Declarations
- Eg,
    - `@Pointcut("execution(* com.example.aop.dao.*.*(..))")`
    - `private void forDaoPackage() {}`
- Benefits
    - Easily reuse pointcut expressions
    - Update pointcut in one location
    - Can also share and combine pointcut expressions

**Combining Pointcut Expressions**
- Combine pointcut expressions using logic operators    
  - AND(&&)
  - OR(||)
  - NOT(!)
- Works like an "if" statement
  - Execution happens only if it evaluates to true
- Examples
  - `@Before("expressionOne() && expressionTwo()")`
  - `@Before("expressionOne() || expressionTwo()")`
  - `@Before("expressionOne() && !expressionTwo()")`

**To Control Order**
- Refactor: Place advices in separate Aspects
- Control order on Aspects using the @Order annotation
- Guarantees order of when Aspects are applied
- Lower numbers have higher precedence
  - Range: Integer.MIN_VALUE to Integer.MAX_VALUE
  - Negative numbers are allowed
  - Does not have to be consecutive 
- If aspects have the exact same @Order annotation
  - The order at this point is undefined
  - It will still run AFTER the Aspect which has higher precedence and BEFORE the Aspect has lower precedence

**JoinPoint**
- It has metadata about method call

**@AfterReturning Advice - Use Cases**
- **Most Common**
  - logging, security, transactions
- **Audit logging**
  - who, what, when, where
- **Post-processing data**
  - Post process the data before returning to caller
  - Format the data or enrich the data(really cool but be careful)

**AfterThrowing Advice - Use Cases**
- Log the exception
- Perform auditing on the exception
- Notify DevOps team via email or SMS
- Encapsulate this functionality in AOP aspect for easy reuse

**Exception Propagation**
- If you want to stop the execution propagation
  - then use the **@Around** advice

**@After Advice**
- Runs after a method is completed. Regardless of outcome/exceptions
- Works just like "finally" block
- Use Cases 
  - Log the exception and/or perform auditing
  - Code to run regardless of method outcome
  - Encapsulate this functionality in AOP aspect for easy reuse
- The @After advice does not have access to exception
- If you need exception, then use @AfterThrowing advice
- The @After advice should be able to run in the case of success or error
  - Code should not depend on happy path or exception
  - Logging/auditing is the easiest case here

**@Around Advice - Use Cases**
- Most common: logging, auditing, security
- Pre-processing and post-processing data
- Instrumentation/profiling code
  - How long does it take for a section of code to run?
- Managing exceptions
  - Swallow/handle/stop exceptions

**ProceedingJoinPoint**
- When using @Around advice
- You will get a reference to a **"proceeding join point"**
- This is a handle to **target method**
- Your code can use the **proceeding join point** to execute **target method**
- For an exception thrown from proceeding join point
  - can handle/swallow/stop the exception
  - or can simply rethrow the exception
- This gives fine-grained control over how the target method is called