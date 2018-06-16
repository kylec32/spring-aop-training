package tk.lightweightcoding.aspects.services;

import org.springframework.stereotype.Service;
import tk.lightweightcoding.aspects.annotations.Memo;
import tk.lightweightcoding.aspects.annotations.Monitor;

import java.util.HashMap;
import java.util.Map;

@Service
public class Calculator {

    public static final Map<Integer, Integer> histogram = new HashMap<>();

    @Monitor
    @Memo
    public long fibonacci(int n) {
        histogram.put(n, histogram.getOrDefault(n, 0) + 1);
        if(n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }
}
