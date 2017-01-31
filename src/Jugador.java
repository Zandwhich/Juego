import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Alex on 12/29/15.
 */
public class Jugador {

    /*
    Las Variables
     */

    Random random = new Random();

    /**
     * El salud del jugador. Cuando esto es a 0, el jugador meure.
     */
    private int salud;

    /**
     * El sed del jugador. Cuando esto es menos de 25, el salud disminuye. Cuando esto es menos de 10, el salud disminuye mas.
     * Cuando esto es a 0, el salud disminuye mucho.
     */
    private int sed;

    /**
     * Las hambre del jugador. Cuando esto es menos de 25, el salud disminuye. Cuando esto es menos de 10, el salud disminuye mas.
     * Cuando esto es a 0, el salud disminuye mucho.
     */
    private int hambre;

    /**
     * El nombre del jugador. El jugador puede elegir su nombre.
     */
    private String nombre;

    /**
     * Cuanto dinero el jugador tiene. El jugador puede copmrar cosas a tiendas y pueblas.
     */
    private double dinero;

    /**
     * Cuanto sueno el jugador tiene. Cundo esto es a 0, el salud disminuye.
     */
    private int sueno;

    /**
     * Si esto es 'true', puedes tener cuanto mucho salud, sed, hambre, dinero y sueno quieres.
     */
    private boolean trampas;

    /**
     * La mochila... duh
     */
    private ArrayList<Objeto> mochila = new ArrayList<Objeto>();

    /**
     * El maximo salud el jugador puede tener sin trampas.
     */
    private final int SALUD_MAX = 100;

    /**
     * El maximo sed el jugador puede tener sin trampas.
     */
    private final int SED_MAX = 100;

    /**
     * El maximo hambre el jugador puede tener sin trampas.
     */
    private final int HAMBRE_MAX = 100;

    /**
     * El maximo sueno el jugador puede tener sin trampas.
     */
    private final int SUENO_MAX = 16;

    /**
     * El minimo salud el jugador puede tener.
     */
    private final int SALUD_MIN = 0;

    /**
     * El minimo sed el jugador puede tener.
     */
    private final int SED_MIN = 0;

    /**
     * El minimo hambre el jugador puede tener.
     */
    private final int HAMBRE_MIN = 0;

    /**
     * El minimo sueno el jugador puede tener.
     */
    private final int SUENO_MIN = 0;

    private boolean fiebreDengue;

    private boolean  malaria;

    private boolean fiebreTifoidea;

    private boolean disenteria;



    /*
    Los constructores
     */

    /**
     * Constructor para Jugador. Es muy facil.
     * @param salud El salud del jugador.
     * @param sed El sed del jugador. (100 = no sed; 0 = mucho sed)
     * @param hambre El hambre del jugador. (100 = no hambre; 0 = mucho hambre)
     * @param nombre El nombre del jugador.
     * @param dinero Cuanto dinero el jugador tiene.
     * @param sueno El sueno del jugador. (100 = no cansado; 0 = muy cansado)
     * @param trampas Las trampas.
     */
    public Jugador(int salud, int sed, int hambre, String nombre, double dinero, int sueno, boolean trampas) {
        this.salud = salud;
        this.sed = sed;
        this.hambre = hambre;
        this.nombre = nombre;
        this.dinero = dinero;
        this.sueno = sueno;
        this.trampas = trampas;
    }//end Jugoador(int salud, int sed, int hambre, String nombre)


    /**
     * Constructor para Jugador.
     * salud = 100
     * sed = 100
     * hambre = 100
     * dinero = 15
     * nombre = "Alex"
     * sueno = 100
     * trampas = false;
     */
    public Jugador() {
        this.salud = 100;
        this.sed = 100;
        this.hambre = 100;
        this.dinero = 15;
        this.nombre = "Alex";
        this.sueno = 100;
        this.trampas = false;
    }//end Jugador()

    /**
     * Constructor para Jugador, solemente con el nombre
     * salud = 100
     * sed = 100
     * hambre = 100
     * dinero = 100
     * sueno = 100
     * trampas = false
     * @param nombre El nombre del Jugador.
     */
    public Jugador(String nombre){
        this.nombre = nombre;
        this.sed = 100;
        this.salud = 100;
        this.hambre = 100;
        this.dinero = 15;
        this.sueno = 100;
        this.trampas = false;
    }//end Jugador(String nombre)



    /*
    Los adquiridores
     */

    /**
     * Regresa el nombre del jugador
     * @return El nombre
     */
    public String getNombre() {return nombre;}//end getNombre()

    /**
     * REgresa el salud del jugador
     * @return El salud
     */
    public int getSalud() {return salud;}//end getSalud()

    /**
     * Regresa el sed del jugador
     * @return El sed
     */
    public int getSed() {return sed;}//end getSed()

    /**
     * Regresa el hmabre del jugador
     * @return El hambre
     */
    public int getHambre() {return hambre;}//end getHambre()

    /**
     * Regresa el sueno del jugador
     * @return El sueno
     */
    public int getSueno() {return sueno;}//end getSueno()

    /**
     * Regresa el dinero del jugador
     * @return El dinero
     */
    public double getDinero() {return dinero;}//end getDinero();

    public boolean isMalaria() {return malaria;}//end isMalaria()

    public boolean isFiebreDengue() {return fiebreDengue;}//end isFiebreDengue()

    public boolean isFiebreTifoidea() {return fiebreTifoidea;}//end isFiebreTifoidea()

    public boolean isDisenteria() {return disenteria;}//end isDisenteria()

    /**
     * Regresa si hay trampas.
     * @return trampas
     */
    public boolean isTrampas() {return trampas;}//end isTrampas()

    /**
     * Regresa la mochila del jugador (como un ArrayList<Objeto>)
     * @return La mochila
     */
    public ArrayList<Objeto> getMochila() {return mochila;}//end getMochila

    /**
     * Regresa la mochila en un String.
     * @return La mochila en un String con un buen formato
     */
    public String mochilaToString(){
        String string = "****************** MOCHILA ******************\n";
        for (int i = 0; i < mochila.size(); i++) {
            string += mochila.get(i).getNombre() + "\n";
        }//end for
        string += "*********************************************\n";
        return string;
    }//end mochilaToString()

    /**
     * Regresa el valor de un objeto en la mochila. Si no hay este objeto con el mismo nombre, regresa -1.
     * @param nombre El nombre del objeto
     * @return Cuanto este objeto cuesta
     */
    public double valorEnMochila(String nombre){
        for (int i = 0; i < mochila.size(); i++){
            if (mochila.get(i).getNombre().equals(nombre))
                return mochila.get(i).getValor();
        }//end for
        return -1;
    }//end valorEnMochila()

    /**
     * Regresa el valor de un objeto en la mochila. Si no hay este objeto que es el mismo, regresa -1.
     * @param objeto El objeto para comprobar
     * @return Cuanto este objeto cuesta. Si no hay este objeto, regresa -1.
     */
    public double valorEnMochila(Objeto objeto){
        for (int i = 0; i < mochila.size(); i++) {
            if (mochila.get(i).equals(objeto))
                return mochila.get(i).getValor();
        }//end for
        return -1;
    }//end valorEnMochilia()

    /**
     * Regresa el valor de un objeto en la mochila. El index necesita ser en la mochila, o habran errores.
     * @param index El index en la mochila
     * @return Cuanto el objeto cuesta
     */
    public double valorEnMochila(int index){return mochila.get(index).getValor();}//end valorEnMochila()

    public int mochilaLength() {return mochila.size();}//end mochilaLength

    public String nameInMochila(int index) {return mochila.get(index).getNombre();}//end nameInMochila()

    public double valorInMochila(int index) {return mochila.get(index).getValor();}//end valorInMochila()



    /*
    Los engastadores
     */

    /**
     * Establece el nombre del jugador.
     * @param nombre El nombre
     */
    public void setNombre(String nombre) {this.nombre = nombre;}//end setNombre()

    /**
     * Establece el salud del jugador.
     * @param salud El salud
     */
    public void setSalud(int salud) {this.salud = salud;}//end setSalud()

    /**
     * Establece el sed del jugador.
     * @param sed El sed
     */
    public void setSed(int sed) {this.sed = sed;}//end setSed()

    /**
     * Establece el hambre del jugador.
     * @param hambre El hambre
     */
    public void setHambre(int hambre) {this.hambre = hambre;}//end setHambre()

    /**
     * Establece el dinero de jugador.
     * @param dinero Cuanto dinero habra
     */
    public void setDinero(double dinero) {this.dinero = dinero;}//end setDinero();

    /**
     * Establece el sueno del jugador.
     * @param sueno El sueno
     */
    public void setSueno(int sueno) {this.sueno = sueno;}//end setSueno()

    /**
     * Establece si habra trampas.
     * @param trampas Si habra trampas
     */
    public void setTrampas(boolean trampas) {this.trampas = trampas;}//end setTrampas()

    public void setDisenteria(boolean disenteria) {this.disenteria = disenteria;}//end setDisenteria()

    public void setFiebreTifoidea(boolean fiebreTifoidea) {this.fiebreTifoidea = fiebreTifoidea;}//end setFiebreTifoidea()

    public void setMalaria(boolean malaria) {this.malaria = malaria;}//end setMalaria()

    public void setFiebreDengue(boolean fiebreDengue) {this.fiebreDengue = fiebreDengue;}//end setFiebreDengue()



    /*
    Los mutatores
     */

    /**
     * Se resta del salud.
     * @param numero Cuanto se va a resta
     */
    public void menosSalud(int numero) {
        salud = salud - numero;
        if (salud < SALUD_MIN)
            salud = SALUD_MIN;
    }//end menosSalud()

    /**
     * Se resta del salud, y regresa los vitales del jugador
     * @param numero Cuanto se va a resta
     * @return "Tu Salud: getSalud()/100"
     */
    public String menosSaludIVitales(int numero){
        salud = salud - numero;
        if (salud < SALUD_MIN)
            salud = SALUD_MIN;
        return "Tu Salud: " + this.getSalud() + "/100";
    }//end menosSaludIVitales

    /**
     * Anade al salud.
     * @param numero Cuanto va a anadir
     */
    public void masSalud(int numero) {
        salud = salud + numero;
        if (salud > SALUD_MAX && !trampas)
            salud = SALUD_MAX;
    }//end masSalud()

    /**
     * Anade al salud, y regresa los vitales del jugador
     * @param numero Cuanto va a anadir
     * @return "Tu Salud: getSalud()/100"
     */
    public String masSaludIVitales(int numero){
        salud = salud + numero;
        if (salud > SALUD_MAX && !trampas)
            salud = SALUD_MAX;
        return "Tu Salud: " + this.getSalud() + "/100";
    }//end masSaludIVitales

    /**
     * Se resta del sed.
     * @param numero Cuanto se va a resta
     */
    public void menosSed(int numero) {
        sed = sed - numero;
        if (sed < SED_MIN)
            sed = SED_MIN;
    }//end menosSed()

    /**
     * Se resta del sed, y regresa los vitales del jugador
     * @param numero Cuanto va a resta
     * @return "Tu Sed: getSed()/100"
     */
    public String menosSedIVitales(int numero){
        sed = sed - numero;
        if (sed < SED_MIN)
            sed = SED_MIN;
        return "Tu Sed: " + this.getSed() + "/100";
    }//end menosSedIVitales

    /**
     * Anade al sed.
     * @param numero Cuanto va a anadir
     */
    public void masSed(int numero) {
        sed = sed + numero;
        if (sed > SED_MAX && !trampas)
            sed = 100;
    }//end masSed()

    /**
     * Anade al sed, y regresa los vitales del jugador
     * @param numero Cuanto va a anadir
     * @return "Tu Sed: getSed()/100"
     */
    public String masSedIVitales(int numero){
        sed = sed + numero;
        if (sed > SED_MAX && !trampas)
            sed = SED_MAX;
        return "Tu Sed: " + this.getSed() + "/100";
    }//end masSedIVitales

    /**
     * Se resta del hambre.
     * @param numero Cuanto se va a resta
     */
    public void menosHambre(int numero){
        hambre = hambre - numero;
        if (hambre < HAMBRE_MIN)
            hambre = HAMBRE_MIN;
    }//end menosHambre()

    /**
     * Se resta del hambre, y regresa los vitales del jugador/
     * @param numero Cuanto va a resta
     * @return "Tu Hambre: getHambre()/100"
     */
    public String menosHambreIVitales(int numero){
        hambre = hambre - numero;
        if (hambre < HAMBRE_MIN)
            hambre = HAMBRE_MIN;
        return "Tu Hahmbre: " + this.getHambre() + "/100";
    }//end menosHambreIVitales

    /**
     * Anade al hambre.
     * @param numero Cuanto va a anadir
     */
    public void masHambre(int numero){
        hambre = hambre + numero;
        if (hambre > HAMBRE_MAX && !trampas)
            hambre = 100;
    }//end masHambre()

    /**
     * Anade al hambre y regresa los vitales del jugador
     * @param numero Cuanto va a anadir
     * @return "Tu Hambre: getHambre()/100"
     */
    public String masHambreIVitales(int numero){
        hambre = hambre + numero;
        if (hambre > HAMBRE_MAX && !trampas)
            hambre = HAMBRE_MAX;
        return "Tu Hambre: " + this.getHambre() + "/100";
    }//end masHambreIVitales

    /**
     * Se resta del sueno
     * @param numero Cuanto se va a resta
     */
    public void menosSueno(int numero){
        sueno = sueno = numero;
        if (sueno < SUENO_MIN)
            sueno = SUENO_MIN;
    }//end menosSueno()

    /**
     * Se resta del sueno y regresa los vitales del jugador
     * @param numero Cuanto se va a resta
     * @return "Tu Sueno: getSueno()/100"
     */
    public String menosSuenoIVitales(int numero){
        sueno = sueno - numero;
        if (sueno < SUENO_MIN)
            sueno = SUENO_MIN;
        return "Tu Sueno: " + this.getSueno() + "/100";
    }//end menosSuenoIVitales

    /**
     * Anade al sueno.
     * @param numero Cuanto va a anadir
     */
    public void masSueno(int numero){
        sueno = sueno + numero;
        if (sueno > SUENO_MAX && !trampas)
            sueno = 16;
    }//end masSueno()

    /**
     * Anade al sueno y regresa los vitales del jugador
     * @param numero Cuanto va a anadir
     * @return "Tu Sueno: getSueno()/100"
     */
    public String masSuenoIVitales(int numero){
        sueno = sueno + numero;
        if (sueno > SUENO_MAX && !trampas)
            sueno = SUENO_MAX;
        return "Tu Sueno: " + this.getSueno() + "/100";
    }//end masSuenoIVitales

    /**
     * Se resta del dinero
     * @param numero Cuanto se va a resta
     */
    public void menosDinero(double numero) {
        dinero = dinero - numero;
        if (dinero < 0)
            dinero = 0;
    }//end menosDinero()

    /**
     * Anade al dinero.
     * @param numero Cuanto va a anadir.
     */
    public void masDinero(double numero) {dinero = dinero + numero;}//end masDinero()

    /**
     * Anade un objeto en el fin de la mochila
     * @param objeto El objeto
     */
    public void anadirAMochila(Objeto objeto) {mochila.add(objeto);}//end anadirAMochila()

    /***
     * Elimina el objeto de mochila en la posicion "index".
     * No regresa el objeto.
     * El index necesita ser en el ArrayList mochila, o va a haber errores.
     * @param index La posicion en la mochila
     */
    public void eliminarDeMochila(int index){mochila.remove(index);}//end eleminarDeMochila()

    /**
     * Quita y regresa el objeto de mochila en la posicion "index".
     * El index necesita ser en el ArrayList mochila, o va a haber errores.
     * @param index La posicion en la mochila
     * @return El objeto en la posicion "index"
     */
    public Objeto quitarDeMochila(int index){return mochila.remove(index);}//end eleminarIRegresarDeMochila()

    /**
     * Elimina el primero objeto de mochila con el mismo nombre.
     * No regresa el objeto.
     * Si no hay objeto(s) en la mochila con el mismo nombre, haga nada.
     * @param nombre El nombre del objeto
     */
    public void eliminarDeMochila(String nombre){
        for (int i = 0; i < mochila.size(); i++) {
            if (mochila.get(i).getNombre().equals(nombre)){
                mochila.remove(i);
                break;
            }//end if
        }//end for
    }//end eleminarDeMochila()

    /**
     * Quita y regresa el primero objeto de mochila con el mismo nombre.
     * Si no hay objeto(s) en la mochila con el mismo nombre, regrese "null".
     * @param nombre El nombre del objeto
     * @return El objeto en la mochila
     */
    public Objeto quitarDeMochila(String nombre) {
        for (int i = 0; i < mochila.size(); i++) {
            if (nombre.equals(mochila.get(i).getNombre())) {
                return mochila.remove(i);
            }//end if
        }//end for
        return null;
    }//end quitarDeMochila()

    /**
     * Elimina el primero objeto en la mochila que es igual a objeto (ahora, el mismo nombre y valor).
     * Si no hay objeto(s) en la mochila que es/son igual(es) a objeto, haga nada.
     * No regresa el objeto.
     * @param objeto El objeto
     */
    public void eliminarDeMochila(Objeto objeto){
        for (int i = 0; i < mochila.size(); i++) {
            if (mochila.get(i).equals(objeto)){
                mochila.remove(i);
                break;
            }//end if
        }//end for
    }//end eleminarDeMochila()

    /**
     * Quita y regresa el primero objeto en la mochila que es igual a objeto (ahora, el mismo nombre y valor).
     * Si no hay objeto(s) en la mochila que es/son igual(es) a objeto, regrese "null".
     * @param objeto El objeto
     * @return El objeto en la mochila.
     */
    public Objeto quitarDeMochila(Objeto objeto){
        for (int i = 0; i < mochila.size(); i++) {
             if (objeto.equals(mochila.get(i))){
                 return mochila.remove(i);
             }//end if
        }//end for
        return null;
    }//end quitarDeMochila()

    public void eliminarEnfermadadesTodos(){
        this.disenteria = false;
        this.fiebreDengue = false;
        this.fiebreTifoidea = false;
        this.malaria = false;

        System.out.println("No tienes enfermedades!\n");
    }//end eliminarEnfermadadesTodos()

    public void eliminarEnfermadadesUno() {
        if (this.disenteria) {
            this.disenteria = false;
            System.out.println("No tienes disenteria!\n");
        }//end if
        else if (this.fiebreTifoidea) {
            this.disenteria = false;
            System.out.println("No tienes fiebre tifoidea!\n");
        }//end else if
        else if (this.fiebreDengue) {
            this.fiebreDengue = false;
            System.out.println("No tienes fiebre Dengue!\n");
        }//end else if
        else if (this.malaria){
            this.malaria = false;
            System.out.println("No tienes malaria!\n");
        }//end else if
    }//end eliminarEnfermadadesUno()



    /*
    Otros Metodos
     */

    /**
     * Comproba la mochila para un objeto con el mismo nombre.
     * Si hay un objeto, regresa verdad. Si no, regresa falso.
     * @param nombre El nombre
     * @return Si hay un objeto en la mochila que tiene el mismo nombre
     */
    public boolean comprobarMochila(String nombre){
        for (int i = 0; i < mochila.size(); i++) {
            if (mochila.get(i).getNombre().equals(nombre))
                return true;
        }//end for
        return false;
    }//end checkMochila()

    /**
     * Comproba la mochila para un objeto en la mochila que es el mismo de objeto (ahora, el mismo nombre y valor).
     * Si hay un objto, regresa verdad. Si no, regresa falso.
     * @param objeto El objeto
     * @return Si hay un objeto en la mochila que es el mismo
     */
    public boolean comprobarMochila(Objeto objeto){
        for (int i = 0; i < mochila.size(); i++) {
            if (mochila.get(i).equals(objeto))
                return true;
        }//end for
        return false;
    }//end comprobarMochila

    /**
     * Copmroba la mochila para un objeto en la mochila que tiene el mismo nombre. Regresa el primero index.
     * Si no hay un objeto en la mochila con el mismo nombre, regresa -1.
     * @param nombre El nombre
     * @return El index del objeto con el mismo nombre. Si no hay un objeto, regresa -1.
     */
    public int indexEnMochila(String nombre){
        for (int i = 0; i < mochila.size(); i++) {
            if (mochila.get(i).getNombre().equals(nombre))
                return i;
        }//end for
        return -1;
    }//end indexEnMochila()

    /**
     * Comproba la mochila para un objeto en la mochila que es el mismo de objeto (ahora, el mismo nombre y valor).
     * Si no hay objetos en la mochila que sean el mismo, regresa -1.
     * @param objeto El objeto
     * @return El index del objeto en la mochila que es el mismo. Si no hay, regresa -1.
     */
    public int indexEnMochila(Objeto objeto){
        for (int i = 0; i < mochila.size(); i++){
            if (mochila.get(i).equals(objeto))
                return i;
        }//end for
        return -1;
    }//end indexEnMochila()

    /**
     * Regresa un String con buen formato con el dinero y la mochila.
     * @return El String con buen formato del dinero y de la mochila
     */
    public String dineroIMochila(){return "Tu Dinero: $" + this.getDinero() + "\nTu Mochila:\n" + this.mochilaToString() + "\n";}//end dineroIMochila()

    /**
     * Un metodo para verficar si el jugador tiene suficiente dinero para compra algo.
     * @param numero Cuanto esta cosa cuesta
     * @return Si el jugador puede copmrar esto.
     */
    public boolean verificarDinero(double numero){
        if (dinero - numero >= 0)
            return true;
        else
            return false;
    }//end verificarDinero()

    /**
     * Este es para verificar si el jugador es vivo.
     * @return Si el jugador es vivo
     */
    public boolean verificar(){return true;}//end vereficar()

    public String vitales(){
        String todo = "";
        todo += "Salud: " + this.getSalud() + "/100\n";
        todo += "Hambre: " + this.getHambre() + " /100\n";
        todo += "Sed: " + this.getSed() + " /100\n";
        todo += "Sueno: " + this.getSueno() + " /100\n";
        todo += "Dinero: $" + this.getDinero() + "\n";
        todo += "Enfermedades:\n";
        if (!fiebreTifoidea && !fiebreDengue && !malaria && !disenteria)
            todo += "Nada\n";
        if (fiebreDengue)
            todo += "Fiebre de Dengue\n";
        if (fiebreTifoidea)
            todo += "Fiebre Tifoidea\n";
        if (malaria)
            todo += "Malaria\n";
        if (disenteria)
            todo += "Disenteria\n";
        return todo;
    }//end vitales()

    public void usaMochila(Jugador jugador){
        Scanner in = new Scanner(System.in);

        System.out.println(this.mochilaToString() + "\n");
        System.out.println(">Salida\n");
        System.out.println("?Que quieres usar?\n");
        System.out.print(">>> ");

        String input = in.nextLine();

        if (comprobarMochila(input)){
            this.mochila.get(this.indexEnMochila(input)).usar(jugador);
            this.mochila.remove(this.indexEnMochila(input));
            this.usaMochila(jugador);
        }//end if
        else if (input.equals("Salida")) ;//end else if
        else {
            System.out.println("Perdon, pero tu no teclaste un respuesto correcto.\n");
        }//end else
    }//end usaMochila()

    public void actualizar() {
        this.sueno -= 10;
        this.sed -= 10;
        this.hambre -= 10;

        if (!fiebreDengue && random.nextInt(10) > 8) {
            fiebreDengue = true;
            System.out.println("Tienes la fiebre de Dengue!\n");
        }//end if
        if (!malaria && random.nextInt(10) > 8) {
            malaria = true;
            System.out.println("Tienes malaria!\n");
        }//end if
        if (!fiebreTifoidea && random.nextInt(10) > 8) {
            fiebreTifoidea = true;
            System.out.println("Tienes la fiebre Tifoidea!\n");
        }//end if
        if (!disenteria && random.nextInt(10) > 8) {
            disenteria = true;
            System.out.println("Tienes disenteria!\n");
        }//end if

        if (fiebreDengue)
            this.salud -= 15;
        if (fiebreTifoidea)
            this.salud -= 15;
        if (malaria)
            this.salud -= 15;
        if (disenteria)
            this.salud -= 15;
        if (sueno < 10)
            this.salud -= 10;
        if (sed < 10)
            this.salud -= 10;
        if (hambre < 10)
            this.salud -= 10;

        if (salud <= SALUD_MIN){
            //Death
        }//end if

        if (sueno >= 90 && sed >= 90 && hambre >= 90){
            salud += 5;

            if (fiebreDengue && random.nextInt(10) > 8) {
                fiebreDengue = false;
                System.out.println("No tienes la fiebre de Dengue!\n");
            }//end if
            if (fiebreTifoidea && random.nextInt(10) > 8){
                fiebreTifoidea = false;
                System.out.println("No tienes la fiebre Tifoidea!\n");
            }//end if
            if (malaria && random.nextInt(10) > 8){
                malaria = false;
                System.out.println("No tienes malaria!\n");
            }//end if
            if (disenteria && random.nextInt(10) > 8){
                disenteria = false;
                System.out.println("No tienes disenteria!\n");
            }//end if
        }//end if

        System.out.println(vitales());
    }//end actualizar()
}//end Jugador
