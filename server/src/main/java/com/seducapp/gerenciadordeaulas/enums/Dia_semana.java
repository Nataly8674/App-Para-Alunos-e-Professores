package com.seducapp.gerenciadordeaulas.enums;

public enum Dia_semana {
	DOMINGO(1),
	SEGUNDA(2),
	TERÇA(3),
	QUARTA(4),
	QUINTA(5),
	SEXTA(6),
	SABADO(7);
	
	private int code;
	
	Dia_semana(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Dia_semana valueOf(int code) {
		for(Dia_semana x :Dia_semana.values()) {
			if(x.getCode() == code) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid ModalidadesEnum code!");
	}
}
