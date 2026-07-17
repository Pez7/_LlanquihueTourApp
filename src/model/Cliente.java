
package model;

/**
 * Representa a un cliente de LlanquihueTour.
 * 
 * Esta clase utiliza composición, ya que un Cliente tiene una Dirección y un Rut.
 * Esta clase utiliza Herencia puesto que hereda de la superClase Persona
 */
public class Cliente extends Persona implements Registrable {
    private int numeroReservas;
    
    /**
     * Crea un nuevo Cliente.
     *
     * @param numeroReservas cantidad de reservas realizadas por el cliente
     * @param nombre         nombre del cliente
     * @param rut            RUT ya validado del cliente
     * @param correo         correo electrónico del cliente
     * @param telefono       teléfono del cliente
     * @param direccion      dirección del cliente (composición)
     */
    public Cliente(int numeroReservas, String nombre, Rut rut, String correo, String telefono, Direccion direccion) {
        super(nombre, rut, correo, telefono, direccion);
        this.numeroReservas = numeroReservas;
    }

    
    public int getNumeroReservas() {
        return numeroReservas;
    }

    public void setNumeroReservas(int numeroReservas) {
        this.numeroReservas = numeroReservas;
    }

    @Override
    public String toString() {
        return "Cliente: " +super.toString()+ "Reservas: "+ numeroReservas;
    }

    /**
     *Metodos de la interfaz 
     * @return resumen de la clase
     */
    
    @Override
    public String mostrarDatos() {
       return "===Resumen Cliente ===\n" +this.toString();
    }
    
    /**
     * @return mensaje de confirmación de registro exitoso para este cliente
     */

    @Override
    public String registrar(){
        return "Cliente: "+ super.getNombre()+" registrado con éxito";
    }
}
