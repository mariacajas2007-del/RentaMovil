# RentaMovil

Aplicación de consola desarrollada en Java para administrar los vehículos de una empresa de alquiler.

## Descripción

RentaMovil permite registrar automóviles, motocicletas y camionetas de carga. El sistema utiliza herencia para compartir los datos comunes de los vehículos y `@Override` para calcular el costo del alquiler según cada categoría.

## Funciones principales

- Registrar vehículos.
- Evitar placas repetidas.
- Mostrar la flota registrada.
- Buscar vehículos por placa.
- Cotizar alquileres.
- Confirmar o cancelar alquileres.
- Registrar devoluciones.
- Controlar la disponibilidad de los vehículos.
- Mostrar los ingresos acumulados.
- Generar un reporte por categoría y disponibilidad.
- Controlar entradas numéricas incorrectas.

## Clases

- `Vehiculo`: contiene la placa, marca, modelo, tarifa diaria y disponibilidad.
- `Automovil`: agrega la cantidad de pasajeros y el tipo de transmisión.
- `Motocicleta`: agrega el cilindraje.
- `CamionetaCarga`: agrega la capacidad máxima en toneladas.
- `RentaMovil`: administra la lista de vehículos, alquileres, devoluciones e ingresos.
- `Main`: contiene el menú y permite la interacción con el usuario.

## Reglas de cobro

- Los automóviles automáticos pagan Q50 adicionales por día.
- Los automóviles manuales no tienen recargo.
- Las motocicletas de más de 250 cc pagan un recargo único de Q75.
- Las camionetas pagan Q100 por cada tonelada de capacidad y por cada día.
- Todos los cálculos incluyen la tarifa diaria multiplicada por la cantidad de días.

## Requisitos

- Java JDK 8 o una versión superior.
- NetBeans, Visual Studio Code u otro entorno compatible con Java.

## Ejecución en NetBeans

1. Descargar o clonar el repositorio.
2. Abrir el proyecto en NetBeans.
3. Verificar que todos los archivos `.java` estén en el mismo paquete.
4. Abrir la clase `Main`.
5. Seleccionar la opción **Run File** o ejecutar el proyecto.
6. Utilizar el menú que aparece en la consola.

## Ejecución desde la terminal

Desde la carpeta que contiene los archivos `.java`, ejecutar:

```bash
javac *.java
java Main
```

## Datos iniciales

El programa comienza con dos automóviles, dos motocicletas y dos camionetas de carga. Todos los vehículos comienzan disponibles y los ingresos empiezan en Q0.00.

## Autor

María Cajas - 26183
Universidad del Valle de Guatemala  
CC2008 - Programación Orientada a Objetos