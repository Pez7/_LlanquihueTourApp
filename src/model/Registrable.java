
package model;
/**
 *Interfaz reutilizable 
 */
public interface Registrable {
    /**
     * Construye un resumen legible con los datos principales del objeto.
     *
     * @return texto con el resumen de datos, formateado para mostrar por consola
     */
    public String mostrarDatos();
    
   /**
     * Marca el objeto como registrado en el sistema.
     *
     * @return mensaje de confirmación del registro exitoso
     */
    public String registrar();
}
