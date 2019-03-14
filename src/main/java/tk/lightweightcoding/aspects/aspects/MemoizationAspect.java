package tk.lightweightcoding.aspects.aspects;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class MemoizationAspect {
    private static final Map<FunctionCall, Object> memoizedResults = new HashMap<>();

    @Around("execution(@tk.lightweightcoding.aspects.annotations.Memo * * (..))")
    public Object handleMemoized(ProceedingJoinPoint joinPoint) throws Throwable {
        FunctionCall functionCall = new FunctionCall(joinPoint.getSignature().getName(), joinPoint.getArgs());
        Object result = memoizedResults.get(functionCall);
        if(result == null) {
            result = joinPoint.proceed();
            memoizedResults.put(functionCall, result);
        }
        return result;
    }

    @RequiredArgsConstructor
    @EqualsAndHashCode
    private static class FunctionCall {
        private final String fullyQualifiedName;
        private final Object[] arguments;
    }
}
