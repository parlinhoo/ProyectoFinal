package main.Enums;

public enum Espacio {
    VACIO(),
    SEMICAMA(),
    SALONCAMA(),
    SALONCAMAPLUS(),
    ESCALERA(),
    EMERGENCIA();

    public Boolean IsASeat() {
        return (this == Espacio.SEMICAMA || this == Espacio.SALONCAMA || this == Espacio.SALONCAMAPLUS);
    }
}
