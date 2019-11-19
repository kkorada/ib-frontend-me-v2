package com.abcbank.ib.service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankingAccountDTO {

	private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String type;

    private String customerId;

    private String number;

    private BigDecimal balance;

    private LocalDate dateOfCreation;

    private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public LocalDate getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(LocalDate dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BankingAccountDTO [id=" + id + ", name=" + name + ", type=" + type + ", customerId=" + customerId
				+ ", number=" + number + ", balance=" + balance + ", dateOfCreation=" + dateOfCreation + ", status="
				+ status + "]";
	}      
}
