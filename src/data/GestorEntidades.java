
package data;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Proveedor;
import model.GuiaTuristico;
import model.Registrable;


public class GestorEntidades {
    private List<Registrable> listaDesdeArchivo = new ArrayList<>();
    private List<Registrable> listaManual = new ArrayList<>();

    /**
     * Se usa cuando GestorDatos carga el archivo
     * @param registro 
     */ 
    public void agregarDesdeArchivo(Registrable registro) {
        listaDesdeArchivo.add(registro);
    }

    /**
     * Se usa cuando el usuario agrega un registro nuevo en tiempo de ejecución
     * @param registro 
     */ 
    public void agregarManual(Registrable registro) {
        listaManual.add(registro);
        System.out.println(registro.registrar());
    }
    /**
     * 
     * @return retorna desde el archivos los objeto con su formato correspondiente
     */
    public String obtenerResumenDesdeArchivo() {
        return construirResumen(listaDesdeArchivo);
    }
   /**
     * 
     * @return retorna los objetos creados desde el menú
     */
    public String obtenerResumenManual() {
        return construirResumen(listaManual);
    }
    /**
     * 
     * @return Retorna ambas listas tanto la leida desde archivo y las agregadas desde la consola
     */
    public String obtenerResumenCompleto() {
        List<Registrable> todos = new ArrayList<>();
        todos.addAll(listaDesdeArchivo);
        todos.addAll(listaManual);
        return construirResumen(todos);
    }
    
 /**
  * Contruye resumenes según el dato cargado desde Archivo o desde la lista manual en Main
  * @param lista
  * @return 
  */
    public String construirResumen(List<Registrable> lista) {

        if (lista.isEmpty()) {
            return "No hay registros para mostrar.";
        }

        String resumen = "";

        for (Registrable registro : lista) {

            if (registro instanceof Cliente) {

                Cliente cliente = (Cliente) registro;
                if(cliente.getNumeroReservas() > 4){
                     resumen += "===Cliente VIP===\n";
                }
                    resumen += cliente.mostrarDatos();                

            } else if (registro instanceof GuiaTuristico) {

                GuiaTuristico guia = (GuiaTuristico) registro;

                resumen += guia.mostrarDatos();

            } else if (registro instanceof Proveedor) {

                Proveedor proveedor = (Proveedor) registro;

                resumen += proveedor.mostrarDatos();
                
            }
            resumen += "\n-----------------------------\n";
        }

        return resumen;
    }
    
    /**
     * Metodo que filtra el guia turistico por idioma ingresado
     * @param idioma
     * @return 
     */
    public List<GuiaTuristico> filtrarGuiasPorIdioma(String idioma) {
        List<GuiaTuristico> resultado = new ArrayList<>();
        for (Registrable registro : listaDesdeArchivo) {
            if (registro instanceof GuiaTuristico guia && guia.getIdioma().equalsIgnoreCase(idioma)) {
                resultado.add(guia);
            }
        }
        for (Registrable registro : listaManual) {
            if (registro instanceof GuiaTuristico guia && guia.getIdioma().equalsIgnoreCase(idioma)) {
                resultado.add(guia);
            }
        }
        return resultado;
    }
}
