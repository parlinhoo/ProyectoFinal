package main.Enums;

public enum Espacio {
    VACIO(null),
    SEMICAMA("semicamalibre.png"),
    SALONCAMA(null),
    SALONCAMAPLUS(null),
    ESCALERA(null),
    EMERGENCIA(null);
    private String imgpath;

    public String getImgpath() {
        return this.imgpath;
    }

    public Boolean IsASeat() {
        return (this == Espacio.SEMICAMA || this == Espacio.SALONCAMA || this == Espacio.SALONCAMAPLUS);
    }
    Espacio(String resourcepath) {
        if (resourcepath == null) this.imgpath = null;
        else this.imgpath = String.format("src/main/resources/%s", resourcepath);
    }
}
