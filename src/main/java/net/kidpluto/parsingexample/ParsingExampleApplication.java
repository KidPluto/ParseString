package net.kidpluto.parsingexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ParsingExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParsingExampleApplication.class, args);
	}

   	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//
//			HelloWorld hw = new HelloWorld();
//			System.out.println(hw.toString());

			String strToParse = new String("(id,created,employee(id,firstname,employeeType(id), lastname),location)");

//			ParsingExample pe = new ParsingExample();
//			pe.setOriginalString(strToParse);
//			pe.DoIt();

			ParseExample_2 pe2 = new ParseExample_2();
			pe2.setOriginalString(strToParse);
			pe2.DoIt();

		};
	}
}
