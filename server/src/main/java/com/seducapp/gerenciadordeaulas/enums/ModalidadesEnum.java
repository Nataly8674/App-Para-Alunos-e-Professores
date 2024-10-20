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

    public static ModalidadesEnum valueOfCode(int code) {
        for (ModalidadesEnum x : ModalidadesEnum.values()) {
            if (x.getCode() == code) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid ModalidadesEnum code!");
    }

    public static ModalidadesEnum fromString(String modalidade) {
        try {
            return ModalidadesEnum.valueOf(modalidade.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid ModalidadesEnum value: " + modalidade);
        }
    }
}

