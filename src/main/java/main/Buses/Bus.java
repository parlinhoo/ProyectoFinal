package main.Buses;

import main.Enums.*;
public class Bus {
    private Espacio[][] F1structure;
    private Espacio[][] F2structure;
    private Asiento[][] F1seats;
    private Asiento[][] F2seats;

    public Asiento[][] get_1F_seats() {
        return F1seats;
    }

    public Espacio[][] get_1F_structure() {
        return F1structure;
    }

    public Asiento[][] get_2F_seats() {
        return F2seats;
    }

    public Espacio[][] get_2F_structure() {
        return F2structure;
    }

    public void changeSeat(int floor, int row, int col, Asiento asiento) {
        if (floor != 1 && floor != 2) return;
        if (floor == 1) {
            this.F1seats[row][col] = asiento;
        } else {
            this.F2seats[row][col] = asiento;
        }
    }

    public void changeStructure(int floor, int row, int col, Espacio espacio) {
        if (floor != 1 && floor != 2) return;
        if (floor == 1) {
            this.F1structure[row][col] = espacio;
        } else {
            this.F2structure[row][col] = espacio;
        }
    }

    public void initializeArray(int floor, int width, int length) {
        switch (floor) {
            case 1 -> {
                this.F1structure = new Espacio[width][length];
                this.F1seats = new Asiento[width][length];
            }
            case 2 -> {
                this.F2structure = new Espacio[width][length];
                this.F2seats = new Asiento[width][length];
            }
        }
    }
}
