package main.Enums;

/** Enum que contiene los tipos de un espacio y sus rutas en el directorio*/
public enum Espacio {
    /** Espacio vacio */
    VACIO("vacio"),
    /** Asiento semicama */
    SEMICAMA("semicama"),
    /** Asiento salon cama */
    SALONCAMA("saloncama"),
    /** Asiento semi cama plus */
    SALONCAMAPLUS("saloncamaplus"),
    /** Espacio ocupado por una escalera */
    ESCALERA("escalera"),
    /** Espacio ocupado por la salida de emergencia */
    EMERGENCIA("emergencia");

    /** String que contiene parte de la ruta de la imagen asociada al espacio en el directorio */
    public final String imgpath;

    /**
     * Permite saber si el espacio es un asiento o no
     * @return Verdadero si es semicama, salon cama o salon cama plus, Falso si no
     */
    public Boolean IsASeat() {
        return (this == Espacio.SEMICAMA || this == Espacio.SALONCAMA || this == Espacio.SALONCAMAPLUS);
    }

    /**
     * Constructor por defecto, recibe el parte de la ruta de la imagen asociada
     * @param resourcepath parte de la ruta de la imagen asociada
     */
    Espacio(String resourcepath) {
        this.imgpath = resourcepath;
    }
}
