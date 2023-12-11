package main.Enums;

public enum Espacio {
    VACIO("vacio"),
    SEMICAMA("semicama"),
    SALONCAMA("saloncama"),
    ESCALERA("escalera"),
    EMERGENCIA("emergencia");
    public final String imgpath;

    public Boolean IsASeat() {
        return (this == Espacio.SEMICAMA || this == Espacio.SALONCAMA);
    }
    Espacio(String resourcepath) {
        this.imgpath = resourcepath;
    }
}
