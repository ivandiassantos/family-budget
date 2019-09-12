package br.com.familybudget.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.familybudget.form.RegisterForm;
import br.com.familybudget.model.User;
import br.com.familybudget.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void register(RegisterForm form) {
		User user = new User(form);
	}
}
