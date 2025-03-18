package com.gemas.Curso.entities.enums;

public enum PedidoStatus {
	PENDENTE(1), 
	EM_PROCESSAMENTO(2), 
	ENVIADO(3), 
	ENTREGUE(4), 
	CANCELADO(5);

	private int code;

	private PedidoStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static PedidoStatus valueOf(int code) {
		for (PedidoStatus value : PedidoStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid statuis code");
	}
}
