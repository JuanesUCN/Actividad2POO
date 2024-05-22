import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ArrayList<Jugador> Jugadores = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int IdJugadorBuscar = 0, indexJugadorBuscar = 0;

    public static void main(String[] args)
    {
        //Se crea el lector
        int Opcion = 0;

        while (Opcion != 6) {

            Opcion = MenuOpciones();
            EjecutarAccion(Opcion);
        }

    }

    public static int MenuOpciones()
    {
        int OpcionMenu = 0;
        System.out.println("Menu de inicio");
        System.out.println(" ");
        System.out.println("Elige una opcion a realizar");
        System.out.println("1. Agregar Jugador");
        System.out.println("2. Eliminar Jugador");
        System.out.println("3. Buscar Jugador");
        System.out.println("4. Editar Jugador");
        System.out.println("5. Listar todos los jugadores");
        System.out.println("6. Salir");

        OpcionMenu = Integer.parseInt(sc.nextLine());

        if ((OpcionMenu < 1) || (OpcionMenu > 6))
        {
            System.out.println("");
            System.out.println("Seleccione una opcion valida.");
            OpcionMenu = 0;
        }
        return OpcionMenu;
    }

    public static void EjecutarAccion(int Opcion)
    {
        switch (Opcion)
        {
            case 1:
                System.out.println("***     AGREGAR JUGADOR    ***");
                AgregarNuevoJugador();
                break;

            case 2:
                System.out.println("***     ELIMINAR JUGADOR    ***");
                if (!BuscarJugador(true))
                {
                    System.out.println("***    El jugador con id " + IdJugadorBuscar + ", NO Existe.    ***");
                }
                else
                {
                    EliminarJugador();
                    ImprimirJugadores();
                }
                break;

            case 3:
                System.out.println("***     BUSCAR JUGADOR    ***");
                if (!BuscarJugador(true))
                {
                    System.out.println("***    El jugador con id " + IdJugadorBuscar + ", NO Existe.    ***");
                }
                break;

            case 4:
                System.out.println("***     EDITAR JUGADOR    ***");
                if (!BuscarJugador(true))
                {
                    System.out.println("***    El jugador con id " + IdJugadorBuscar + ", NO Existe.    ***");
                }
                else
                {
                    EditarJugador();
                    ImprimirJugadores();
                }
                break;
            case 5:
                ImprimirJugadores();
                break;
        }
    }

    public static void EditarJugador()
    {
        int OpcionEditar = 0, Edad;
        String Nombre, Apellido, Nacionalidad;

        System.out.println("");
        System.out.println("Que dato desea editar del Jugador: ");
        System.out.println("1. Nombre ");
        System.out.println("2. Apellido ");
        System.out.println("3. Nacionalidad ");
        System.out.println("4. Edad");
        OpcionEditar = Integer.parseInt(sc.nextLine());



        switch (OpcionEditar)
        {
            case 1:
                System.out.println("Digite el nuevo nombre: ");
                Nombre = sc.nextLine();
                Jugadores.get(indexJugadorBuscar).SetNombreJugador(Nombre);
                break;
            case 2:
                System.out.println("Digite el nuevo apellido: ");
                Apellido = sc.nextLine();
                Jugadores.get(indexJugadorBuscar).SetApellidoJugador(Apellido);
                break;
            case 3:
                System.out.println("Digite la nueva nacionalidad: ");
                Nacionalidad = sc.nextLine();
                Jugadores.get(indexJugadorBuscar).SetNacionalidadJugador(Nacionalidad);
                break;
            case 4:
                System.out.println("Digite la nueva edad: ");
                Edad = Integer.parseInt(sc.nextLine());
                Jugadores.get(indexJugadorBuscar).SetEdadJugador(Edad);
                break;
            default:
        }

    }

    public static void EliminarJugador()
    {
        String Confirmacion = "";
        int IdJugadorEliminar;
            System.out.println("Seguro que desea eliminar el Jugador con id " + IdJugadorBuscar +
                    " SI o NO");


            Confirmacion =  sc.nextLine();

            System.out.println(Confirmacion);
            // validamos confirmacion para eliminacion

            if (Confirmacion.equals("SI"))
            {
                for (int i = 0; i < Jugadores.size(); i++)
                {
                    IdJugadorEliminar = Jugadores.get(i).GetIdJugador();

                    if (IdJugadorBuscar == IdJugadorEliminar)
                    {
                        Jugadores.remove(i);
                    }
                }
            }

    }

    public static void AgregarNuevoJugador()
    {
        String Nombre, Apellido, Nacionalidad;
        int Edad, IdJugadorNew = 0, IndiceMax;

        System.out.println("");
        System.out.println("Nombre del Jugador: ");
        Nombre = sc.nextLine();
        System.out.println("Apellido del Jugador: ");
        Apellido = sc.nextLine();
        System.out.println("Nacionalidad del Jugador: ");
        Nacionalidad =  sc.nextLine();
        System.out.println("Edad del Jugador: ");
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
        Aux.SetNacionalidadJugador(Nacionalidad);
        Aux.SetEdadJugador(Edad);

        Jugadores.add(Aux);
        System.out.println("Nuevo Jugador Guardado Exitosamente Id: " + IdJugadorNew);
        System.out.println("");
        ImprimirJugadores();
    }

    public static void ImprimirJugadores()
    {
        System.out.println("***     Lista de Jugadores    ***")   ;
        System.out.println("Id Jugador      Nombre      Apellido        Nacionalidad        Edad  ");
        for (int i = 0; i < Jugadores.size(); i++)
        {
            System.out.println(Jugadores.get(i).GetIdJugador() + "      "
                            + Jugadores.get(i).GetNombreJugador() + "      "
                            + Jugadores.get(i).GetApellidoJugador() + "     "
                            + Jugadores.get(i).GetNacionalidadJugador() + "     "
                            + Jugadores.get(i).GetEdadJugador());;
        }
        System.out.println("");
    }

    public static Boolean BuscarJugador(boolean MostraJugador)
    {
        int IdJugadorAux = 0;

        System.out.println("");
        System.out.println("Digite el Id del Jugador: ");
        IdJugadorBuscar = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < Jugadores.size(); i++)
        {
            IdJugadorAux = Jugadores.get(i).GetIdJugador();

            if (IdJugadorAux == IdJugadorBuscar)
            {
                indexJugadorBuscar = i;

                System.out.println("***    El jugador con id " + IdJugadorBuscar + ", SI Existe.    ***");
                System.out.println("");
                System.out.println("Nombre: " + Jugadores.get(i).GetNombreJugador());
                System.out.println("Apellido: " + Jugadores.get(i).GetApellidoJugador());
                System.out.println("Nacionalidad: " + Jugadores.get(i).GetNacionalidadJugador());
                System.out.println("Edad: " + Jugadores.get(i).GetEdadJugador());
                return true;
            }
        }
        return false;
    }


}