package tk.lightweightcoding.aspects.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.lightweightcoding.aspects.annotations.Monitor;

@Service
public class ImportantCalculationService {

    @Autowired
    private CalculationHelper calculationHelper;

    @Monitor
    public long fibonacci(int n) {
        return calculationHelper.fibonacciPong(n);
    }

    long fibonacciPing(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return calculationHelper.fibonacciPong(n-1) + calculationHelper.fibonacciPong(n -2);
    }

}
