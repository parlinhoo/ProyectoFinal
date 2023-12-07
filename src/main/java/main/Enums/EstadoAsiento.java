package main.Enums;

public enum EstadoAsiento {
    LIBRE("libre"),
    RESERVADO("reservado"),
    SELECCIONADO("seleccionado"),
    RESTRINGIDO("");

    public final String imgpath;
    EstadoAsiento(String path) {
        this.imgpath = path;
    }
}
