package br.com.familybudget.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.familybudget.constants.RestConstants;
import br.com.familybudget.dto.TokenDto;
import br.com.familybudget.exception.BusinessException;
import br.com.familybudget.form.LoginForm;
import br.com.familybudget.form.RegisterForm;
import br.com.familybudget.service.TokenService;
import br.com.familybudget.service.UserService;

@RestController
@RequestMapping(value = RestConstants.AUTH_PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserService userService;

	@PostMapping(value = "/authenticate")
	public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken loginData = form.converter();

		try {
			Authentication authentication = authManager.authenticate(loginData);
			String token = tokenService.generateToken(authentication);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity register(@RequestBody @Valid RegisterForm form) {
		try {
			userService.register(form);
			return ResponseEntity.ok().build();
		}catch (BusinessException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}

}
