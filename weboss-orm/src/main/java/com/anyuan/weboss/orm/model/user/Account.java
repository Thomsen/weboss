package com.anyuan.weboss.orm.model.user;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/**
 * 帐户: 涉及财物,钱款交易支付或管理的ID
 * @author Thomsen
 * @version 1.0
 * @since Jul 2, 2013 10:00:25 PM
 */
public class Account {
	
	private Long id;
	
	@NotNull
	@Size(min=1, max=25)
	private String name;
	
	@NotNull
	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal balance = new BigDecimal("1000");
	
	@NotNull
	@NumberFormat(style=Style.PERCENT)
	private BigDecimal equityAllocation = new BigDecimal(".60");

	@DateTimeFormat(style="S-")
	@Future
	private Date renewalDate = new Date(new Date().getTime() + 31536000000L);

	public Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getEquityAllocation() {
		return equityAllocation;
	}

	public void setEquityAllocation(BigDecimal equityAllocation) {
		this.equityAllocation = equityAllocation;
	}

	public Date getRenewalDate() {
		return renewalDate;
	}

	public void setRenewalDate(Date renewalDate) {
		this.renewalDate = renewalDate;
	}
	
	public Long assignId() {
		this.id = idSequence.incrementAndGet();
		return id;
	}
	
	private static final AtomicLong idSequence = new AtomicLong();
	
}