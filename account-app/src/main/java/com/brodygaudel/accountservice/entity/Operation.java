package com.brodygaudel.accountservice.entity;

import com.brodygaudel.accountservice.enums.Currency;
import com.brodygaudel.accountservice.enums.OperationType;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Operation {

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public OperationType getType() {
		return type;
	}

	public void setType(OperationType type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Id
    private String id;

    @Column(updatable = false, nullable = false)
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false, nullable = false)
    private OperationType type;

    @Column(updatable = false, nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false, nullable = false)
    private Currency currency;

    @Column(updatable = false, nullable = false)
    private String description;

    @ManyToOne
    private Account account;
}
