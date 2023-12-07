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

class test {
    public static void main(String[] args) {
        BusBuilder builder = new BusBuilder();
        builder.reset();
        builder.set1FSize(5, 10);
        builder.addObjRect(1, 0, 0, 10, 5, Espacio.SEMICAMA);
        builder.addObjRow(1, 0, Espacio.SEMICAMA);
        builder.addObjRect(1, 4, 5, 2, 1, Espacio.EMERGENCIA);
        builder.addObjRect(1, 3, 5, 2, 1, Espacio.VACIO);
        builder.addObjRow(1, 2, Espacio.VACIO);
        Bus bus = builder.getBus();
        Espacio[][] sp = bus.get_1F_structure();
        for (Espacio[] ar : sp) {
            for (Espacio esp : ar) {
                System.out.printf("%s ", esp == null ? "nada" : esp.name());
            }
            System.out.println();
        }
        JFrame ventana = new JFrame("anashe");
        ventana.setLayout(null);
        Viaje viaje = new Viaje(bus, "a", "a", LocalDateTime.now());
        viaje.cambiarEstadoAsientosMult(1, new int[][]{{0, 0}, {0, 1}}, EstadoAsiento.RESERVADO);
        GridBus grid = new GridBus(viaje, 1);
        grid.setVisible(true);
        ventana.add(grid);
        ventana.pack();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setSize(1000, 800);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
