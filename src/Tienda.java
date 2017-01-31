import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alex on 1/6/16.
 */
public class Tienda {

    private ArrayList<Objeto> existencia = new ArrayList<Objeto>();

    public void anadirAExistencia(Objeto objeto) {
        existencia.add(objeto);
    }//end anadirAExistencia()

    public Objeto quitarAExistencia(String objeto) {
        for (int i = 0; i < existencia.size(); i++) {
            if (objeto.equals(existencia.get(i).getNombre())) {
                return existencia.remove(i);
            }//end if
        }//end for
        return null;
    }//end quitarAExistencia

    /**
     * Este metodo monstra todas las cosas en la existencia
     * @return La existencia
     */
    public String monstrar(){
        String elReturn = "";

        for (int i = 0; i < existencia.size(); i++) {
            elReturn += existencia.get(i).getNombre();
            if (existencia.get(i).getNombre().length() + Double.toString(existencia.get(i).getValor()).length() + 1 < 6)
                elReturn += "\t\t\t\t\t\t\t\t\t\t\t";
            else if (existencia.get(i).getNombre().length() + Double.toString(existencia.get(i).getValor()).length() + 1 < 10)
                elReturn += "\t\t\t\t\t\t\t\t\t\t";
            else if (existencia.get(i).getNombre().length() + Double.toString(existencia.get(i).getValor()).length() + 1 < 14)
                elReturn += "\t\t\t\t\t\t\t\t\t";
            else if (existencia.get(i).getNombre().length() + Double.toString(existencia.get(i).getValor()).length() + 1 < 18)
                elReturn += "\t\t\t\t\t\t\t\t";
            else if (existencia.get(i).getNombre().length() + Double.toString(existencia.get(i).getValor()).length() + 1 < 22)
                elReturn += "\t\t\t\t\t\t\t";
            else if (existencia.get(i).getNombre().length() + Double.toString(existencia.get(i).getValor()).length() + 1 < 26)
                elReturn += "\t\t\t\t\t\t";
            else if (existencia.get(i).getNombre().length() + Double.toString(existencia.get(i).getValor()).length() + 1 < 30)
                elReturn += "\t\t\t\t\t";
            else if (existencia.get(i).getNombre().length() + Double.toString(existencia.get(i).getValor()).length() + 1 < 34)
                elReturn += "\t\t\t\t";
            else if (existencia.get(i).getNombre().length() + Double.toString(existencia.get(i).getValor()).length() + 1 < 38)
                elReturn += "\t\t\t";
            else if (existencia.get(i).getNombre().length() + Double.toString(existencia.get(i).getValor()).length() + 1 < 42)
                elReturn += "\t\t";
            else
                elReturn += "\t";
            elReturn += "$" + existencia.get(i).getValor() + "\n";
        }//end for

        //elReturn += "Salida\t\t\t\t\t\t\t\t\t\t$0\n";

        return "******************* TIENDA *******************\n" + elReturn + "**********************************************\n>Salida\n\n";
    }//end monstrar()

    public void comprar(Jugador jugador){
        Scanner in = new Scanner(System.in);

        jugador.dineroIMochila();

        System.out.println("Tu Dinero: $" + jugador.getDinero() + "\n");

        System.out.print(this.monstrar());

        System.out.print(">>> ");
        String input = in.nextLine();

        int recuerda = -1;
        for (int i = 0; i < existencia.size(); i++) {
            if (existencia.get(i).getNombre().equals(input))
                recuerda = i;
        }//end for

        if (input.equals("Salida"));
        else if (recuerda == -1) {
            System.out.println("Perdon, pero tu input no emparejo con la existencia.\n");
            this.comprar(jugador);
        }//end else if
        else {
            if (jugador.verificarDinero(existencia.get(recuerda).getValor())){
                System.out.println("\n?Quieres comprar " + existencia.get(recuerda).getNombre() + " por $" + existencia.get(recuerda).getValor() + "? ('Si' o 'No')");
                System.out.print(">>> ");

                input = in.nextLine();
                if (input.equals("Si")){
                    jugador.anadirAMochila(existencia.get(recuerda));
                    jugador.menosDinero(existencia.get(recuerda).getValor());
                    existencia.remove(recuerda);
                    System.out.println("\n\nTu Dinero:\t$" + jugador.getDinero());
                    System.out.println("Tu Mochila:\n" + jugador.mochilaToString());
                    this.comprar(jugador);
                }//end if
                else
                    this.comprar(jugador);
            }//end if
            else {
                System.out.println("Perdon, pero no tienes fondos suficientes.");
                this.comprar(jugador);
            }//end else
        }//end else
    }//end comprar()

    public void vender(Jugador jugador){
        Scanner in = new Scanner(System.in);

        System.out.print(jugador.dineroIMochila());
        System.out.println(">Salida\n");
        System.out.print(">>> ");

        String input = in.nextLine();

        if (input.equals("Salida"));//end if
        else if (!jugador.comprobarMochila(input)){
            System.out.println("\nPerdon, pero no tienes esta cosa en tu mochila.");
            this.vender(jugador);
        }//end else if
        else{
            jugador.masDinero(jugador.valorEnMochila(input));
            existencia.add(jugador.quitarDeMochila(input));
            this.vender(jugador);
        }//end else
    }//end vender()

    public void bienvenido(Jugador jugador){
        Scanner in = new Scanner(System.in);

        System.out.println("Este es una tienda.\n");
        System.out.println("Acciones:\n\n>Comprar\n>Vender\n>Salida\n");
        System.out.print(">>> ");

        String input = in.nextLine();

        if (input.equals("Comprar")){
            this.comprar(jugador);
            this.bienvenido(jugador);
        }//end if
        else if (input.equals("Vender")){
            this.vender(jugador);
            this.bienvenido(jugador);
        }//end else if
        else if (input.equals("Salida"));//end else if
        else{
            System.out.println("Perdon, pero tu respuesta no emparejo con las opciones");
            this.bienvenido(jugador);
        }//end else
    }//end bienvenido

}//end Tienda
