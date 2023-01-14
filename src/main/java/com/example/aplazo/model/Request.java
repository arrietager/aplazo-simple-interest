package com.example.aplazo.model;

import javax.persistence.*;

@Entity
@Table(name="request")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="terms")
	private int terms;
	
	@Column(name="rate")
	private double rate;
	
	public Request(){}
	
	public Request(double amount, int terms, double rate) {
		this.amount = amount;
		this.terms = terms;
		this.rate = rate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTerms() {
		return terms;
	}

	public void setTerms(int terms) {
		this.terms = terms;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", amount=" + amount + ", terms=" + terms + ", rate=" + rate + "]";
	}
}
