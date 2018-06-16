package tk.lightweightcoding.aspects.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.lightweightcoding.aspects.annotations.Memo;

@Service
public class CalculationHelper {

    @Autowired
    ImportantCalculationService calculationService;

    public static final int[] histogram = new int[100];

    @Memo
    long fibonacciPong(int n) {
        histogram[n] = histogram[n] + 1;
        if(n == 0 || n == 1) {
            return n;
        }

        return calculationService.fibonacciPing(n-1) + calculationService.fibonacciPing(n -2);
    }
}
