package com.javacosmos.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectExample {
  // Required if using both AOP and filters: AOP does not work with filters
  // We use this pointcut to exclude filters from AOP
  @Pointcut("this(org.springframework.web.filter.GenericFilterBean)")
  private void genericFilterBeanImpl() {
  }

  @Before(value = "execution(* com.javacosmos..*(..)) && !genericFilterBeanImpl()")
  public void beforeAdvice(JoinPoint joinPoint) {
    System.out.println("AOP log: method " + joinPoint.getSignature().getName() + " (Before advice)");
  }

  @After(value = "execution(* com.javacosmos..*(..)) && !genericFilterBeanImpl()")
  public void afterAdvice(JoinPoint joinPoint) {
    System.out.println("AOP log: method " + joinPoint.getSignature().getName() + " (After advice)");
  }

  @AfterReturning(value = "execution(* com.javacosmos..*(..)) && !genericFilterBeanImpl()", returning = "result")
  public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
    System.out
        .println(
            "AOP log: method " + joinPoint.getSignature().getName() + " (After returning advice). Result: " + result);
  }

  @AfterThrowing(value = "execution(* com.javacosmos..*(..)) && !genericFilterBeanImpl()", throwing = "exception")
  public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
    System.out
        .println(
            "AOP log: method " + joinPoint.getSignature().getName() + " (After throwing advice). Exception: "
                + exception);
  }

  @Around(value = "execution(* com.javacosmos..*(..)) && !genericFilterBeanImpl()")
  public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    System.out
        .println(
            "AOP log: method " + proceedingJoinPoint.getSignature().getName()
                + " (Around advice: Before invoking method)");

    Object result = proceedingJoinPoint.proceed();

    System.out.println("AOP log: method " + proceedingJoinPoint.getSignature().getName()
        + " (Around advice: After invoking method). Result: " + result);

    return result;
  }
}
