package com.ak;

import com.ak.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootTestingApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootTestingApplication.class, args);

		Arrays.stream(context.getBeanDefinitionNames())
				.filter(bean -> bean.startsWith("employee"))
				.forEach(System.err::println);
	}
}
