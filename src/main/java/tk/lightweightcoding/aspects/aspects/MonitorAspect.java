package tk.lightweightcoding.aspects.aspects;

import lombok.val;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitorAspect {

    @Pointcut("execution(@tk.lightweightcoding.aspects.annotations.Monitor * * (..))")
    public void monitoredFunctions() { }

    @Around("monitoredFunctions()")
    public Object monitorFunction(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        System.out.println("Execution time: " + String.valueOf(System.currentTimeMillis() - startTime));
        return returnValue;
    }
}
