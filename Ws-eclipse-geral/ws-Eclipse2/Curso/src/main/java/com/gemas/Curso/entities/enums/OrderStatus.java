package com.gemas.Curso.entities.enums;

public enum OrderStatus {
	PENDENTE(1), 
	EM_PROCESSAMENTO(2), 
	ENVIADO(3), 
	ENTREGUE(4), 
	CANCELADO(5);

	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid statuis code");
	}
}
