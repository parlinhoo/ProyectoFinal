package main.Buses;

import main.Enums.Espacio;

/**
 * Define y permite construir un modelo de bus
 * @see BusBuilder
 */
public class BusDirector {

    /** Builder el cual construirá el bus especificado */
    private final BusBuilder builder = new BusBuilder();

    /** Bus de un piso solo con asientos semicama */
    public Bus semicama_comun1F() {
        builder.reset();
        builder.set1FSize(5, 10);
        builder.addObjRect(1, 0, 0, 10, 5, Espacio.SEMICAMA);
        builder.addObjRow(1, 2, Espacio.VACIO);
        builder.addObjRect(1, 3, 9, 1, 2, Espacio.VACIO);
        return builder.getBus();
    }

    /** Bus de dos pisos solo con asientos semicama */
    public Bus semicama_2F() {
        builder.reset();
        builder.set1FSize(5, 10);
        builder.addObjRect(1, 0, 0, 10, 5, Espacio.SEMICAMA);
        builder.addObjRow(1, 2, Espacio.VACIO);
        builder.addObjRect(1, 3, 9, 1, 2, Espacio.VACIO);
        builder.set2FSize(5, 10);
        builder.addObjRect(2, 0, 0, 10, 5, Espacio.SEMICAMA);
        builder.addObjRow(2, 2, Espacio.VACIO);
        builder.addObjRect(2, 3, 9, 1, 2, Espacio.VACIO);
        return builder.getBus();
    }

    /** Bus de dos pisos con asientos salon cama abajo y asientos semicama arriba */
    public Bus mixto_comun_2F() {
        builder.reset();
        builder.set1FSize(3, 5);
        builder.addObjRect(1, 0, 0, 5, 3, Espacio.SALONCAMA);
        builder.addObjRow(1, 1, Espacio.VACIO);
        builder.addObjRect(1, 1, 4, 1, 2, Espacio.VACIO);
        builder.set2FSize(5, 10);
        builder.addObjRect(2, 0, 0, 10, 5, Espacio.SEMICAMA);
        builder.addObjRow(2, 2, Espacio.VACIO);
        builder.addObjRect(2, 3, 9, 1, 2, Espacio.VACIO);
        return builder.getBus();
    }
}
