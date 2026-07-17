package data;

import model.Cliente;
import model.GuiaTuristico;
import model.Proveedor;
import model.Direccion;
import model.Rut;
import utils.RutInvalidoException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GestorDatos {

    /**
     * Lee un archivo .txt mixto (CLIENTE/GUIA/PROVEEDOR) y carga
     * los objetos directamente en el GestorEntidades recibido.
     *
     * @param rutaArchivo ruta del archivo .txt
     * @param gestor      gestor donde se agregan los registros leídos
     * @throws RutInvalidoException si algún RUT del archivo es inválido
     */
    public void cargarDatos(String rutaArchivo, GestorEntidades gestor) throws RutInvalidoException {

        try {
            BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
            String linea;

            while ((linea = lector.readLine()) != null) {

                if (linea.isBlank()) {
                    continue;
                }

                String[] partes = linea.split(";");
                String tipo = partes[0];

                switch (tipo) {

                    case "CLIENTE" -> {
                        // CLIENTE;numeroReservas;fechaRegistro;nombre;rut;correo;telefono;calle;numero;ciudad;region
                        if (partes.length == 10) {
                            int numeroReservas = Integer.parseInt(partes[1]);
                            String nombre = partes[2];
                            Rut rut = new Rut(partes[3]);
                            String correo = partes[4];
                            String telefono = partes[5];
                            String calle = partes[6];
                            int numero = Integer.parseInt(partes[7]);
                            String ciudad = partes[8];
                            String region = partes[9];

                            Direccion direccion = new Direccion(calle, ciudad, region, numero);
                            Cliente cliente = new Cliente(numeroReservas,nombre, rut, correo, telefono, direccion);
                            gestor.agregarDesdeArchivo(cliente);
                        } else {
                            System.out.println("Línea CLIENTE con formato incorrecto: " + linea);
                        }
                    }

                    case "GUIA" -> {
                        // GUIA;idioma;tipoDeTour;nombre;rut;correo;telefono;calle;numero;ciudad;region
                        if (partes.length == 11) {
                            String idioma = partes[1];
                            String tipoDeTour = partes[2];
                            String nombre = partes[3];
                            Rut rut = new Rut(partes[4]);
                            String correo = partes[5];
                            String telefono = partes[6];
                            String calle = partes[7];
                            int numero = Integer.parseInt(partes[8]);
                            String ciudad = partes[9];
                            String region = partes[10];

                            Direccion direccion = new Direccion(calle, ciudad, region, numero);
                            GuiaTuristico guia = new GuiaTuristico(idioma, tipoDeTour, nombre, rut, correo, telefono, direccion);
                            gestor.agregarDesdeArchivo(guia);
                        } else {
                            System.out.println("Línea GUIA con formato incorrecto: " + linea);
                        }
                    }

                    case "PROVEEDOR" -> {
                        // PROVEEDOR;tipoDeProveedor;razonSocial;calle;numero;ciudad;region;rut;correo
                        if (partes.length == 9) {
                            String tipoDeProveedor = partes[1];
                            String razonSocial = partes[2];
                            String calle = partes[3];
                            int numero = Integer.parseInt(partes[4]);
                            String ciudad = partes[5];
                            String region = partes[6];
                            Rut rut = new Rut(partes[7]);
                            String correo = partes[8];

                            Direccion direccion = new Direccion(calle, ciudad, region, numero);
                            Proveedor proveedor = new Proveedor(tipoDeProveedor, razonSocial, direccion, rut, correo);
                            gestor.agregarDesdeArchivo(proveedor);
                        } else {
                            System.out.println("Línea PROVEEDOR con formato incorrecto: " + linea);
                        }
                    }

                    default -> System.out.println("Tipo desconocido en línea: " + linea);
                }
            }
            lector.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}