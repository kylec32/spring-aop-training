package tk.lightweightcoding.aspects.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitorAspect {
    @Around("execution(@tk.lightweightcoding.aspects.annotations.Monitor * * (..))")
    public Object handleMonitoredFunction(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTiem = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        System.out.println(String.format("Monitored function took: %s ms", System.currentTimeMillis() - startTiem));
        return result;
    }
}
