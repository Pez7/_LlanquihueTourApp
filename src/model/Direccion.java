
package model;


/**
 * Representa la dirección física de una Persona Proveedor.
 * Se utiliza por composición: tanto Persona como Proveedor.
 */

public class Direccion {
    // Atributos de la dirección
    private String calle;
    private String ciudad;
    private String region;
    private int numero;
 
    /**
     * Constructor de la clase Direccion.
     * 
     * @param calle nombre de la calle
     * @param numero número de la dirección
     * @param ciudad ciudad donde vive el cliente
     * @param region región donde vive el cliente
     */
    public Direccion(String calle, String ciudad, String region, int numero) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.region = region;
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

  /**
     * Muestra la dirección completa del cliente.
     * 
     * @return dirección formateada como texto
     */
     @Override
    public String toString() {
         return calle + " #" + numero + ", " + ciudad + ", Region de " + region;
    }


}

