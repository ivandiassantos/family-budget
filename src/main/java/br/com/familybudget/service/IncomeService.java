package br.com.familybudget.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.familybudget.exception.BusinessException;
import br.com.familybudget.form.IncomeForm;
import br.com.familybudget.model.Income;
import br.com.familybudget.repository.IncomeRepository;

@Service
public class IncomeService {

	@Autowired
	private IncomeRepository incomeRepository;
	
	@Transactional
	public void save(IncomeForm form) {
		Optional<Income> optional = incomeRepository.findByName(form.getName());
		if(optional.isPresent()) {
			throw new BusinessException("Já existe uma receita cadastrada com este nome");
		}
		Income income = new Income(form);
		incomeRepository.save(income);
	}

	@Transactional
	public void update(IncomeForm form) {
		Optional<Income> optionalIncome = incomeRepository.findById(form.getId());
		if(optionalIncome.isPresent()) {
			Income income = optionalIncome.get();
			income.setName(form.getName());
			income.setValue(form.getValue());
			income.setEventualIncome(form.isEventualIncome());
			incomeRepository.save(income);
		}
	}

	@Transactional
	public void delete(Long id) {
		incomeRepository.deleteById(id);
	}

}
