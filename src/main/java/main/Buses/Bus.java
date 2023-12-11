package main.Buses;

import main.Enums.*;

/**
 * Representa un bus, con 1 o 2 pisos
 * @see Espacio
 */
public class Bus {

    /** Matriz que representa el primer piso del bus */
    private Espacio[][] F1structure;

    /** Matriz que representa el segundo piso del bus */
    private Espacio[][] F2structure;

    /**
     * Getter de la matriz que representa el primer piso del bus
     * @return Matriz que representa el primer piso del bus
     */
    public Espacio[][] get_1F_structure() {
        return F1structure;
    }

    /**
     * Getter de la matriz que representa el segundo piso del bus
     * @return Matriz que representa el segundo piso del bus
     */
    public Espacio[][] get_2F_structure() {
        return F2structure;
    }

    /**
     * Permite cambiar el tipo de un asiento
     * @param floor Piso en el que se encuentra el asiento
     * @param row Fila de la matriz en la que se encuentra el asiento
     * @param col Columna de la matriz en la que se encuentra el asiento
     * @param espacio Tipo al que cambiará el asiento
     */
    public void changeStructure(int floor, int row, int col, Espacio espacio) {
        switch (floor) {
            case 1 -> this.F1structure[row][col] = espacio;
            case 2 -> this.F2structure[row][col] = espacio;
        }
    }

    /**
     * Permite inicializar la matriz que representa un piso del bus
     * @param floor Piso del que inicializar la matriz
     * @param width Numero de filas de la matriz
     * @param length Numero de columnas de la matriz
     */
    public void initializeArray(int floor, int width, int length) {
        switch (floor) {
            case 1 -> {
                this.F1structure = new Espacio[width][length];
                for (int i = 0; i < this.F1structure.length; i++) {
                    for (int j = 0; j < this.F1structure[0].length; j++) {
                        this.F1structure[i][j] = Espacio.VACIO;
                    }
                }
            }
            case 2 -> {
                this.F2structure = new Espacio[width][length];
                for (int i = 0; i < this.F2structure.length; i++) {
                    for (int j = 0; j < this.F2structure[0].length; j++) {
                        this.F2structure[i][j] = Espacio.VACIO;
                    }
                }
            }
        }
    }
}
