package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BarcodeServiceAspect {
    @Before("execution(* org.example.services.BarcodeService.getBarcode(..))")
    public void before(){
        System.out.println("Before Execution function ");
    }

    @After("execution(* org.example.services.BarcodeService.getBarcode(..))") // No matter if got error and exception
    public void after(){
        System.out.println("After Execution function ");
    }

    @AfterReturning("execution(* org.example.services.BarcodeService.getBarcode(..))") //Only work it when return
    public void afterReturn(){
        System.out.println("After Execution function with return!");
    }
    @AfterThrowing("execution(* org.example.services.BarcodeService.getBarcode(..))") //Only work it when Throwing is return
    public void afterThrowing(){
        System.out.println("Got Throw!");
    }

    @Around("execution(* org.example.services.BarcodeService.getBarcode(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try{
            Object result = joinPoint.proceed() ;
            System.out.print(joinPoint.getTarget());
            return "pru"+result;
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return null;
    }
}