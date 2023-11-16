package main.Enums;

public enum Asiento {
    LIBRE("resources/semicamalibre.png"),
    RESERVADO("resources/semicamareservado.png"),
    SELECCIONADO("resources/semicamaseleccionado.png"),
    RESTRINGIDO("");

    public final String imgpath;
    Asiento(String path) {
        this.imgpath = path;
    }
}
