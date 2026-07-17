
package model;

/**
 * Representa a un GuiaTuristico de LlanquihueTour.
 * 
 * Esta clase utiliza composición, ya que un GuiaTuristico tiene una Dirección.
 * Esta clase utiliza Herencia puesto que hereda de la superClase Persona
 */

public class GuiaTuristico extends Persona implements Registrable {
    private String idioma;
    private String tipoDeTour;

    /**
     * Crea un nuevo GuiaTuristico.
     *
     * @param idioma      idioma o idiomas que maneja el guía
     * @param tipoDeTour  especialidad del guía (ej. "Excursiones")
     * @param nombre      nombre del guía
     * @param rut         RUT ya validado del guía
     * @param correo      correo electrónico del guía
     * @param telefono    teléfono del guía
     * @param direccion   dirección del guía (composición)
     */
    public GuiaTuristico(String idioma, String tipoDeTour, String nombre, Rut rut, String correo, String telefono, Direccion direccion) {
       super(nombre, rut, correo, telefono, direccion);
        this.idioma = idioma;
        this.tipoDeTour = tipoDeTour;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTipoDeTour() {
        return tipoDeTour;
    }

    public void setTipoDeTour(String tipoDeTour) {
        this.tipoDeTour = tipoDeTour;
    }

    @Override
    public String toString() {
        return super.toString() + "Idioma: "+idioma+"\nTipo de tour: "+tipoDeTour+".";

    }
    
    /**
     *Metodos de la interfaz 
     * @return resumen de la clase
     */
        @Override
    public String mostrarDatos() {
       return "===Resumen Guía Turístico ===\n" +this.toString();
    }
    
    /**
     * @return mensaje de confirmación de registro exitoso para este guía
     */
    @Override
    public String registrar(){
    return "Guía Turístico : "+ super.getNombre()+" registrado con éxito";
    }
}
