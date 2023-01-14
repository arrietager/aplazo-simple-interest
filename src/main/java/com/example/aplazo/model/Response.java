package com.example.aplazo.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="response")
public class Response {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="requestId")
	private int requestId;
	
	@Column(name="payment_number")
	private int paymentNumber;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="payment_date")
	private LocalDate paymentDate;
	
	public Response(){}
	
	public Response(int requestId, int paymentNumber, double amount, LocalDate paymentDate) {
		this.requestId = requestId;
		this.paymentNumber = paymentNumber;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Response [id=" + id + ", requestId=" + requestId + ", paymentNumber=" + paymentNumber + ", amount="
				+ amount + ", paymentDate=" + paymentDate + "]";
	}

}
