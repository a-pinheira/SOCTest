package com.soc.exame.models.entities.enums;

public enum ExameStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

	private int code;
	
	private ExameStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	//metodo estático que converte um valor númerico para um tipo ENUM 
	public static ExameStatus valueOf(int code) {
		for (ExameStatus value : ExameStatus.values()) {
			if (value.getCode() == code) {
				return value;				
			}
		}
		//se o cod digitado não for = a nenhu, exceção
		throw new IllegalArgumentException("Pagamento Inválido ExameStatus code");
	}
		
}
