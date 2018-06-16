package tk.lightweightcoding.aspects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.lightweightcoding.aspects.services.Calculator;

@SpringBootApplication
public class AspectsApplication implements CommandLineRunner {

	@Autowired
    private Calculator calculator;

	public static void main(String[] args) {
		SpringApplication.run(AspectsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(calculator.fibonacci(44));
        System.out.println(calculator.fibonacci(44));
	}
}
