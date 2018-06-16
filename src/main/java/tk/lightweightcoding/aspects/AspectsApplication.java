package tk.lightweightcoding.aspects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.lightweightcoding.aspects.services.Calculator;

import java.util.Map;

@SpringBootApplication
public class AspectsApplication implements CommandLineRunner {

	@Autowired
    private Calculator calculator;

	public static void main(String[] args) {
		SpringApplication.run(AspectsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(calculator.fibonacci(40));

		for(Map.Entry<Integer, Integer> pair : Calculator.histogram.entrySet()) {
            System.out.println(pair);
        }

//        System.out.println(calculator.fibonacci(40));
//
//        for(Map.Entry<Integer, Integer> pair : Calculator.histogram.entrySet()) {
//            System.out.println(pair);
//        }
	}
}
