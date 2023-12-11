package main.Buses;

import main.Enums.Espacio;

/**
 * Permite "construir un bus" paso a paso
 * @see Bus
 */
public class BusBuilder {

    /** Bus sobre el cual se va a contruir */
    private Bus bus;

    /** Permite resetear el bus sobre el cual se está construyendo, creando una instancia nueva */
    public void reset() {
        this.bus = new Bus();
    }

    /**
     * Getter del bus construido
     * @return Bus construido por el builder
     */
    public Bus getBus() {
        return this.bus;
    }

    /**
     * Permite asignar el tamaño del primer piso del bus
     * @param length Número de filas del primer piso
     * @param width Número de columnas del primer piso
     */
    public void set1FSize(int width, int length) {
        this.bus.initializeArray(1, width, length);
    }

    /**
     * Permite asignar el tamaño del segundo piso del bus
     * @param length Número de filas del segundo piso
     * @param width Número de columnas del segundo piso
     */
    public void set2FSize(int width, int length) {
        this.bus.initializeArray(2, width, length);
    }

    /**
     * Permite agregar una fila llena de un tipo de Espacio determinado
     * @param floor Número del piso al que agregar una fila
     * @param row Número de la fila a la que agregar Espacios
     * @param object Tipo de estructura a agregar
     * @see Espacio
     */
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

    /**
     * Permite agregar una columna llena de un tipo de Espacio determinado
     * @param floor Número del piso al que agregar una fila
     * @param col Número de la columna a la que agregar Espacios
     * @param object Tipo de estructura a agregar
     * @see Espacio
     */
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

    /**
     * Permite un "rectángulo" lleno de un tipo de Espacio determinado
     * @param floor Número del piso al que agregar un rectángulo
     * @param starting_row Número de la fila en la que empezar a agregar el rectángulo
     * @param starting_col Número de la columna en la que empezar a agregar el rectángulo
     * @param length Largo del rectángulo a agregar
     * @param width Ancho del rectángulo a agregar
     * @param object Tipo de estructura a agregar
     * @see Espacio
     */
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
