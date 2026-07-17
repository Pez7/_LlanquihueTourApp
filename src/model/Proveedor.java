
package model;

/**
 * Representa a un Proveedor externo de Llanquihue Tour (operador de
 * transporte, proveedor de alojamiento, gastronómico, etc.).
 * A diferencia de  Cliente GuiaTuristico, no hereda de
 * Persona, ya que un Proveedor puede representar una empresa (razón social) y no una persona natural. Reutiliza  Rut y
 *  Direccion por composición, e implementa Registrable.
 */
public class Proveedor implements Registrable {
    private String tipoDeProveedor;
    private String razonSocial;
    private Direccion direccion;
    private Rut rut;
    private String correo;

   /**
     * Crea un nuevo Proveedor.
     *
     * @param tipoDeProveedor tipo de servicio que ofrece (ej. "Transporte")
     * @param razonSocial     nombre legal de la empresa proveedora
     * @param direccion       dirección del proveedor (composición)
     * @param rut             RUT ya validado del proveedor
     * @param correo          correo electrónico de contacto
     */
    public Proveedor(String tipoDeProveedor, String razonSocial, Direccion direccion, Rut rut, String correo) {
        this.tipoDeProveedor = tipoDeProveedor;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.rut = rut;
        this.correo = correo;
    }

    public String getTipoDeProveedor() {
        return tipoDeProveedor;
    }

    public void setTipoDeProveedor(String tipoDeProveedor) {
        this.tipoDeProveedor = tipoDeProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
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
    /**
     * @return tipo, razón social, dirección, RUT y correo del proveedor,
     *         formateados como texto
     */
    @Override
    public String toString() {
        return "Tipo de Proveedor: " + tipoDeProveedor + "\nRazón Social: " + razonSocial + "\nDirección: " + direccion.toString() + "\nRut: " + rut + "\nCorreo: " + correo;
    }    
    /**
     *Metodos de la interfaz 
     * @return resumen de la clase
     */
    @Override
    public String mostrarDatos() {
       return "===Resumen Proveedor ===\n" +this.toString();
    }
    /**
     * @return mensaje de confirmación de registro exitoso para este proveedor
     */
    @Override
    public String registrar(){
    return "Proveedor : "+ this.getRazonSocial()+" registrado con éxito";
    }
}
