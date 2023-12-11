package main;

import main.Buses.*;
import main.Enums.Espacio;
import main.GUIs.PanelBus;
import main.GUIs.Viaje;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

// Hay pocos test que hacer porque en el codigo hay pocas cosas que pueden variar y
// todo es muy "contínuo", es decir, todo está hecho para que funcione para cualquier valor,
// y no solo hard-codeado. Además, las interfaces gráficas se probaron visualmente en el
// momento de creación y no con unit tests.

class MainTest {

    // Probando si no tira error
    @Test
    void createBus() {
        BusBuilder builder = new BusBuilder();
        builder.reset();
        builder.set1FSize(5, 10);
        builder.addObjRow(1, 2, Espacio.SEMICAMA);
        Bus bus1 = builder.getBus();

        builder.reset();
        builder.set1FSize(3, 5);
        builder.addObjRect(1, 0, 0, 5, 3, Espacio.SALONCAMA);
        Bus bus2 = builder.getBus();

        builder.reset();
        builder.set1FSize(5, 10);
        builder.addObjRect(1, 0, 0,10, 5, Espacio.SEMICAMA);
        builder.addObjRow(1, 2, Espacio.VACIO);
        Bus bus3 = builder.getBus();
    }

    // También probando si no tira error
    @Test
    void crearViajeyGridBus() {
        BusDirector director = new BusDirector();
        Bus bus = director.semicama_comun1F();
        Viaje viaje = new Viaje(bus, "Concepción", "Santiago", LocalDateTime.now());
        Asiento[][] grid = viaje.getAsientosF1();
        PanelBus panel = viaje.getPanel();
        GridBus gridBus = new GridBus(viaje, 1);
        gridBus.updateGrid();
    }
}