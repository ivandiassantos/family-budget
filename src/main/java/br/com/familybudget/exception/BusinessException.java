package br.com.familybudget.exception;

public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1278542197791852241L;
	
	private String message;
	
	public BusinessException() {
	}
	
	public BusinessException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
