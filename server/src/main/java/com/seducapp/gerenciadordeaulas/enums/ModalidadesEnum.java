package com.seducapp.gerenciadordeaulas.enums;

public enum ModalidadesEnum {
	INTEGRAL(1),
	REGULAR(2);

	private int code;
	
	ModalidadesEnum(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static ModalidadesEnum valueOf(int code) {
		for(ModalidadesEnum x :ModalidadesEnum.values()) {
			if(x.getCode() == code) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid ModalidadesEnum code!");
	}
	
}
 