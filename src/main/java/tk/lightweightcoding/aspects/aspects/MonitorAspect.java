package tk.lightweightcoding.aspects.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(0)
@Component
public class MonitorAspect {
    @Around("execution(@tk.lightweightcoding.aspects.annotations.Monitor * * (..))")
    public Object handleMonitoredFunction(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        System.out.println("Monitored function took: " + (System.currentTimeMillis() - startTime) + " ms to execute");
        return result;
    }
}
