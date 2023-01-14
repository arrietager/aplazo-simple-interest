package com.example.aplazo.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.aplazo.model.Response;

public class ResponseBean {
	private int payment_number;
	private double amount;
	private LocalDate payment_date;
	
	public ResponseBean() {}
	
	public ResponseBean(int payment_number, double amount, LocalDate payment_date) {
		super();
		this.payment_number = payment_number;
		this.amount = amount;
		this.payment_date = payment_date;
	}
	
	public int getPayment_number() {
		return payment_number;
	}
	public void setPayment_number(int payment_number) {
		this.payment_number = payment_number;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(LocalDate payment_date) {
		this.payment_date = payment_date;
	}
	
	@Override
	public String toString() {
		return "ResponseBean [payment_number=" + payment_number + ", amount=" + amount + ", payment_date="
				+ payment_date + "]";
	}
	
	public static ResponseBean parse(Response response) {
		return new ResponseBean(response.getPaymentNumber(), response.getAmount(), response.getPaymentDate());
	}
	
	public static List<ResponseBean> parse(List<Response> responseList) {
		List<ResponseBean> responseBeanList = new ArrayList<>();
		
		responseList.forEach(response -> responseBeanList.add(parse(response)));
		
		return responseBeanList;
	}
	
	
}
