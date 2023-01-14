package com.example.aplazo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aplazo.model.*;
import com.example.aplazo.repository.*;

@Service
public class SimpleInterestService {
	
	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	ResponseRepository responseRepository;
	
	public List<Response> calculatePayment(Request request){
		List<Response> responseList = new ArrayList<>();
		
		LocalDate ld = LocalDate.now();
		
		Request req = requestRepository.save(request);
		
		double amount = request.getAmount();
		double rateAmount = amount * request.getRate() / 100;
		double amountWithInterest = amount + rateAmount;
		double weeklyAmount = amountWithInterest / request.getTerms();

		for(int i = 1; i <= request.getTerms(); i++)
			responseList.add(new Response(req.getId(), i, weeklyAmount, ld.plusWeeks(i)));
		
		responseRepository.saveAll(responseList);
		
		return responseList;
	}
	
	public List<Response> getPaymentsByRequestId(int requestId) {
		return responseRepository.findByRequestId(requestId);
	}
}
