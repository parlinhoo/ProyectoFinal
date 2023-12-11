package main.Buses;

import main.Enums.Espacio;
import main.Enums.EstadoAsiento;

public class Asiento {
    private EstadoAsiento estadoAsiento = EstadoAsiento.RESTRINGIDO;
    private final Espacio asiento;

    public EstadoAsiento estado() {
        return this.estadoAsiento;
    }

    public Espacio tipo() {
        return this.asiento;
    }

    public String getimg() {
        return String.format("src/main/resources/%s%s.png", this.asiento.imgpath, this.estadoAsiento.imgpath);
    }

    public void cambiarEstado(EstadoAsiento estado) {
        this.estadoAsiento = estado;
    }

    public Asiento(Espacio asiento) {
        this.asiento = asiento;
        switch (asiento) {
            case SALONCAMA,SEMICAMA -> this.estadoAsiento = EstadoAsiento.LIBRE;
        }
    }
}
