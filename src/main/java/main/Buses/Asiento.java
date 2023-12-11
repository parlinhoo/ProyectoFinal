package main.Buses;

import main.Enums.Espacio;
import main.Enums.EstadoAsiento;


/**
 * Representa a un asiento, su tipo y su estado, este puede ser SALONCAMA,SEMICAMA o SALONCAMAPLUS y estar ocupado o no
 * @see Espacio
 * @see EstadoAsiento
 */
public class Asiento {

    /** Estado del asiento, recibe sus valores del enum EstadoAsiento */
    private EstadoAsiento estadoAsiento = EstadoAsiento.RESTRINGIDO;

    /** Tipo del asiento, recibe sus valores del enum EstadoAsiento */
    private final Espacio asiento;

    /**
     * Getter del estado del asiento
     * @return Estado del asiento (Libre, reservado, seleccioando o restringido)
     */
    public EstadoAsiento estado() {
        return this.estadoAsiento;
    }

    /**
     * Setter del estado del asiento
     * @param estado Estado a asignar del asiento (Libre, reservado, seleccioando o restringido)
     */
    public void cambiarEstado(EstadoAsiento estado) {
        this.estadoAsiento = estado;
    }

    /**
     * Getter del tipo del asiento
     * @return Tipo del asiento (Salon Cama,Semi Cama o Salon Cama Plus)
     */
    public Espacio tipo() {
        return this.asiento;
    }

    /**
     * Getter de la ruta de la imagen asociada al asiento
     * @return String que representa la ruta de la foto asociada
     */
    public String getimg() {
        return String.format("src/main/resources/%s%s.png", this.asiento.imgpath, this.estadoAsiento.imgpath);
    }

    /**
     * Constructor del asiento, se le asigna un tipo y luego se define libre por defecto
     * @param asiento Tipo de asiento
     */
    public Asiento(Espacio asiento) {
        this.asiento = asiento;
        switch (asiento) {
            case SALONCAMA,SEMICAMA -> this.estadoAsiento = EstadoAsiento.LIBRE;
        }
    }
}
