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

    private GridBus grid;

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

    public void setGrid(GridBus grid) {
        this.grid = grid;
    }

    public Viaje(Bus bus, String origen, String destino, LocalDateTime fechaInicio) {
        this.bus = bus;
        this.origen = origen;
        this.destino = destino;
        this.fechaInicio = fechaInicio;
        inicializarPiso(bus, 1);
        if (bus.get_2F_structure() != null) inicializarPiso(bus, 2);
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
        if (this.grid != null) this.grid.updateGrid();
    }

    // Lista es una lista del tipo lista[n][2], cuya primera dimensión es un array que contiene arrays de longitud 2 con la fila y columna, en orden.
    public void cambiarEstadoAsientosMult(int piso, int[][] lista, EstadoAsiento estado) {
        for (int[] posAsiento : lista) {
            cambiarEstadoAsiento(piso, posAsiento[0], posAsiento[1], estado);
        }
    }
}
