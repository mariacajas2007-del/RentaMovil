public class Automovil extends Vehiculo {
    private int cantidadPasajeros;
    private boolean automatico;

    public Automovil(String placa, String marca, String modelo, double tarifaDiaria, int cantidadPasajeros, boolean automatico) {
        
        super(placa, marca, modelo, tarifaDiaria);

        if (cantidadPasajeros <= 0) {
            throw new IllegalArgumentException(
                 "La cantidad de pasajeros debe ser mayor que cero."
                );
            }
        this.cantidadPasajeros = cantidadPasajeros;
        this.automatico = automatico;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public boolean isAutomatico() {
        return automatico;
    }

    @Override 
    public double calcularCostoAlquiler(int dias){
        double costo = super.calcularCostoAlquiler(dias);

        if (automatico) {
            costo = costo + (50 * dias);
        }
        return costo;
    }
}
