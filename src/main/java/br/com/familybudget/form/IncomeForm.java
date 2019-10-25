package br.com.familybudget.form;

import java.math.BigDecimal;

public class IncomeForm {
	private Long id;
	private String name;
	private BigDecimal value;
	private boolean eventualIncome;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isEventualIncome() {
		return eventualIncome;
	}
	
	public BigDecimal getValue() {
		return value;
	}

}
