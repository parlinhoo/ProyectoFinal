package main.Buses;

import main.Enums.Espacio;
import main.Enums.EstadoAsiento;
import main.GUIs.Viaje;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.time.LocalDateTime;

public class BusBuilder {
    private Bus bus;
    public void reset() {
        this.bus = new Bus();
    }
    public Bus getBus() {
        return this.bus;
    }
    public void set1FSize(int width, int length) {
        this.bus.initializeArray(1, width, length);
    }
    public void set2FSize(int width, int length) {
        this.bus.initializeArray(2, width, length);
    }
    public void addObjRow(int floor, int row, Espacio object) {
        Espacio[][] structure;
        switch (floor) {
            case 1 -> structure = this.bus.get_1F_structure();
            case 2 -> structure = this.bus.get_2F_structure();
            default -> {return;}
        }
        for (int i = 0; i < structure[row].length; i++) {
            this.bus.changeStructure(floor, row, i, object);
        }
    }
    public void addObjColumn(int floor, int col, Espacio object) {
        Espacio[][] structure;
        switch (floor) {
            case 1 -> structure = this.bus.get_1F_structure();
            case 2 -> structure = this.bus.get_2F_structure();
            default -> {return;}
        }
        for (int i = 0; i < structure.length; i++) {
            this.bus.changeStructure(floor, i, col, object);
        }
    }
    public void addObjRect(int floor, int starting_row, int starting_col, int length, int width, Espacio object) {
        Espacio[][] structure;
        switch (floor) {
            case 1 -> structure = this.bus.get_1F_structure();
            case 2 -> structure = this.bus.get_2F_structure();
            default -> {return;}
        }
        for (int i = starting_row; i < Math.min(structure.length, starting_row + width); i++) {
            for (int j = starting_col; j < Math.min(structure[i].length, starting_col + length); j++) {
                this.bus.changeStructure(floor, i, j, object);
            }
        }
    }
}
