package main.GUIs;

import main.Buses.*;

public class Viaje {
    private Bus bus;
    private String origen;
    private String destino;
    private String horaInicio;

    public Viaje(Bus bus, String origen, String destino, String horaInicio) {
        this.bus = bus;
        this.origen = origen;
        this.destino = destino;
        this.horaInicio = horaInicio;
    }
    public Bus getBus() {return bus;}
    public String getOrigen() {return origen;}
    public String getDestino() {return destino;}
    public String getHoraInicio() {return horaInicio;}

}
