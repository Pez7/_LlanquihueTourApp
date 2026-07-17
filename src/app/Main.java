package app;

import data.GestorDatos;
import model.*;
import data.GestorEntidades;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import utils.RutInvalidoException;

/**
 * Clase principal del sistema Llanquihue Tour.
 *
 * Carga los datos iniciales desde un archivo de texto, y despliega un menú de consola que permite
 * listar, agregar y filtrar los distintos tipos de registros del  sistema (Cliente, GuiaTuristico, Proveedor).
 */
public class Main {
     /**
     * Método principal de ejecución.
     * Carga los registros iniciales desde {resources/datos.txt}
     * luego despliega un menú interactivo por consola hasta que el usuario elija la opción de salir.
     * 
     */
    public static void main(String[] args) {
        GestorEntidades gestor = new GestorEntidades();
        GestorDatos gestorDatos = new GestorDatos();
        Scanner scanner = new Scanner(System.in);
        
        // Carga inicial de datos desde el archivo de texto.
        // Si algún RUT del archivo es inválido, se detiene la ejecución.
        try {
            gestorDatos.cargarDatos("resources/datos.txt", gestor);
        } catch (RutInvalidoException e) {
            System.out.println("Error al cargar datos del archivo: " + e.getMessage());
            return;
        }

        int opcion = 0;
        do {
            System.out.println("\n=== Registro Llanquihue Tour ===");
            System.out.println("1. Listar registros cargados desde archivo");
            System.out.println("2. Listar registros agregados manualmente");
            System.out.println("3. Listar todos los registros");
            System.out.println("4. Agregar un nuevo registro manualmente");
            System.out.println("5. Filtrar guías turísticos por idioma");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.println("\n===== DESDE ARCHIVO =====");
                        System.out.println(gestor.obtenerResumenDesdeArchivo());
                        break;

                    case 2:
                        System.out.println("\n===== AGREGADOS MANUALMENTE =====");
                        System.out.println(gestor.obtenerResumenManual());
                        break;

                    case 3:
                        System.out.println("\n===== TODOS LOS REGISTROS =====");
                        System.out.println(gestor.obtenerResumenCompleto());
                        break;

                    case 4:
                        System.out.print("1. Agregar Cliente\n");
                        System.out.print("2. Agregar Guía Turistico\n");
                        System.out.print("3. Agregar Proveedor\n");
                        System.out.print("4. Volver al menú principal\n");
                        System.out.print("Seleccione una opción: ");
                        try {
                            int opcion2 = Integer.parseInt(scanner.nextLine());
                            switch(opcion2){
                                case 1:
                                    System.out.print("Nombre: ");
                                    String nombre = scanner.nextLine();
                                    System.out.print("Rut (ej. 12345678-9): ");
                                    Rut rut = new Rut(scanner.nextLine());
                                    System.out.print("Correo: ");
                                    String correo = scanner.nextLine();
                                    System.out.print("Teléfono: ");
                                    String telefono = scanner.nextLine();
                                    System.out.print("Calle: ");
                                    String calle = scanner.nextLine();
                                    System.out.print("Número: ");
                                    int numero = Integer.parseInt(scanner.nextLine());
                                    System.out.print("Ciudad: ");
                                    String ciudad = scanner.nextLine();
                                    System.out.print("Región: ");
                                    String region = scanner.nextLine();
                                    System.out.print("Cantidad de reservas: ");
                                    String reservas = scanner.nextLine();
                                    
                                    Direccion direccion = new Direccion(calle, ciudad, region, numero);
                                    Cliente nuevoCliente = new Cliente(Integer.parseInt(reservas),nombre, rut, correo, telefono, direccion);
                                    gestor.agregarManual(nuevoCliente);
                                    break;
                                case 2:
                                    System.out.print("Nombre: ");
                                    String nombreGuia = scanner.nextLine();
                                    System.out.print("Rut (ej. 12345678-9): ");
                                    Rut rutGuia = new Rut(scanner.nextLine());
                                    System.out.print("Correo: ");
                                    String correoGuia = scanner.nextLine();
                                    System.out.print("Teléfono: ");
                                    String telefonoGuia = scanner.nextLine();
                                    System.out.print("Calle: ");
                                    String calleGuia = scanner.nextLine();
                                    System.out.print("Número: ");
                                    int numeroGuia = Integer.parseInt(scanner.nextLine());
                                    System.out.print("Ciudad: ");
                                    String ciudadGuia = scanner.nextLine();
                                    System.out.print("Región: ");
                                    String regionGuia = scanner.nextLine();
                                    System.out.print("Idioma: ");
                                    String idioma = scanner.nextLine();
                                    System.out.print("Tipo de Tour: ");
                                    String tipoTour = scanner.nextLine();
                                    
                                    Direccion direccionguia = new Direccion(calleGuia, ciudadGuia, regionGuia, numeroGuia);
                                    GuiaTuristico nuevoGuia = new GuiaTuristico(idioma, tipoTour, nombreGuia, rutGuia, correoGuia, telefonoGuia, direccionguia);
                                    gestor.agregarManual(nuevoGuia);
                                    break;
                                case 3:
                                    System.out.print("Razón Social: ");
                                    String rznSocial = scanner.nextLine();
                                    System.out.print("Rut (ej. 12345678-9): ");
                                    Rut rutProveedor = new Rut(scanner.nextLine());
                                    System.out.print("Correo: ");
                                    String correoProveedor = scanner.nextLine();
                                    System.out.print("Tipo de proveedor (ej. Gastronómico): ");
                                    String tipoDeProveedor = scanner.nextLine();
                                    System.out.print("Calle: ");
                                    String calleProveedor = scanner.nextLine();
                                    System.out.print("Número: ");
                                    int numeroProveedor = Integer.parseInt(scanner.nextLine());
                                    System.out.print("Ciudad: ");
                                    String ciudadProveedor = scanner.nextLine();
                                    System.out.print("Región: ");
                                    String regionProveedor = scanner.nextLine();

                                    Direccion direccionProveedor = new Direccion(calleProveedor, ciudadProveedor, regionProveedor, numeroProveedor);
                                    Proveedor nuevoProveedor = new Proveedor(tipoDeProveedor, rznSocial, direccionProveedor, rutProveedor, correoProveedor);
                                    gestor.agregarManual(nuevoProveedor);
                                    break;
                                case 4:
                                    break;
                            }
                            

                        } catch (RutInvalidoException e) {
                            System.out.println("Rut inválido: " + e.getMessage());
                        } catch (NumberFormatException e) {
                            System.out.println("El número ingresado no es válido.");
                        }
                        break;

                    case 5:
                        System.out.print("Ingrese idioma a buscar: ");
                        String idioma = scanner.nextLine();
                        List<GuiaTuristico> resultado = gestor.filtrarGuiasPorIdioma(idioma);
                        System.out.println("\n===== GUÍAS QUE HABLAN: " + idioma + " =====");
                        if (resultado.isEmpty()) {
                            System.out.println("No se encontraron guías con ese idioma.");
                        } else {
                            for (GuiaTuristico guia : resultado) {
                                System.out.println(guia.mostrarDatos());
                            }
                        }
                        break;

                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}