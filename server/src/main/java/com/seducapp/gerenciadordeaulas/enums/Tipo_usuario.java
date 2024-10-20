package com.seducapp.gerenciadordeaulas.enums;

public enum Tipo_usuario {
	ALUNO(1),
	PROFESSOR(2);
	
	private int code;
	
	Tipo_usuario(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Tipo_usuario valueOf(int code) {
		for(Tipo_usuario x :Tipo_usuario.values()) {
			if(x.getCode() == code) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid ModalidadesEnum code!");
	}
	
	public static Tipo_usuario fromString(String tipo) {
        try {
            return Tipo_usuario.valueOf(tipo.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid Tipo_usuario value: " + tipo);
        }
    }
}
