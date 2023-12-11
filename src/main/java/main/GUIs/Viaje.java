package main.GUIs;

import main.Buses.*;
import main.Enums.Espacio;
import main.Enums.EstadoAsiento;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Date;

public class Viaje {
    private final Bus bus;
    private final String origen;
    private final String destino;
    private final LocalDateTime fechaInicio;

    private GridBus gridF1;
    private GridBus gridF2;

    private PanelBus panelViaje;

    private Asiento[][] asientosF1;
    private Asiento[][] asientosF2;

    private void inicializarPiso(Bus bus, int piso) {
        Espacio[][] FStruct = (piso == 2) ? bus.get_2F_structure() : bus.get_1F_structure();
        Asiento[][] asientos = new Asiento[FStruct.length][FStruct[0].length];
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[0].length; j++) {
                asientos[i][j] = new Asiento(FStruct[i][j]);
            }
        }
        if (piso == 2) this.asientosF2 = asientos;
        else this.asientosF1 = asientos;
    }

    public void setGrid(GridBus grid, int piso) {
        if (piso == 2) this.gridF2 = grid;
        else this.gridF1 = grid;
    }
    public PanelBus getPanel() {
        return this.panelViaje;
    }

    private void updateGrids() {
        this.gridF1.updateGrid();
        this.panelViaje.updateSeats();
        if (this.gridF2 != null) this.gridF2.updateGrid();
    }

    public Viaje(Bus bus, String origen, String destino, LocalDateTime fechaInicio) {
        this.bus = bus;
        this.origen = origen;
        this.destino = destino;
        this.fechaInicio = fechaInicio;
        this.inicializarPiso(bus, 1);
        this.gridF1 = new GridBus(this, 1);
        if (bus.get_2F_structure() != null) {
            this.inicializarPiso(bus, 2);
            this.gridF2 = new GridBus(this, 2);
        }
        this.panelViaje = new PanelBus(this);
    }
    public Bus getBus() {return bus;}
    public String getOrigen() {return origen;}
    public String getDestino() {return destino;}
    public LocalDateTime getFechaInicio() {return fechaInicio;}

    public Asiento[][] getAsientosF1() {
        return asientosF1;
    }

    public Asiento[][] getAsientosF2() {
        return asientosF2;
    }

    public void cambiarEstadoAsiento(int piso, int row, int col, EstadoAsiento estado) {
        Asiento[][] asientos = (piso == 2) ? this.asientosF2 : this.asientosF1;
        asientos[row][col].cambiarEstado(estado);
        this.updateGrids();
    }
}
