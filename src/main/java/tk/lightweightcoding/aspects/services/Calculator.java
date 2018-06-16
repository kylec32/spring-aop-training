package tk.lightweightcoding.aspects.services;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public long fibonacci(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }
}
