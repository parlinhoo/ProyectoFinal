package main.Enums;

/** Enum que contiene los estados de un espacio y sus rutas en el directorio*/
public enum EstadoAsiento {
    /** Espacio libre */
    LIBRE("libre"),
    /** Espacio reservado */
    RESERVADO("reservado"),
    /** Espacio seleccionado */
    SELECCIONADO("seleccionado"),
    /** Espacio restringido */
    RESTRINGIDO("");

    /** String que contiene parte de la ruta de la imagen asociada al espacio en el directorio */
    public final String imgpath;

    /**
     * Constructor por defecto, recibe el parte de la ruta de la imagen asociada
     * @param path parte de la ruta de la imagen asociada
     */
    EstadoAsiento(String path) {
        this.imgpath = path;
    }
}
