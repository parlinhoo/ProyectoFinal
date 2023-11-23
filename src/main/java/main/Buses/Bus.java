package main.Buses;

import main.Enums.*;
public class Bus {
    private Espacio[][] F1structure;
    private Espacio[][] F2structure;

    public Espacio[][] get_1F_structure() {
        return F1structure;
    }

    public Espacio[][] get_2F_structure() {
        return F2structure;
    }

    public void changeStructure(int floor, int row, int col, Espacio espacio) {
        switch (floor) {
            case 1 -> this.F1structure[row][col] = espacio;
            case 2 -> this.F2structure[row][col] = espacio;
        }
    }

    public void initializeArray(int floor, int width, int length) {
        switch (floor) {
            case 1 -> {
                this.F1structure = new Espacio[width][length];
            }
            case 2 -> {
                this.F2structure = new Espacio[width][length];
            }
        }
    }
}
