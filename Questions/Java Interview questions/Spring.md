## History and Hierarchy of Spring
### Origin of Spring:
- Spring started as a lightweight framework for enterprise Java applications, addressing the complexity of Java EE (formerly J2EE)
- It was introduced by Rod Johnson in 2002 and officially released as Spring Framework 1.0 in March 2004.
- **Core Idea**:
  - The goal was to simplify Java development by offering:
  - Dependency Injection (DI) for better application modularity.
  - Aspect-Oriented Programming (AOP) for separating cross-cutting concerns (e.g., logging, transactions).
- Key Milestones:
  - **Spring Framework**: Core container, AOP, and JDBC support.
  - **Spring Boot**: Introduced in 2014 to simplify configuration and reduce boilerplate code for Spring applications.
  - **Spring Cloud**: Extensions for building microservices.
### Hierarchy of Spring:
#### Core Container:
- Spring Core: Provides core features like IoC and DI.
- Spring Beans: Manages beans and their lifecycle.
- Spring Context: Access beans and manage application context.
- Spring Expression Language (SpEL): For querying and manipulating beans.
#### Data Access/Integration:
- JDBC: Simplifies database connectivity.
- ORM: Integration with Hibernate, JPA, etc.
- Transaction Management: Declarative transaction handling.
#### Web Layer:
- Spring MVC: Web application framework.
- Spring WebFlux: Reactive programming for non-blocking applications.
- Spring Boot: Simplifies Spring setup by providing auto-configuration and a production-ready environment.

### Core Features of Spring
#### 1. Dependency Injection (DI)
**Definition**: A design pattern where Spring manages the creation and wiring of objects (dependencies).
 - **Why use it?** : To make applications more modular, testable, and reduce tight coupling.
 - **How it works in Spring?**
   - You define your dependencies using annotations (@Autowired, @Component) or XML configurations.
   - Spring automatically injects the required dependencies into your classes.
### Example:
```java

@Component
public class Engine {}

@Component
public class Car {
    private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine; // Dependency Injection
    }
}
```

#### 2. Inversion of Control (IoC)
- **Definition**: Spring manages the lifecycle of objects. The control of creating objects is inverted from developers to Spring’s IoC container.
- **Uses**:
    - Simplifies application structure.
    - Centralized object management.
    - How it works?
      - Spring scans for components or reads configurations and instantiates the objects.
#### 3. Aspect-Oriented Programming (AOP)
- **Definition**: A programming paradigm that helps manage cross-cutting concerns like logging, security, and transactions separately from business logic.
- Why use it?
  - Avoid code duplication.
  - Cleaner separation of concerns.
- How it works?
  - Define aspects (cross-cutting logic) using @Aspect.
  - Apply them to methods using pointcuts.
    
#### Example: Logging Aspect:
```java

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.example.service.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("Method called: " + joinPoint.getSignature().getName());
    }
}
```

#### 4. Spring Modules
- Spring has a modular architecture with the following key modules:

- **Core Container**: Provides DI and IoC.
- **Data Access**: JDBC, ORM (Hibernate, JPA).
- **Web**: Spring MVC for web applications.
- **AOP**: Handles cross-cutting concerns.
- **Test**: Testing support for Spring applications.


## Important Annotations in Spring and Spring Boot
Below is a categorized list of essential annotations:

### Core Spring Annotations
#### Dependency Injection and Bean Management:

- **@Component**: Marks a class as a Spring component (scanned and managed as a bean).
- **@Service**: Specialized @Component for service layer.
- **@Repository**: Specialized @Component for the DAO layer.
- **@Controller**: Specialized @Component for the web controller layer.
- **@Bean**: Defines a bean explicitly in a @Configuration class.
- **@Configuration**: Marks a class as a configuration source for Spring beans.
- **@Primary**: Marks a bean as primary when multiple beans of the same type exist.
- **@Lazy**: Lazy initialization of beans.
  
#### Dependency Injection Qualifiers:
- **@Autowired**: Injects dependencies automatically by type.
- **@Qualifier**: Resolves ambiguity when multiple beans of the same type exist.
- **@Value**: Injects values from application.properties or application.yml.
#### Scopes:

- **@Scope**: Defines the scope of a bean (singleton, prototype, etc.).
  
### Spring Boot Annotations
#### Application Setup:

- **@SpringBootApplication**: Combines @Configuration, @EnableAutoConfiguration, and @ComponentScan.
- **@EnableAutoConfiguration**: Enables Spring Boot's auto-configuration.
- **@ComponentScan**: Scans for components and beans in the specified package.
  
#### Configuration and Properties:
- **@ConfigurationProperties**: Maps properties to a POJO.
- **@EnableConfigurationProperties**: Enables support for @ConfigurationProperties.
  
#### Profiles and Conditional Beans:

- **@Profile**: Activates beans based on active profiles (e.g., dev, prod).
- **@Conditional**: Defines custom conditions for bean creation.
  
#### Spring Boot Testing:

- **@SpringBootTest**: Loads the full application context for testing.
- **@TestConfiguration**: Custom configuration for test-specific beans.
  
### Spring Web Annotations
#### REST Controller and Request Mapping:

- **@RestController**: Combines @Controller and @ResponseBody for RESTful APIs.
- **@RequestMapping**: Maps HTTP requests to methods.
    - @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping: Specialized shortcuts for @RequestMapping.
      
#### Request Parameters and Bodies:
- **@RequestParam**: Binds query parameters to method arguments.
- **@PathVariable**: Binds URL path variables to method arguments.
- **@RequestBody**: Maps the request body to a POJO.
- **@ResponseBody**: Returns data as the response body.

### Cross-Origin and Exception Handling:
- **@CrossOrigin**: Enables Cross-Origin Resource Sharing (CORS).
- **@ExceptionHandler**: Handles exceptions globally or locally in controllers.

### Spring Security Annotations
#### Authentication and Authorization:
- **@EnableWebSecurity**: Enables Spring Security configuration.
- **@PreAuthorize**: Restricts method access based on roles.
- **@Secured**: Similar to @PreAuthorize, but simpler.
- **@RolesAllowed**: Defines allowed roles for a method.


