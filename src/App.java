import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        RentaMovil rentaMovil = new RentaMovil();
        
        rentaMovil.registrarVehiculo(new Automovil("ABX123", "Toyota", "Camry", 200, 250, false));
        rentaMovil.registrarVehiculo(new Automovil("DEF456", "Honda", "Civic", 150, 200, false));

        rentaMovil.registrarVehiculo(new Motocicleta("ABC123", "Honda", "CBR500R", 150, 500));
        rentaMovil.registrarVehiculo(new Motocicleta("XYZ789", "Yamaha", "R3", 100, 300));

        rentaMovil.registrarVehiculo(new CamionetaCarga("GHI789", "Ford", "F-150", 300, 2.5));
        rentaMovil.registrarVehiculo(new CamionetaCarga("JKL012", "Chevrolet", "Silverado", 350, 3.0));


    int opcion;

    do {
        System.out.println("----- RentaMovil -----");
        System.out.println("1. Registrar vehículos");
        System.out.println("2. Mostrar vehículos");
        System.out.println("3. Cotizar alquiler");
        System.out.println("4. Alquilar vehículo");
        System.out.println("5. Devolver vehículo");
        System.out.println("6. Mostrar Reporte");
        System.out.println("0. Salir");
        System.out.print("Ingrese una opción: ");
        opcion = leerEntero(scanner, "Seleccione una opción: "
            );

            switch (opcion) {

                case 1:
                    registrarVehiculo(scanner, rentaMovil);
                    break;

                case 2:
                    rentaMovil.mostrarVehiculos();
                    break;

                case 3:
                    cotizar(scanner, rentaMovil);
                    break;

                case 4:
                    alquilar(scanner, rentaMovil);
                    break;

                case 5:
                    devolver(scanner, rentaMovil);
                    break;

                case 6:
                    mostrarReporte(rentaMovil);
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    public static void registrarVehiculo(
            Scanner scanner,
            RentaMovil rentaMovil) {

        System.out.println("1. Automóvil");
        System.out.println("2. Motocicleta");
        System.out.println("3. Camioneta de carga");

        int tipo = leerEntero(scanner,"Seleccione el tipo: "
        );

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo de vehículo inválido.");
            return;
        }

        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        if (placa.trim().isEmpty()) {
            System.out.println("La placa no puede estar vacía."
            );
            return;
        }

        if (rentaMovil.buscarVehiculo(placa) != null) {
            System.out.println("Ya existe un vehículo con esa placa."
            );
            return;
        }

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        double tarifa = leerDoublePositivo(scanner,"Tarifa diaria: Q"
        );

        switch (tipo) {

            case 1:
                int pasajeros = leerEnteroPositivo(
                        scanner,
                        "Cantidad de pasajeros: "
                );

                System.out.print("¿Es automático? (S/N): "
                );

                String respuesta = scanner.nextLine();

                boolean automatico = respuesta.equalsIgnoreCase("S");

                Automovil automovil = new Automovil(placa, marca, modelo, tarifa, pasajeros, automatico
                );

                rentaMovil.registrarVehiculo(automovil);
                break;

            case 2:
                int cilindraje = leerEnteroPositivo(
                        scanner,"Cilindraje: "
                );

                Motocicleta motocicleta = new Motocicleta(placa, marca, modelo, tarifa, cilindraje
                );

                rentaMovil.registrarVehiculo(motocicleta);
                break;

            case 3:
                double capacidad = leerDoublePositivo(scanner,"Capacidad en toneladas: "
                );

                CamionetaCarga camioneta =
                        new CamionetaCarga(placa, marca, modelo, tarifa, capacidad
                        );

                rentaMovil.registrarVehiculo(camioneta);
                break;
        }
    }

    public static void cotizar(
            Scanner scanner,
            RentaMovil rentaMovil) {

        System.out.print("Ingrese la placa: ");
        String placa = scanner.nextLine();

        int dias = leerEnteroPositivo(scanner,"Cantidad de días: "
        );

        rentaMovil.cotizar(placa, dias);
    }

    public static void alquilar(
            Scanner scanner,
            RentaMovil rentaMovil) {

        System.out.print("Ingrese la placa: ");
        String placa = scanner.nextLine();

        Vehiculo vehiculo =
                rentaMovil.buscarVehiculo(placa);

        if (vehiculo == null) {
            System.out.println( "No existe un vehículo con esa placa."
            );
            return;
        }

        if (!vehiculo.isDisponible()) {
            System.out.println( "El vehículo ya está alquilado."
            );
            return;
        }

        int dias = leerEnteroPositivo(scanner,"Cantidad de días: "
        );

        rentaMovil.cotizar(placa, dias);

        System.out.print("¿Desea confirmar el alquiler? (S/N): "
        );

        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("S")) {
            rentaMovil.alquilarVehiculo(placa, dias);
        } else {
            System.out.println("Alquiler cancelado."
            );
        }
    }

    public static void devolver(
            Scanner scanner,
            RentaMovil rentaMovil) {

        System.out.print("Ingrese la placa: ");
        String placa = scanner.nextLine();

        rentaMovil.devolverVehiculo(placa);
    }

    public static void mostrarReporte(
            RentaMovil rentaMovil) {

        int disponibles = 0;
        int alquilados = 0;

        int autosDisponibles = 0;
        int autosAlquilados = 0;

        int motosDisponibles = 0;
        int motosAlquiladas = 0;

        int camionetasDisponibles = 0;
        int camionetasAlquiladas = 0;

        for (Vehiculo vehiculo
                : rentaMovil.getVehiculos()) {

            if (vehiculo.isDisponible()) {
                disponibles++;
            } else {
                alquilados++;
            }

            if (vehiculo instanceof Automovil) {

                if (vehiculo.isDisponible()) {
                    autosDisponibles++;
                } else {
                    autosAlquilados++;
                }

            } else if (vehiculo instanceof Motocicleta) {

                if (vehiculo.isDisponible()) {
                    motosDisponibles++;
                } else {
                    motosAlquiladas++;
                }

            } else if (vehiculo
                    instanceof CamionetaCarga) {

                if (vehiculo.isDisponible()) {
                    camionetasDisponibles++;
                } else {
                    camionetasAlquiladas++;
                }
            }
        }

        System.out.println("\n===== REPORTE =====");

        System.out.println("Total de vehículos: "+ rentaMovil.getVehiculos().size()
        );

        System.out.println("Disponibles: " + disponibles
        );

        System.out.println("Alquilados: " + alquilados
        );

        System.out.println("Automóviles: " + autosDisponibles+ " disponibles y "+ autosAlquilados+ " alquilados"
        );

        System.out.println("Motocicletas: " + motosDisponibles + " disponibles y " + motosAlquiladas + " alquiladas"
        );

        System.out.println("Camionetas: " + camionetasDisponibles + " disponibles y " + camionetasAlquiladas + " alquiladas"
        );

        System.out.printf("Ingresos acumulados: Q%.2f%n", rentaMovil.getIngresos()
        );
    }

    public static int leerEntero(
            Scanner scanner,
            String mensaje) {

        while (true) {
            try {
                System.out.print(mensaje);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero."
                );
            }
        }
    }

    public static int leerEnteroPositivo(
            Scanner scanner,
            String mensaje) {

        int numero;

        do {
            numero = leerEntero(scanner, mensaje);

            if (numero <= 0) {
                System.out.println( "El número debe ser mayor que cero."
                );
            }

        } while (numero <= 0);

        return numero;
    }

    public static double leerDoublePositivo(
            Scanner scanner,
            String mensaje) {

        while (true) {
            try {
                System.out.print(mensaje);

                String entrada = scanner.nextLine();
                entrada = entrada.replace(",", ".");

                double numero =
                        Double.parseDouble(entrada);

                if (numero > 0) {
                    return numero;
                }

                System.out.println("El número debe ser mayor que cero."
                );

            } catch (NumberFormatException e) {
                System.out.println( "Debe ingresar un número válido."
                );
            }
        }
}
}
