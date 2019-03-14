package tk.lightweightcoding.aspects.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.lightweightcoding.aspects.annotations.Memo;
import tk.lightweightcoding.aspects.annotations.Monitor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Getter
public class Calculator {

    @Autowired
    private CalculatorHelper helper;
    private Map<Integer, Integer> histogram = new ConcurrentHashMap<>();

    @Monitor

    public long fibonacci(int n) {
        return helper.fibonacciPing(n);
    }

    @Memo
    long fibonacciPong(int n) {
        histogram.put(n, histogram.getOrDefault(n, 0) + 1);
        if(n == 0 || n == 1) {
            return n;
        }

        return helper.fibonacciPing(n-1) + helper.fibonacciPing(n-2);
    }
}
