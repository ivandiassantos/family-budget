package br.com.familybudget.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	
}
