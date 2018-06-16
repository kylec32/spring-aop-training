package tk.lightweightcoding.aspects.services;

import org.springframework.stereotype.Service;
import tk.lightweightcoding.aspects.annotations.Memo;
import tk.lightweightcoding.aspects.annotations.Monitor;

@Service
public class Calculator {

    @Monitor
    @Memo
    public long fibonacci(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }
}
