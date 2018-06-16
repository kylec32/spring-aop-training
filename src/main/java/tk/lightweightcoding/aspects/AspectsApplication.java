package tk.lightweightcoding.aspects;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.lightweightcoding.aspects.services.CalculationHelper;
import tk.lightweightcoding.aspects.services.ImportantCalculationService;

import java.util.stream.IntStream;

@SpringBootApplication
public class AspectsApplication implements CommandLineRunner {

	private final ImportantCalculationService calculationService;
	private final CalculationHelper calculationHelper;

	public AspectsApplication(ImportantCalculationService calculationService, CalculationHelper calculationHelper) {
		this.calculationService = calculationService;
		this.calculationHelper = calculationHelper;
	}

	public static void main(String[] args) {
		SpringApplication.run(AspectsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		IntStream.range(0,60).forEach(value ->
				{
					System.out.println(value + " : " + calculationService.fibonacci(value));
				}
		);

//		for(int i=0; i<calculationHelper.histogram.length; i++) {
//			System.out.println(String.format("%s:\t%s", i, calculationHelper.histogram[i]));
//		}

//		System.out.println("\nRunning again\n");
//
//		IntStream.range(40,41).forEach(value ->
//				{
//					System.out.println("Calculating: " + value);
//					System.out.println(calculationService.fibonacciPing(value));
//				}
//		);

	}
}
