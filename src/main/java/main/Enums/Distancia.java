package main.Enums;

public enum Distancia {
    CCP_STGO(500, 6*60, "Concepción", "Santiago"),
    STGO_CCP(500, 6*60, "Santiago", "Concepción"),
    VALPO_CCP(674, 8*60, "Valparaíso", "Concepción"),
    CCP_VALPO(674, 8*60, "Concepción", "Valparaíso"),
    STGO_VALPO(174, 2*60, "Santiago", "Valparaíso"),
    VALPO_STGO(174, 2*60, "Valparaíso", "Santiago");
    public final int distancia;
    public final int minutos;
    public final String origen;
    public final String destino;

    public static Distancia getEnum(String origen, String destino) {
        for (Distancia dist : Distancia.values()) {
            if (dist.origen.equals(origen) && dist.destino.equals(destino)) {
                return dist;
            }
        }
        return null;
    }

    Distancia(int dist, int mins, String origen, String destino) {
        this.distancia = dist;
        this.minutos = mins;
        this.origen = origen;
        this.destino = destino;
    }
}
