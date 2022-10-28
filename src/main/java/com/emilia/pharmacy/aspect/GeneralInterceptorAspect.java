package com.emilia.pharmacy.aspect;

import com.emilia.pharmacy.service.mongo.client.impls.ClientServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class GeneralInterceptorAspect {
    Logger logger = LogManager.getLogger(ClientServiceImpl.class);
    @Pointcut("@annotation(com.emilia.pharmacy.annotation.CustomAnnotation)")
    public void loggingPointCut() {}

    @Before("loggingPointCut()")
    public void before(JoinPoint joinPoint){
        logger.info("Before methods invoked::" + joinPoint.getSignature());
    };

    @After("loggingPointCut()")
    public void after(JoinPoint joinPoint){
        logger.info("After methods invoked::" + joinPoint.getSignature());
    };

    @Around("loggingPointCut()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        Object retval = pjp.proceed();
        long end = System.nanoTime();
        String methodName = pjp.getSignature().getName();
        logger.info("Execution of " + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start) + "ms");
        return retval;
    }
}
