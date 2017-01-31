/**
 * Created by Alex on 1/13/16.
 */
public class Comida extends Objeto {

    /*
    Las variables
     */
    private int calorias;

    /*
    Los constructores
     */
    public Comida(){
        super("Comida");
        this.calorias = 10;
    }//end Comida()

    public Comida(int calorias){
        super("Comida");
        this.calorias = calorias;
    }//end Comida(calorias)

    public Comida(String nombre, double valor, int calorias){
        super(nombre, valor);
        this.calorias = calorias;
    }//end Comida(String nombre, double valor, int calorias)

    public Comida(String nombre){
        super(nombre);
        this.calorias = 10;
    }//end Comida(String nombre)

    public Comida(double valor){
        super("Comida", valor);
        this.calorias = 10;
    }//end Comida(double valor)

    public Comida(double valor, int calorias){
        super("Comida", valor);
        this.calorias = calorias;
    }//end Comida(double valor, int calorias)

    public Comida(String nombre, int calorias){
        super("Comida");
        this.calorias = calorias;
    }//end Comida(String nombre, int calorias)

    public Comida(String nombre, double valor){
        super(nombre, valor);
        this.calorias = 10;
    }//end Comida(String nombre, double valor)



    /*
    Los adquiradores
     */

    public int getCalorias() {return calorias;}//end getCalories()



    /*
    Los engastadores
     */

    public void setCalorias(int calorias) {this.calorias = calorias;}//end setCalorias()


    /*
    Otros Metodos
     */

    public void usar(Jugador jugador){
        System.out.println("\n" + jugador.masHambreIVitales(this.calorias) + "\n");
    }//end usar()
}//end Comida
