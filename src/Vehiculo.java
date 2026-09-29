public class Vehiculo {
    protected String placa;
    protected String marca;
    protected String modelo;
    protected double tarifaDiaria;
    protected boolean disponible;

    public Vehiculo(String placa, String marca, String modelo, double tarifaDiaria) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La placa no puede estar vacía."
            );
        }

        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La marca no puede estar vacía."
            );
        }

        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El modelo no puede estar vacío."
            );
        }

        if (tarifaDiaria <= 0) {
            throw new IllegalArgumentException(
                    "La tarifa diaria debe ser mayor que cero."
            );
        }

        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tarifaDiaria = tarifaDiaria;
        this.disponible = true;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public boolean isDisponible() {
        return disponible;
    } 

    public double calcularCostoAlquiler(int dias) {
         if (dias <= 0) {
            throw new IllegalArgumentException(
                    "Los días deben ser mayores que cero."
            );
        }
        return tarifaDiaria * dias;
    }

    public void alquilar() {
        if (!disponible) {
            throw new IllegalStateException(
                    "El vehículo ya está alquilado."
            );
        }
        disponible = false;
    }

    public void devolver() {
        if (disponible) {
            throw new IllegalStateException(
                    "El vehículo ya está disponible."
            );
        }
        disponible = true;
    }

    
}

