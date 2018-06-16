package tk.lightweightcoding.aspects.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class MemoAspect {

    private static Map<FunctionCall, Object> memoizedResults = new ConcurrentHashMap<>();

    @Pointcut("execution(@tk.lightweightcoding.aspects.annotations.Memo * * (..))")
    public void memoizedFunctions() { }

    @Around("memoizedFunctions()")
    public Object handleMemoizedFunction(ProceedingJoinPoint joinPoint) throws Throwable {
        FunctionCall functionCall = new FunctionCall(joinPoint.getSignature().toString(), joinPoint.getArgs());

        Object memoizedResult = memoizedResults.get(functionCall);

        if(memoizedResult == null) {
            System.out.println("Had to actually calculate: " + joinPoint.getSignature().toString() + " args: " + joinPoint.getArgs()[0]);
            memoizedResult = joinPoint.proceed();
            memoizedResults.put(functionCall, memoizedResult);
        } else {
            System.out.println("Using memoized result: " + joinPoint.getSignature().toString() + " args: " + joinPoint.getArgs()[0]);
        }

        return memoizedResult;
    }

    private static class FunctionCall {
        private final String functionName;
        private final Object[] arguments;

        public FunctionCall(String functionName, Object[] arguments) {
            this.functionName = functionName;
            this.arguments = arguments;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FunctionCall that = (FunctionCall) o;
            return Objects.equals(functionName, that.functionName) &&
                    Arrays.equals(arguments, that.arguments);
        }

        @Override
        public int hashCode() {

            int result = Objects.hash(functionName);
            result = 31 * result + Arrays.hashCode(arguments);
            return result;
        }
    }
}
