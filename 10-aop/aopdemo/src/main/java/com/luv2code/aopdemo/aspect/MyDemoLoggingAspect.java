package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundFindAccountAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=========>Executing @Around advice on method: " + method);

        long begin = System.currentTimeMillis();
        Object result = null;
        try {
           result = theProceedingJoinPoint.proceed();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            //result = "Major accident! But no worries, your private AOP helicopter is on the way!";
            throw exc;
        }
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("\n=========>Duration: " + duration/1000.0 + " seconds");
        return result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccountAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=========>Executing @After (finally) advice on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
        // print method
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=========>Executing @AfterThrowing advice on method: " + method);

        // print result
        System.out.println("\n=========>exception: " + theExc);

    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
        // print method
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=========>Executing @AfterReturning advice on method: " + method);

        // print result
        System.out.println("\n=========>result: " + result);
        convertAccountNamesToUpperCase(result);
        System.out.println("\n=========>result: " + result);

    }

    private void convertAccountNamesToUpperCase (List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=========>Executing @Before advice on method");

        // method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);
        // method argument

        Object[] args = theJoinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }
    }



}
