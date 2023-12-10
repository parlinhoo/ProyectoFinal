package main.Buses;

import main.Enums.Espacio;
import main.Main;

public class BusDirector {
    private final BusBuilder builder = new BusBuilder();
    public Bus semicama_comun1F() {
        builder.reset();
        builder.set1FSize(5, 10);
        builder.addObjRect(1, 0, 0, 10, 5, Espacio.SEMICAMA);
        builder.addObjRow(1, 2, Espacio.VACIO);
        builder.addObjRect(1, 3, 9, 1, 2, Espacio.VACIO);
        return builder.getBus();
    }
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
}
