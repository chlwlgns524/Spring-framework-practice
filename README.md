# 1. What is Spring?

## 1.1 Spring in a Nutshell
- Very popular framework for building Java applications.
- Initially a simpler and lightweight alternative to J2EE.
- Provides a large number of helper classes, which make things easier.
- Simplifies Java enterprise development.

[Spring Website - Official](https://spring.io/)

## 1.2 Goals of Spring
- Lightweight development with Java POJOs(Plain-Old-Java-Objects).
- Dependency injection to promote loose coupling.
- Declarative programming with AOP(Aspect-Object-Programming).
- Minimize boilerplate Java code.

---

# 2. IoC(Inversion of Control)

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
<beans ...>
    <bean id="myCoach" class="com.springdemo.BaseballCoach"> 
      
<!-- the "id" is like an alias and the "class" is fully qualified class name of implementation class -->
      
    </bean>
</beans>
```
  
  **2. Create a spring container.**
  - Spring containe is generally known as ApplicationContext.
  - Specialized implementations such as ClassPathXmlApplicationContext, AnnotationConfigApplicationContext, GenericWebApplicationContext and others.
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
