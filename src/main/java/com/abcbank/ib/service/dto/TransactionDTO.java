package com.abcbank.ib.service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionDTO {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String accountId;

	private String type;

	private BigDecimal amount;

	private LocalDate dateOfTransaction;

	private String description;

	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TransactionDTO [id=" + id + ", accountId=" + accountId + ", type=" + type + ", amount=" + amount
				+ ", dateOfTransaction=" + dateOfTransaction + ", description=" + description + ", status=" + status
				+ "]";
	}

}
