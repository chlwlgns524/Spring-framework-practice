# 1. What is Spring?

## 1.1 Spring in a Nutshell
- Very popular framework for building Java applications.
- Initially a simpler and lightweight alternative to J2EE.
- Provides a large number of helper classes, which make things easier.
- Simplifies Java enterprise development.

> [Spring Website - Official](https://spring.io/)

## 1.2 Goals of Spring
- Lightweight development with Java POJOs(Plain-Old-Java-Objects).
- Dependency injection to promote loose coupling.
- Declarative programming with AOP(Aspect-Object-Programming).
- Minimize boilerplate Java code.

---

# 2. IoC(Inversion of Control) - XML Configuration

## 2.1 IoC
- Outsource to an object factory.
- The approach of outsourcing the construction and management of objects.

## 2.2 Spring Container
- Create and manage objects(Inversion of Control).
- Inject object's dependencies(Dependenciy Injection).

## 2.3 Configuration Spring Container
- XML configuration file(legacy, but most legacy apps still use this method).
- Java annotations(modern).
- Java source code(modern).

## 2.4 Spring Development Process
  **1. Configure spring beans.**
```xml
<!-- the "id" is like an alias and the "class" is fully qualified class name of implementation class -->
<beans ...>
    <bean id="myCoach" class="com.springdemo.BaseballCoach"></bean>
</beans>
```
  
  **2. Create a spring container.**
  - Spring container is generally known as ApplicationContext.
  - Specialized implementations.
     1. ClassPathXmlApplicationContext
     2. AnnotationConfigApplicationContext
     3. GenericWebApplicationContext
     4. Others
```java
// the argument is the name of config file
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
```

  **3. Retrieve beans from the spring container.**
```java
// create a spring container
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

// retrieve bean from spring container
Coach theCoach = context.getBean("myCoach", Coach.class);
```

**(!) What is a Spring Bean?**

> A "Spring Bean" is simply a Java object. When Java objects are created by the Spring Container, then Spring refers to them as "Spring Beans". Spring Beans are created from
> normal Java classes, just like Java objects. In the early days, there was a term called "Java Beans". Spring Beans have a similar concept but Spring Beans do not follow all of the rigorous requirements of Java Beans. In summary, when seeing "Spring Bean", just think Java object.

---

# 3. DI(Dependency Injection) - XML Configuration

## 3.1 DI
 - The dependency inversion principle.
 - The client delegates to calls to another object the responsibility of providing its dependency.
 - "dependency" same thing as "helper objects"

## 3.2 Demo Example
 - The Coach already provides daily workouts.
 - Now will also priovide daily fortunes.
   1. New helper: FortuneService
   2. This is dependency

## 3.3 Injection Types
 - There are many types of injection with Spring.
 - There are the two most common.
    1. Construction Injection
    2. Setter Injection

## 3.4 Development Process - Constructor Injection

**1. Define the dependency interface and class.**
```java
// File: FortuneService.java
public interface FortuneService {
    public String getFortune();
}

...

// File: HappyFortuneService.java
public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }
}
```
**2. Create a constructor in the class for injections.**
```java
// File: BaseballCoach.java
public class BaseballCoach implements Coach {
    // define field
    private FortuneService fortuneService; 
    
    // define constructor
    public BaseballCoach(FortuneService fortuneService) { 
        this.fortuneService = fortuneService;
    }
    ...
}
```
**3. Configure the dependency injection in Spring config file.**
```xml
<!-- File: applicationContext.xml -->

<!-- define dependency/helper -->
<bean id="myFortuneService" class="com.springdemo.HappyFortuneService"></bean>

<!-- HappyFortuneService myFortuneService = new HappyFortuneService();
   is done by Spring Framework using the configuration above. -->


<bean id="myCoach" class="com.springdemo.BaseballCoach">
 
    // inject the dependency/helper using "constructor injection"
    <constructor-arg ref="myFortuneService" />
 
</bean>

<!-- BaseballCoach myCoach = new BaseballCoach(myFortuneService); 
    is done by Spring Framework using the configuration above. -->
```

## 3.5 Development Process - Setter Injection

**1. Create setter method(s) in the class for injections.**
```java
// File: CricketCoach.java
public class  CricketCoach implements Coach {
    // define field
    private FortuneService fortuneService; 
    
    // define no-arg constructor
    public CricketCoach() { 
        
    }
    
    // this setter method will be called by Spring during setter injection
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    ...
}
```
**2. Configure the dependency injection in Spring config file.**
```xml
<!-- File: applicationContext.xml -->

<!-- define dependency/helper -->
<bean id="myFortuneService" class="com.springdemo.HappyFortuneService"></bean>

<!-- HappyFortuneService myFortuneService = new HappyFortuneService();
   is done by Spring Framework using the configuration above. -->


<bean id="myCricketCoach" class="com.springdemo.CricketCoach">
 
    <!-- setter injection -->
    <!--
    Spring will actually capitalize the first letter of property name, 
    call the setFortuneService and pass in myFortuneService as an argument for that call.
    -->
    <property name="fortuneService" ref="myFortuneService" />
 
</bean>

<!-- 
    CricketCoach myCricketCoach = new CricketCoach(); 
    myCricketCoach.setFortuneService(myFortuneService); 
    is done by Spring Framework using the configuration above. 
-->
```

## 3.6 Development Process - Literal Injection

**1. Create setter method(s) in the class for injections.**
```java
// File: CricketCoach.java
public class  CricketCoach implements Coach {
    ...
    // create private fields
    private String emailAddress;
    private String team;
    
    ...
    //create setter methods
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    ...
}
```
**2. Configure the injection in Spring config file.**
```xml
<!-- File: applicationContext.xml -->

<bean id="myCricketCoach" class="com.springdemo.CricketCoach">
    
    <property name="fortuneService" ref="myFortuneService" />
    
    <!-- notice that 'value' atrribute, unlike the 'ref' attribute above -->
    <property name="emailAddress" value="choijh@gmail.com" />
    <property name="team" value="Best Effort" />
 
</bean>
```
---
