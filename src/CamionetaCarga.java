public class CamionetaCarga extends Vehiculo {
    private double capacidadToneladas;

    public CamionetaCarga(String placa, String marca, String modelo, double tarifaDiaria, double capacidadToneladas) {
        super(placa, marca, modelo, tarifaDiaria);

        if (capacidadToneladas <= 0) {
            throw new IllegalArgumentException(
                 "La capacidad debe ser mayor que cero."
            );
}
        this.capacidadToneladas = capacidadToneladas;
    }

    public double getCapacidadToneladas() {
        return capacidadToneladas;
    }

    @Override 

    public double calcularCostoAlquiler(int dias) {
        double costo = super.calcularCostoAlquiler(dias);
        double recargo = 100 * capacidadToneladas * dias;
        return costo + recargo;
    }
    
}
