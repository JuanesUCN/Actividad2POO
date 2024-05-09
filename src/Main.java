import javax.swing.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); //Se crea el lector
        int Opcion = 0;

        while (Opcion == 0) {

            System.out.flush();

            System.out.println("Menu de inicio");
            System.out.println(" ");
            System.out.println("Elige una opcion a realizar");
            System.out.println("1. Agregar Jugador");
            System.out.println("2. Buscar Jugador");
            System.out.println("3. Editar Jugador");
            System.out.println("4. Eliminar Jugador");

            Opcion = Integer.parseInt(sc.nextLine());

            if ((Opcion < 1) || (Opcion > 4)) {
                System.out.println("");
                System.out.println("Seleccione una opcion valida.");
                Opcion = 0;
            }
        }
        EjecutarAccion(Opcion);
    }

    public static void EjecutarAccion(int Opcion)
    {
        switch (Opcion)
        {
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;
        }
    }
}