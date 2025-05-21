package com.floresdecarbono.myEcclesia.entities.enums;

public enum TipoEvento {
    CULTO(1),
    REUNIAO(2),
    CONGRESSO(3),
    ACAMPAMENTO(4),
    CURSILHO(5),
    LAZER(6);

    private final int code;

    TipoEvento(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoEvento valueOf(int code) {
        for (TipoEvento t : TipoEvento.values()) {
            if (t.getCode() == code) {
                return t;
            }
        }
        throw new IllegalArgumentException("Tipo de evento de código " + code + " não existe.");
    }
}
