package main.GUIs;

import main.Buses.Asiento;
import main.Buses.Bus;
import main.Enums.Espacio;
import main.Enums.EstadoAsiento;
import main.Buses.GridBus;

import java.time.LocalDateTime;

/**
 * Clase que representa un viaje, con su bus asignado, su fecha y horario
 */
public class Viaje {
    /** Bus asignado al viaje */
    private final Bus bus;
    /** String que guarda donde parte el viaje */
    private final String origen;
    /** String que guarda donde termina el viaje */
    private final String destino;
    /** Fecha que guarda los datos relacionados al tiempo en que se desarrolla el viaje */
    private final LocalDateTime fechaInicio;

    /** Grid del primer piso del bus asignado
     * @see GridBus
     */
    private GridBus gridF1;
    /** Grid del segundo piso del bus asignado
     * @see GridBus
     */
    private GridBus gridF2;

    /** PanelBus asociado al viaje
     * @see PanelBus
     */
    private PanelBus panelViaje;

    /** Matriz que contiene los asientos del primer piso del bus para este viaje
     * @see Asiento
     */
    private Asiento[][] asientosF1;

    /** Matriz que contiene los asientos del segundo piso del bus para este viaje
     * @see Asiento
     */
    private Asiento[][] asientosF2;

    /** Permite inicializar la matriz de un determinado piso
     * @param bus bus al que inicializar un piso
     * @param piso numero del piso a inicializar
     */
    private void inicializarPiso(Bus bus, int piso) {
        Espacio[][] FStruct = (piso == 2) ? bus.get_2F_structure() : bus.get_1F_structure();
        Asiento[][] asientos = new Asiento[FStruct.length][FStruct[0].length];
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[0].length; j++) {
                asientos[i][j] = new Asiento(FStruct[i][j]);
            }
        }
        if (piso == 2) this.asientosF2 = asientos;
        else this.asientosF1 = asientos;
    }

    /** Setter de un grid asociado
     * @param grid grid a asociar
     * @param piso numero del piso del grid a asociar
     */
    public void setGrid(GridBus grid, int piso) {
        if (piso == 2) this.gridF2 = grid;
        else this.gridF1 = grid;
    }

    /** Getter del panelBus asociado
     * @return PanelBus asociado al viaje
     * @see PanelBus
     */
    public PanelBus getPanel() {
        return this.panelViaje;
    }

    /** Permite actualizar los grid asociados al viaje
     * @see GridBus
     */
    private void updateGrids() {
        this.gridF1.updateGrid();
        this.panelViaje.updateSeats();
        if (this.gridF2 != null) this.gridF2.updateGrid();
    }

    /** Constructor del viaje, asigna el bus y datos como la fecha y los lugares extremos
     * @param bus
     * @param origen
     * @param destino
     * @param fechaInicio
     */
    public Viaje(Bus bus, String origen, String destino, LocalDateTime fechaInicio) {
        this.bus = bus;
        this.origen = origen;
        this.destino = destino;
        this.fechaInicio = fechaInicio;
        this.inicializarPiso(bus, 1);
        this.gridF1 = new GridBus(this, 1);
        if (bus.get_2F_structure() != null) {
            this.inicializarPiso(bus, 2);
            this.gridF2 = new GridBus(this, 2);
        }
        this.panelViaje = new PanelBus(this);
    }

    /** Getter del Bus asociado
     * @return Bus asociado al viaje
     * @see Bus
     */
    public Bus getBus() {return bus;}

    /** Getter del String con el origen del viaje
     * @return Bus asociado al viaje
     */
    public String getOrigen() {return origen;}

    /** Getter del String con el destino del viaje
     * @return Bus asociado al viaje
     */
    public String getDestino() {return destino;}

    /** Getter de la fecha del viaje
     * @return Fecha asociada al viaje
     */
    public LocalDateTime getFechaInicio() {return fechaInicio;}

    /** Getter de la matriz que contiene los asientos del primer piso en este viaje
     * @return Matriz con los asientos del primer piso de este viaje
     */
    public Asiento[][] getAsientosF1() {
        return asientosF1;
    }

    /** Getter de la matriz que contiene los asientos del segundo piso en este viaje
     * @return Matriz con los asientos del segundo piso de este viaje
     */
    public Asiento[][] getAsientosF2() {
        return asientosF2;
    }

    /** Permite cambiar el estado de un asiento en este viaje
     * @param piso piso del asiento a cambiat
     * @param row fila del asiento en la matriz
     * @param col columna del asiento en la matriz
     * @param estado estado a asignar
     */
    public void cambiarEstadoAsiento(int piso, int row, int col, EstadoAsiento estado) {
        Asiento[][] asientos = (piso == 2) ? this.asientosF2 : this.asientosF1;
        asientos[row][col].cambiarEstado(estado);
        this.updateGrids();
    }
}
