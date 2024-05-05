package com.brodygaudel.accountservice.entity;

import com.brodygaudel.accountservice.enums.AccountStatus;
import com.brodygaudel.accountservice.enums.Currency;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Account {

    @Id
    private String id;

    @Column(unique = true, updatable = false, nullable = false)
    private String customerId;

    @Column(nullable = false)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus status;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Operation> operations;

    @Column(nullable = false, updatable = false)
    private LocalDateTime creation;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	private LocalDateTime lastUpdate;
}
