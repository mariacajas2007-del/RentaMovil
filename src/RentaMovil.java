import java.util.ArrayList;
public class RentaMovil {
    private ArrayList<Vehiculo> vehiculos;
    private double ingresos;   

    public RentaMovil() {
        vehiculos = new ArrayList<>();
        ingresos = 0;
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        if (buscarVehiculo(vehiculo.getPlaca()) == null) {
            vehiculos.add(vehiculo);
            System.out.println("El vehículo ha sido registrado correctamente.");
        } else {
            System.out.println("Ya existe un vehículo con esa placa.");
        }
    }

    public Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }

        return null;
    }

    public void mostrarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("-------------------------");
            System.out.println("Placa: " + vehiculo.getPlaca());
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Tarifa diaria: Q" + vehiculo.getTarifaDiaria());

            if (vehiculo.isDisponible()) {
                System.out.println("Estado: Disponible");
            } else {
                System.out.println("Estado: Alquilado");
            }
        }
    }

    public void cotizar(String placa, int dias) {
        Vehiculo vehiculo = buscarVehiculo(placa);

        if (vehiculo == null) {
            System.out.println("No existe un vehículo con esa placa.");
        } else {
            double total = vehiculo.calcularCostoAlquiler(dias);

            System.out.println("Vehículo: " + vehiculo.getMarca() + " " + vehiculo.getModelo());
            System.out.println("Disponibilidad: " + (vehiculo.isDisponible() ? "Disponible" : "Alquilado"));
            System.out.printf("Costo total: Q%.2f%n", total);
        }
    }

    public void alquilarVehiculo(String placa, int dias) {
        Vehiculo vehiculo = buscarVehiculo(placa);

        if (vehiculo == null) {
            System.out.println("No existe un vehículo con esa placa.");
        } else if (!vehiculo.isDisponible()) {
            System.out.println("El vehículo ya está alquilado.");
        } else {
            double total = vehiculo.calcularCostoAlquiler(dias);

            vehiculo.alquilar();
            ingresos = ingresos + total;

            System.out.println("El alquiler fue realizado correctamente.");
            System.out.printf("Total cobrado: Q%.2f%n", total);
        }
    }

    public void devolverVehiculo(String placa) {
        Vehiculo vehiculo = buscarVehiculo(placa);

        if (vehiculo == null) {
            System.out.println("No existe un vehículo con esa placa.");
        } else if (vehiculo.isDisponible()) {
            System.out.println("El vehículo ya está disponible.");
        } else {
            vehiculo.devolver();
            System.out.println("La devolución fue registrada correctamente.");
        }
    }

    public double getIngresos() {
        return ingresos;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
}

