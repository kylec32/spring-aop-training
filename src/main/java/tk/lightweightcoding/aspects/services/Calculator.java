package tk.lightweightcoding.aspects.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.lightweightcoding.aspects.annotations.Memo;
import tk.lightweightcoding.aspects.annotations.Monitor;

import java.util.HashMap;
import java.util.Map;

@Service
public class Calculator {

    public static final Map<Integer, Integer> histogram = new HashMap<>();

    @Autowired
    private CalculatorHelper helper;

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
