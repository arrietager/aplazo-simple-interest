package com.example.aplazo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aplazo.model.Request;
import com.example.aplazo.model.Response;
import com.example.aplazo.service.SimpleInterestService;

@SpringBootTest
class SimpleinterestApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void calculatePayment() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.example.aplazo");

		context.refresh();
		
		SimpleInterestService siService = context.getBean(SimpleInterestService.class);
		
		Request request = new Request(1000,12,20);
		
		List<Response> responseList = siService.calculatePayment(request);
		
		responseList.forEach(System.out::println);
		
		context.close();
		
		assertEquals(responseList.get(0).getAmount(),100);
		
	}
}
