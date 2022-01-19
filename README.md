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

**Inversion of Control means**
- Outsource to an object factory.
- The approach of outsourcing the construction and management of objects.

**Coding scenario**
> MyApp object will make use of BaseballCoach object using getDailyWorkout().
> However, MyApp.class should be configurable. It can easily change the coach for another sport. So, I should be able to plug in a variety of coaches into MyApp obejct.



---
