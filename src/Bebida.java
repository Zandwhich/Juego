/**
 * Created by Alex on 1/13/16.
 */
public class Bebida extends Objeto {

    /*
    Las variables
     */
    private int agua;

    /*
    Los constructores
     */
    public Bebida(){
        super("Bebida");
        this.agua = 10;
    }//end Bebida()

    public Bebida(int agua){
        super("Bebida");
        this.agua = agua;
    }//end Bebida(agua)

    public Bebida(String nombre, double valor, int agua){
        super(nombre, valor);
        this.agua = agua;
    }//end Bebida(String nombre, double valor, int agua)

    public Bebida(String nombre){
        super(nombre);
        this.agua = 10;
    }//end Bebida(String nombre)

    public Bebida(double valor){
        super("Bebida", valor);
        this.agua = 10;
    }//end Bebida(double valor)

    public Bebida(double valor, int agua){
        super("Bebida", valor);
        this.agua = agua;
    }//end Bebida(double valor, int agua)

    public Bebida(String nombre, int agua){
        super("Bebida");
        this.agua = agua;
    }//end Bebida(String nombre, int agua)

    public Bebida(String nombre, double valor){
        super(nombre, valor);
        this.agua = 10;
    }//end Bebida(String nombre, double valor)
    
    
    
    /*
    Los adquiradores
     */

    public int getAgua() {return agua;}//end getAgua()
    
    
    
    /*
    Los engastadores
     */

    public void setAgua(int agua) {this.agua = agua;}//end setAgua()


    /*
    Otros Metodos
     */

    public void usar(Jugador jugador){
        System.out.println("\n" + jugador.masSedIVitales(this.agua) + "\n");
    }//end usar()
}//end Bebida
