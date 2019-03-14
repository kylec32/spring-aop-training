package tk.lightweightcoding.aspects.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class CalculatorHelper {

    @Autowired
    private Calculator calculator;

    long fibonacciPing(int n) {
        return calculator.fibonacciPong(n);
    }
}
