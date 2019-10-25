package br.com.familybudget.controller;

import java.net.URI;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.familybudget.constants.RestConstants;
import br.com.familybudget.exception.BusinessException;
import br.com.familybudget.form.IncomeForm;
import br.com.familybudget.service.IncomeService;

@RestController
@RequestMapping(value = RestConstants.INCOME_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class IncomeController {
	
	@Autowired
	private IncomeService incomeService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity save(@RequestBody IncomeForm form) {
		try {			
			incomeService.save(form);
			return ResponseEntity.created(URI.create("")).build();
		}catch (BusinessException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity update(@RequestBody IncomeForm form) {
		try {			
			incomeService.update(form);
			return ResponseEntity.ok().build();
		}catch (BusinessException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		try {			
			incomeService.delete(id);
			return ResponseEntity.ok().build();
		}catch (ConstraintViolationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
