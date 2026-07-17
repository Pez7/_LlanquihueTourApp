
package model;

/**
 * Representa a una Persona.
 * 
 * Esta clase utiliza composición, ya que una Persona tiene una Dirección y un Rut.
 */
public class Persona {
    private String nombre;
    private Rut rut;
    private String correo;
    private String telefono;
    private Direccion direccion;

    /**
     * Crea una nueva Persona con sus datos básicos.
     *
     * @param nombre    nombre completo de la persona
     * @param rut       RUT ya validado de la persona
     * @param correo    correo electrónico de contacto
     * @param telefono  número de teléfono de contacto
     * @param direccion dirección asociada a la persona (composición)
     */
    
    public Persona(String nombre, Rut rut, String correo, String telefono, Direccion direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        this.rut = rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
   /**
     * Representación en texto de los datos básicos de la persona.
     *
     * @return nombre, RUT, teléfono, correo y dirección formateados
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n"
                + "Rut: " + rut + "\n"
                + "Teléfono: " + telefono +"\n"
                + "Correo: " + correo + "\n"
                + "Dirección: " + direccion.toString() + "\n";
    }
    
}
