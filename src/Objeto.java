/**
 * Created by Alex on 1/6/16.
 */
public class Objeto {

    /*
    Las variables
     */
    private double valor;
    private String nombre;



    /*
    Los constructores
     */
    public Objeto(){
        this.setNombre("Objeto");
        this.setValor(0);
    }//end Objeto()

    public Objeto(String nombre, double valor) {
        this.setNombre(nombre);
        this.setValor(valor);
    }//end Objeto(String nombre, double valor)

    public Objeto(String nombre){
        this.setNombre(nombre);
        this.setValor(0);
    }//end Objeto(String nombre)

    public Objeto(double valor){
        this.setNombre("Objeto");
        this.setValor(0);
    }//end Objeto(double valor)



    /*
    Los engastadores
     */
    public void setNombre(String nombre) {this.nombre = nombre;}//end setNombre()

    public void setValor(double valor) {this.valor = valor;}//end setValor()



    /*
    Los adquiridores
     */
    public String getNombre() {return nombre;}//end getNombre()

    public double getValor() {return valor;}//end getValor()



    /*
    Otros metodos
     */
    public boolean equals(Objeto objeto){
        if (objeto.getNombre().equals(this.getNombre()) && objeto.getValor() == this.getValor())
            return true;
        return false;
    }//end equals()

    public void usar(Jugador jugador){
        //Necesita creendo en las otras classes
    }//end usar()
}//end Objeto
