import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ArrayList<Jugador> Jugadores = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int IdJugadorBuscar = 0;

    public static void main(String[] args)
    {
        //Se crea el lector
        int Opcion = 0;

        while (Opcion != 5) {


            System.out.println("Menu de inicio");
            System.out.println(" ");
            System.out.println("Elige una opcion a realizar");
            System.out.println("1. Agregar Jugador");
            System.out.println("2. Buscar Jugador");
            System.out.println("3. Editar Jugador");
            System.out.println("4. Eliminar Jugador");
            System.out.println("5. Salir");

            Opcion = Integer.parseInt(sc.nextLine());

            if ((Opcion < 1) || (Opcion > 5)) {
                System.out.println("");
                System.out.println("Seleccione una opcion valida.");
                Opcion = 0;
                continue;
            }
            EjecutarAccion(Opcion);
        }

    }

    public static void EjecutarAccion(int Opcion)
    {
        switch (Opcion)
        {
            case 1:
                AgregarNuevoJugador();
                break;

            case 2:
                if (!BuscarJugador())
                {
                    System.out.println("***    El jugador con id " + IdJugadorBuscar + ", NO Existe.    ***");
                }
                break;

            case 3:
                break;

            case 4:
                break;
        }
    }

    public static void AgregarNuevoJugador()
    {
        String Nombre, Apellido;
        int Edad, IdJugadorNew = 0, IndiceMax;

        System.out.println("***     AGREGAR JUGADOR    ***");
        System.out.println("");
        System.out.println("Nombre Jugador: ");
        Nombre = sc.nextLine();
        System.out.println("Apellido Jugador: ");
        Apellido = sc.nextLine();
        System.out.println("Edad Jugador: ");
        Edad =  Integer.parseInt(sc.nextLine());

        if ( Jugadores.size() == 0)
        {
            IdJugadorNew = 1;
        }
        else
        {
            IndiceMax = Jugadores.size();
            IdJugadorNew = Jugadores.get(IndiceMax-1).GetIdJugador() + 1;
        }

        Jugador Aux = new Jugador();
        Aux.SetIdJugador(IdJugadorNew);
        Aux.SetNombreJugador(Nombre);
        Aux.SetApellidoJugador(Apellido);
        Aux.SetEdadJugador(Edad);

        Jugadores.add(Aux);
        System.out.println("Nuevo Jugador Guardado Exitosamente Id: " + IdJugadorNew);
        System.out.println("");
        ImprimirJugadores();
    }

    public static void ImprimirJugadores()
    {
        System.out.println("***     Lista de Jugadores    ***")   ;
        System.out.println("Id Jugador      Nombre      Apellido        Edad  ");
        for (int i = 0; i < Jugadores.size(); i++)
        {
            System.out.println(Jugadores.get(i).GetIdJugador() + "      "
                            + Jugadores.get(i).GetNombreJugador() + "      "
                            + Jugadores.get(i).GetApellidoJugador() + "     "
                            + Jugadores.get(i).GetEdadJugador());;
        }
        System.out.println("");

    }

    public static boolean BuscarJugador()
    {
        int IdJugadorAux = 0;

        System.out.println("***     BUSCAR JUGADOR    ***");
        System.out.println("");
        System.out.println("Digite el Id del Jugador: ");
        IdJugadorBuscar = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < Jugadores.size(); i++)
        {
            IdJugadorAux = Jugadores.get(i).GetIdJugador();

            if (IdJugadorAux == IdJugadorBuscar)
            {
                System.out.println("***    El jugador con id " + IdJugadorBuscar + ", SI Existe.    ***");
                System.out.println("");
                System.out.println("Nombre: " + Jugadores.get(i).GetNombreJugador());
                System.out.println("Apellido: " + Jugadores.get(i).GetApellidoJugador());
                System.out.println("Edad: " + Jugadores.get(i).GetEdadJugador());
                return true;

            }
        }
        return false;
    }


}