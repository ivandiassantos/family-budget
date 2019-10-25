package br.com.familybudget.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.familybudget.form.IncomeForm;

@Entity
@Table(name = "income", schema = "public")
public class Income {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "income_seq")
	@SequenceGenerator(sequenceName = "public.income_seq", allocationSize = 1, name = "income_seq")
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "eventual_income")
	private boolean eventualIncome;
	@Column(name = "value")
	private BigDecimal value;

	public Income() {
	}

	public Income(String name, boolean eventualIncome, BigDecimal value) {
		this.name = name;
		this.eventualIncome = eventualIncome;
		this.value = value;
	}

	public Income(IncomeForm form) {
		this.id = form.getId();
		this.name = form.getName();
		this.value = form.getValue();
		this.eventualIncome = form.isEventualIncome();
	}

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

	public void setName(String name) {
		this.name = name;
	}

	public void setEventualIncome(boolean eventualIncome) {
		this.eventualIncome = eventualIncome;
	}
	
	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
