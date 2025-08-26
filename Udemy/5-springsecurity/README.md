# Spring Security

**Spring Security Model**
- Spring Security defines a framework for security
- Implemented using Servlet filters in the background
- Two methods of securing an app : declarative and programmatic 

**Spring Security with Servlet Filters**
- Servlet Filters are used to pre-process/post-process web requests
- Servlet Filters can route web requests based on security logic 
- Spring provides a bulk of security functionalities with servlet filters

**Spring Security Overview**
graph TD
A[Web Browser] -->|HTTP Request| B[Spring Security Filters]
B -->|Authenticate/Authorize| C[Protected Web Resources<br>e.g., /mytopsecretstuff]
C -->|Response| B
B -->|HTTP Response| A
B -->|Validate Credentials| D[App Security Configuration]
D -->|User, Password, Roles| B
D -->|Configure| E[User Details Service]
E -->|Provide User Data| D

**Spring Security in Action**
```mermaid
graph TD
    A[Spring Security Filters] --> B{Is Web Resource Protected?}
    B -->|No| C[Show Resource]
    B -->|Yes| D{Is User Authenticated?}
    D -->|No| E[Send Login Form]
    E --> F[Show Login Form]
    F --> G[Authenticate User ID & Password]
    G --> D
    D -->|Yes| H{Is User Authorized?}
    H -->|Yes| I[Show Resource]
    H -->|No| J[Access Denied]
    classDef decision fill:#f9f,stroke:#333,stroke-width:2px;
    classDef action fill:#9f9,stroke:#333,stroke-width:2px;
    classDef endNode fill:#f99,stroke:#333,stroke-width:2px;
    class B,D,H decision;
    class A,C,E,F,G,I action;
    class J endNode;