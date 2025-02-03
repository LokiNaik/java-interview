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




# Spring Boot 
#### 1. What is Spring Framework, and why is it used?
#### **Definition**:
Spring Framework is an open-source framework for building Java-based enterprise applications.
It provides features like dependency injection, transaction management, and AOP, making development easier and reducing boilerplate code.

##### **Why is it used?**
- To develop loosely coupled applications using dependency injection.
- Provides modular components like Spring MVC, Spring Security, etc.
- Handles cross-cutting concerns like logging and security using AOP.
- Simplifies database interaction using Spring JDBC or Spring Data JPA.

#### 2. What are the different types of dependency injection in Spring? Provide examples.
1. Constructor Injection: Dependencies are injected via the constructor.
```java
@Component
class Car {
    private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }
}
```
2. Setter Injection: Dependencies are injected via a setter method.
```java
@Component
class Car {
    private Engine engine;

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
```
3. Field Injection: Dependencies are injected directly into a field.
```java
@Component
class Car {
    @Autowired
    private Engine engine;
}
```

#### 3. What is the Bean Lifecycle in Spring?
Steps in Bean Lifecycle:
- **Instantiation**: The bean is created by the IoC container.
- **Populate Properties**: Dependencies are injected.
- **@PostConstruct**: Called after properties are set.
- **Initialization**: Custom initialization logic.
- **Ready to Use**: The bean is now ready for use.
- **@PreDestroy**: Called before the bean is destroyed.
- **Destruction:** Bean is destroyed.
```java
@Component
class DemoBean {
    @PostConstruct
    public void init() {
        System.out.println("Bean initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean destroyed");
    }
}
```

#### 4. What is the difference between @Bean and @Component?
- **@Component:** Used to declare a class as a Spring-managed bean. The Spring container automatically detects it during classpath scanning.
- **@Bean**: Used to define a bean explicitly in a configuration class. It gives more control over bean creation.
#### Example: **@Component**
```java
@Component
class Engine {
    public void run() {
        System.out.println("Engine running");
    }
}
```
#### Example **@Bean**
```java
@Configuration
class AppConfig {
    @Bean
    public Engine engine() {
        return new Engine(); // Explicit bean creation
    }
}
```
#### 5. What are Spring Scopes?
- **Singleton**: Default scope; a single instance is created for the entire Spring container.
- **Prototype**: A new instance is created every time the bean is requested.
- **Request**: Scoped to a single HTTP request (used in web applications).
- **Session**: Scoped to an HTTP session.
- **Application**: Scoped to a ServletContext.
##### Example
```java
@Component
@Scope("prototype")
class PrototypeBean {
    public PrototypeBean() {
        System.out.println("New PrototypeBean instance created");
    }
}
```
#### 6. What is the use of the ApplicationContext in Spring?
##### **Definition:**
`ApplicationContext` is the central interface in Spring for managing beans, resolving dependencies, and providing application-specific configurations.

##### Common Features:
- Bean lifecycle management.
- Event handling.
- Access to environment properties.
  ##### Example
```java
  ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
  MyBean bean = context.getBean(MyBean.class);
````

#### 7. Explain the difference between ApplicationContext and BeanFactory.
- **BeanFactory**: Basic container with lazy initialization. Suitable for lightweight applications.
- **ApplicationContext**: Advanced container with additional features like event handling, internationalization, and eager initialization.

#### 8. What is autowiring in Spring?
Autowiring is the process of automatically injecting bean dependencies by the Spring container.

##### Types:
- **No**: No autowiring.
- **ByType**: Matches bean by type.
- **ByName**: Matches bean by name.
- **Constructor**: Matches constructor parameters by type.
##### Example:
```java
@Autowired
private Engine engine;
```

#### 8. How do you handle circular dependencies in Spring?
- Use `@Lazy` annotation to delay initialization.
- Refactor the code to avoid tight coupling.
```java
@Component
class A {
    @Autowired
    @Lazy
    private B b;
}

@Component
class B {
    @Autowired
    private A a;
}
```

#### 9. What are starter dependencies in Spring Boot?
Starter dependencies are pre-configured dependencies to simplify setting up the project. Examples include:

- `spring-boot-starter-web`: For building web applications.
- `spring-boot-starter-data-jpa`: For database interactions using JPA.
##### Example
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

#### 10. What is the difference between Spring and Spring Boot?
| Feature |	Spring Framework	| Spring Boot
|---------------|-------------|--------------|
| Setup |	Requires manual configuration	| Auto-configuration with starters |
| Embedded Server |	Needs external configuration	| Comes with embedded servers (e.g., Tomcat) |
| Focus	| General-purpose framework |	Simplifies microservice development |
| Deployment	| WAR deployment by default |	Standalone JARs with `SpringBootApplication` |

#### 11. What is the role of @SpringBootApplication?
It’s a convenience annotation equivalent to using:

- `@Configuration`: Marks the class as a source of bean definitions.
- `@EnableAutoConfiguration`: Enables auto-configuration.
- `@ComponentScan`: Scans for components in the package.

##### Example:
```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

#### 12. How does Spring Boot manage properties using application.properties?
Spring Boot uses the application.properties or application.yml file for configuration.

#### Example: `application.properties`

```properties
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root
```
You can inject these properties using `@Value` or `@ConfigurationProperties`.

#### 13. What is Spring Boot Actuator?
Spring Boot Actuator provides production-ready features such as metrics, health checks, and monitoring.

##### Common Endpoints:
 - `/actuator/health`: Checks application health.
 - `/actuator/metrics`: Provides metrics data.
##### Example:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

#### 14. What is @RestController? How is it different from @Controller?
- `@RestController`: Combines `@Controller` and `@ResponseBody`. It’s used to create RESTful web services.
- `@Controller`: Used for traditional MVC. Returns view templates.
```java
@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
```

#### 15. What is @RequestMapping, and how is it different from @GetMapping?
- `@RequestMapping`: Generic annotation for mapping HTTP methods (GET, POST, etc.).
- `@GetMapping`: A shorthand for `@RequestMapping(method = RequestMethod.GET)`.
##### Example @RequestMapping
```java
@RequestMapping(value = "/users", method = RequestMethod.GET)
public List<User> getUsers() {
    return userService.findAll();
}
```
##### Example @GetMapping
```java
@GetMapping("/users")
public List<User> getUsers() {
    return userService.findAll();
}
```

#### 16. What are @RequestParam and @PathVariable?
- `@RequestParam`: Extracts query parameters.
- `@PathVariable`: Extracts values from the URI.
##### Example:
```java
@RestController
class DemoController {
    @GetMapping("/user")
    public String getUser(@RequestParam String name) {
        return "Hello, " + name;
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id) {
        return "User ID: " + id;
    }
}
```

