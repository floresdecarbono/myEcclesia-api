package com.floresdecarbono.myEcclesia.entities.enums;

public enum Cargo {

    PASTOR(1),
    DIACONO(2),
    SECRETARIO(3),
    TESOUREIRO(4),
    LIDERANCA(5),
    MEMBRO(6);

    private final int code;

    Cargo(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Cargo valueOf(int code) {
        for (Cargo c : Cargo.values()) {
            if (c.getCode() == code) {
                return c;
            }
        }
        throw new IllegalArgumentException("Cargo de código " + " não existe.");
    }
}
