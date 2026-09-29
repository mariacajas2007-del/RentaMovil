public class Motocicleta extends Vehiculo {
    private int cilindraje;

    public Motocicleta(String placa, String marca, String modelo, double tarifaDiaria, int cilindraje) {
        super(placa, marca, modelo, tarifaDiaria);

        if (cilindraje <= 0) {
            throw new IllegalArgumentException(
             "El cilindraje debe ser mayor que cero."
            );
        }
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    @Override 

    public double calcularCostoAlquiler(int dias) {
        double costo = super.calcularCostoAlquiler(dias);

        if (cilindraje > 250) {
            costo = costo + 75;
        }
        return costo;
    }
    
}
