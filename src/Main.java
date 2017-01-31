import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Alex on 12/28/15.
 */
public class Main {


    public static void main(String[] args) throws FileNotFoundException{
        titulo();
        System.out.println("Gracias para jugar!!");
    }//end main()

    public static void titulo() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.println("**************************************");
        System.out.println("*                                    *");
        System.out.println("*       El Sendero de Libertad       *");
        System.out.println("*                                    *");
        System.out.println("**************************************\n");
        System.out.println("\t\t\t>Nuevo Juego<");
        System.out.println("\t\t\t>Carga Juego<");
        System.out.println("\t\t\t>Salida     <");
        System.out.print("\n>>> ");


        String entrada = input.nextLine();

        System.out.println();

        if (entrada.equals("Nuevo Juego")){
            nuevoJuego();
        }//end if
        else if (entrada.equals("Carga Juego")){
            File carga = new File("carga.txt");
            Scanner fileReader = new Scanner(carga);
            Jugador jugador = new Jugador();

            while (fileReader.hasNext()){
                fileReader.next();
                jugador.setNombre(fileReader.next());
                fileReader.next();
                jugador.setSed(fileReader.nextInt());
                fileReader.next();
                jugador.setHambre(fileReader.nextInt());
                fileReader.next();
                jugador.setDinero(fileReader.nextDouble());
                fileReader.next();
                jugador.setSueno(fileReader.nextInt());
                fileReader.next();
                jugador.setSalud(fileReader.nextInt());
                fileReader.next();
                jugador.setTrampas(fileReader.nextBoolean());
                fileReader.next();
                jugador.setMalaria(fileReader.nextBoolean());
                fileReader.next();
                jugador.setDisenteria(fileReader.nextBoolean());
                fileReader.next();
                jugador.setFiebreDengue(fileReader.nextBoolean());
                fileReader.next();
                jugador.setFiebreTifoidea(fileReader.nextBoolean());
                fileReader.next();
                while (fileReader.hasNext()){
                    Objeto objeto = new Objeto(fileReader.next(), fileReader.nextDouble());
                    jugador.anadirAMochila(objeto);
                }//end while
            }//end while
            juego(jugador);
        }//end else if
        else if (entrada.equals("Salida"));//end else if
        else if (entrada.equals("Nuevo Jugo")){
            System.out.println("Chistes!!!!! ;P\n\n\n");
            nuevoJugo();
        }//end else if
        else if (entrada.equals("Los Muertos Vivos")){
            System.out.println("Perdon, pero ahora no tenemos esta opcion. Solemente puedes crear un nuevo juego.\n\n\n");
            titulo();
        }//end else if
        else{
            System.out.println("Perdon, pero necesitas elegir unos de los entradas arriba\n\n\n");
            titulo();
        }//end else
    }//end titulo

    public static void nuevoJuego() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.println("Que es el nombre de tu jugador?\n");
        System.out.print(">>> ");
        String nombre = input.nextLine();

        Jugador jugador = new Jugador(nombre);

        System.out.println("\nTu nombre es " + jugador.getNombre() + ". Tienes doce anos. Necesitas salir tu familia, casa, y vida " +
                "en Nicaragua y llegar a Los Estados Unidos.\n");

        juego(jugador);
    }//end nuevoJuego()

    public static void nuevoJugo() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.println("Que es el nombre de tu jugador?\n");
        System.out.print(">>> ");
        String nombre = input.nextLine();

        System.out.println("\n\nCuanto salud tu jugador tiene?\n");
        System.out.print(">>> ");
        int salud = input.nextInt();
        input.nextLine();

        System.out.println("\n\nCuanto sed tu jugador tiene?\n");
        System.out.print(">>> ");
        int sed = input.nextInt();
        input.nextLine();

        System.out.println("\n\nCuanto hambre tu jugador tiene?\n");
        System.out.print(">>> ");
        int hambre = input.nextInt();
        input.nextLine();

        System.out.println("\n\nCuanto dinero tu jugador tiene?\n");
        System.out.print(">>> ");
        int dinero = input.nextInt();
        input.nextLine();

        System.out.println("\n\nCuanto sueno tu jugador tiene?\n");
        System.out.print(">>> ");
        int sueno = input.nextInt();
        input.nextLine();

        Jugador jugador = new Jugador(salud, sed, hambre, nombre, dinero, sueno, true);

        System.out.println("\nTu nombre es " + jugador.getNombre() + ". Tienes doce anos. Necesitas salir tu familia, casa, y vida " +
                "en Nicaragua y llegar a Los Estados Unidos.\n");

        juego(jugador);


    }//end nuevoJugo()

    public static void juego(Jugador jugador) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);



        Tienda tienda = new Tienda();

        tienda.anadirAExistencia(new Bebida("Botella de Agua", 1.5));
        tienda.anadirAExistencia(new Comida("Hamburguesa", 3));


        System.out.print("Estas en tu puebla. Hay una tienda.\nAcciones:\n\n" +
                ">Tienda\n>Vitales\n>Mochila\n>Dejar\n\n>>> ");
        String input = in.nextLine();

        if (input.equals("Tienda")) {
            tienda.bienvenido(jugador);
            juego(jugador);
        }//end if
        else if (input.equals("Vitales")){
            System.out.println(jugador.vitales());
            juego(jugador);
        }//end else if
        else if (input.equals("Mochila")){
            jugador.usaMochila(jugador);
            juego(jugador);
        }//end else if
        else if (input.equals("Dejar")){
            carga(jugador);
        }//end else if
        else{
            System.out.println("\nPerdon, but your response didn't match any of the options.");
            juego(jugador);
        }//end else
    }//end juego()

    public static void carga(Jugador jugador) throws FileNotFoundException{
        PrintWriter cargador = new PrintWriter("carga.txt");
        cargador.println("Nombre:\t\t\t" + jugador.getNombre());
        cargador.println("Sed:\t\t\t" + jugador.getSed());
        cargador.println("Hambre:\t\t\t" + jugador.getHambre());
        cargador.println("Dinero:\t\t\t" + jugador.getDinero());
        cargador.println("Sueno:\t\t\t" + jugador.getSueno());
        cargador.println("Salud:\t\t\t" + jugador.getSalud());
        cargador.println("Trampas:\t\t" + jugador.isTrampas());
        cargador.println("Malaria:\t\t" + jugador.isMalaria());
        cargador.println("Disenteria:\t\t" + jugador.isDisenteria());
        cargador.println("FiebreDengue:\t\t" + jugador.isFiebreDengue());
        cargador.println("FiebreTifoidea:\t\t" + jugador.isFiebreTifoidea());
        cargador.print("Mochila:");
        for (int i = 0; i < jugador.mochilaLength(); i++) {
            if (i == 0)
                cargador.println("\t\t" + jugador.nameInMochila(i) + " " + jugador.valorInMochila(i));
            else
                cargador.println("\t\t\t" + jugador.nameInMochila(i) + " " + jugador.valorInMochila(i));
        }//end for i

        cargador.close();
    }//end carga()
}//end Main
