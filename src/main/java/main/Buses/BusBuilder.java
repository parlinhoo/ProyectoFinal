package main.Buses;

import main.Enums.Asiento;
import main.Enums.Espacio;

import javax.swing.*;
import java.util.Arrays;

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
        builder.addObjRect(1, 2, 1, 1, 6, Espacio.SALONCAMAPLUS);
        builder.addObjRow(1, 0, Espacio.SEMICAMA);
        Bus bus = builder.getBus();
        Espacio[][] sp = bus.get_1F_structure();
        for (Espacio[] ar : sp) {
            for (Espacio esp : ar) {
                System.out.printf("%s ", esp == null ? "nada" : esp.name());
            }
            System.out.println();
        }

        JFrame ventana = new JFrame("anashe");
        ventana.setSize(1000, 600);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setLayout(null);
        GridBus grid = new GridBus(bus, 1);
        ventana.add(grid);
    }
}
