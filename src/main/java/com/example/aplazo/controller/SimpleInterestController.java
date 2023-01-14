package com.example.aplazo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aplazo.bean.ResponseBean;
import com.example.aplazo.bean.ResponseMessageBean;
import com.example.aplazo.model.*;
import com.example.aplazo.service.SimpleInterestService;

@RestController
@RequestMapping("/simpleinterest")
public class SimpleInterestController {
	
	@Autowired
	SimpleInterestService simpleInterestService;
	
	@PostMapping("/payments")
	public ResponseEntity<ResponseMessageBean> calculatePayments(@RequestBody Request request){
		ResponseMessageBean response = new ResponseMessageBean(true, "Payments calculated successfully!!");
		boolean success = true;
		String message = "";
		
		if(request.getTerms() > 52 || request.getTerms() < 4) {
			success = false;
			message = "Terms value is out of range (4-52).\n";
		}
			
		if(request.getRate() > 100 || request.getRate() < 1) {
			success = false;
			message = message + "Rate value is out of range (1-100).\n";
		}
		
		if(request.getAmount() > 999999 || request.getAmount() < 1){
			success = false;
			message = message + "Amount value is out of range (1-999999).";
		}
		
		if(!success)
			return new ResponseEntity<>(new ResponseMessageBean(success, message), HttpStatus.BAD_REQUEST);
		
		
		try {
			List<Response> responseList = simpleInterestService.calculatePayment(request);
			
			List<ResponseBean> responseBeanList = ResponseBean.parse(responseList);
			
			response.setResponse(responseBeanList);
			response.setRequestId(responseList.get(0).getRequestId());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(new ResponseMessageBean(false, "Unexpected error while calculating payments."), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
