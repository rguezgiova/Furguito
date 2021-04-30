package es.iespuertolacruz.furguito.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FurguitoAdminApp {
    private static final String INTRODUCIR_NUMERO = "Debe introducir un numero";
    private static final String SEPARADOR = "#########################################\n";
    private static final String ESCRIBE_OPCIONES = "Escribe una de las opciones";

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        while (!salir) {

            System.out.println("1- Insertar club");
            System.out.println("2- Modificar club");
            System.out.println("3- Borrar club");
            System.out.println("4- Insertar estadio");
            System.out.println("5- Modificar estadio");
            System.out.println("6- Borrar estadio");
            System.out.println("7- Insertar jugador");
            System.out.println("8- Modificar jugador");
            System.out.println("9- Borrar jugador");
            System.out.println("10- Insertar palmares");
            System.out.println("11- Modificar palmares");
            System.out.println("12- Borrar palmares");
            System.out.println("13- Salir");

            try {

                System.out.println(ESCRIBE_OPCIONES);
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:

                        System.out.println("Insertar club");

                        break;

                    case 2:

                        System.out.println("Modificar club");

                        break;

                    case 3:

                        System.out.println("Borrar club");

                        break;

                    case 4:

                        System.out.println("Insertar estadio");

                        break;

                    case 5:

                        System.out.println("Modificar estadio");

                        break;

                    case 6:

                        System.out.println("Borrar estadio");

                        break;

                    case 7:

                        System.out.println("Insertar jugador");

                        break;

                    case 8:

                        System.out.println("Modificar jugador");

                        break;

                    case 9:

                        System.out.println("Borrar jugador");

                        break;

                    case 10:

                        System.out.println("Insertar jugador");

                        break;

                    case 11:

                        System.out.println("Modificar jugador");

                        break;

                    case 12:

                        System.out.println("Borrar jugador");

                        break;

                    case 13:

                        System.out.println("Gracias por usar Furguito");
                        System.out.println(SEPARADOR);
                        salir = true;
                        break;

                    default:
                        System.out.println(INTRODUCIR_NUMERO);

                }

            } catch (InputMismatchException e) {
                System.out.println(INTRODUCIR_NUMERO);
                sn.next();

            }
        }
    }
}
