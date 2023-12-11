package test;

import main.Buses.Bus;
import main.Buses.BusDirector;
import main.Enums.Espacio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BusDirectorTest {

    @Test
    void testSemicamaComun1F() {

        BusDirector director = new BusDirector();
        Bus bus = director.semicama_comun1F();
        Espacio[][] asientos = bus.get_1F_structure();

        // Verificar que todos los elementos en la fila 0 son SEMICAMA
        int fila = 0;
        for (int col = 0; col < asientos[fila].length; col++) {
            assertEquals(Espacio.SEMICAMA, asientos[fila][col]);
        }

        // Verificar que todos los elementos en la fila 1 son SEMICAMA
        fila = 1;
        for (int col = 0; col < asientos[fila].length; col++) {
            assertEquals(Espacio.SEMICAMA, asientos[fila][col]);
        }

        //VERIFICANDO EL PASILLO
        fila = 2;
        for (int col = 0; col < asientos[fila].length; col++) {
            assertEquals(Espacio.VACIO, asientos[2][col]);
        }

        // Verificar que todos los elementos en la fila 3 (menos el final) son SEMICAMA
        fila = 3;
        for (int col = 0; col < asientos[fila].length-1; col++) {
            assertEquals(Espacio.SEMICAMA, asientos[fila][col]);
        }

        // Verificar que todos los elementos en la fila 4 (menos el final) son SEMICAMA
        fila = 4;
        for (int col = 0; col < asientos[fila].length-1; col++) {
            assertEquals(Espacio.SEMICAMA, asientos[fila][col]);
        }
        //VERIFICANDO LA NO EXISTENCIA DEL 2DO PISO
        assertNull(bus.get_2F_structure());

    }

    @Test
    void testSemicama2F() {

        BusDirector director = new BusDirector();
        Bus bus = director.semicama_2F();

        //VERIFICANDO LA EXISTENCIA DEL 2DO PISO
        assertNotNull(bus.get_2F_structure());
    }

    @Test
    void testMixtoPremium2F() {

        BusDirector director = new BusDirector();
        Bus bus = director.mixto_premium_2F();

        //VERIFICANDO LA EXISTENCIA DEL 2DO PISO
        assertNotNull(bus.get_2F_structure());

    }

    @Test
    void testSaloncamaPremium1F() {

        BusDirector director = new BusDirector();

        Bus bus = director.saloncama_premium1F();

        Espacio[][] asientos = bus.get_1F_structure();

        //VERIFICANDO LA NO EXISTENCIA DEL 2DO PISO
        assertNull(bus.get_2F_structure());

        // Verificar que todos los elementos en la fila 0 (menos el final) son SALONCAMA
        int fila = 0;
        for (int col = 0; col < asientos[fila].length; col++) {
            assertEquals(Espacio.SALONCAMA, asientos[fila][col]);
        }

        //VERIFICANDO EL PASILLO
        fila = 1;
        for (int col = 0; col < asientos[fila].length; col++) {
            assertEquals(Espacio.VACIO, asientos[fila][col]);
        }

        // Verificar que todos los elementos en la fila 2 (menos el final) son SALONCAMA
        fila = 2;
        for (int col = 0; col < asientos[fila].length-1; col++) {
            assertEquals(Espacio.SALONCAMA, asientos[fila][col]);
        }
    }
}
