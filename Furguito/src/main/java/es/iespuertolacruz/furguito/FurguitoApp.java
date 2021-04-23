package es.iespuertolacruz.furguito;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FurguitoApp {
    private static final String INTRODUCIR_NUMERO = "Debe introducir un numero";
    private static final String SEPARADOR = "#########################################\n";
    private static final String ESCRIBE_OPCIONES = "Escribe una de las opciones";

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        int opcion;
        boolean salir = false;

        while (!salir) {
            System.out.println("----MENU PRINCIPAL----");
            System.out.println("1- Acceder como usuario");
            System.out.println("2- Acceder como administrador");
            System.out.println("3. Salir");

            try {

                System.out.println(ESCRIBE_OPCIONES);
                opcion = sn.nextInt();

                switch (opcion) {
                case 1:
                    System.out.println(SEPARADOR);
                    System.out.println("--MENU DE USUARIO--\n");
                    menuUsuario();
                    break;

                case 2:
                    System.out.println(SEPARADOR);
                    System.out.println("--MENU DE ADMINISTRADOR--\n");
                    menuAdmin();
                    break;

                case 3:

                    System.out.println(SEPARADOR);
                    System.out.println("--GRACIAS POR USAR FURGUITO--\n");
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

    /**
     * Menu para el Usuario
     */

    public static void menuUsuario() {
        Scanner sn = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        while (!salir) {

            System.out.println("1- Consultar información completa del equipo");
            System.out.println("2- Consultar presupuesto total del equipo");
            System.out.println("3- Consultar la ciudad en la que juega el equipo");
            System.out.println("4- Consultar información del estadio");
            System.out.println("5- Consultar la capacidad total del estadio");
            System.out.println("6- Consultar la fecha de construccion del estadio");
            System.out.println("7- Consultar información completa del jugador");
            System.out.println("8- Consultar maximo goleador");
            System.out.println("9- Consultar jugador con mas tarjetas rojas");
            System.out.println("10- Consultar palmares completo del equipo");
            System.out.println("11- Consultar ligas ganadas");
            System.out.println("12- Consultar copas del rey ganadas");
            System.out.println("13- Volver al menu inicial");

            try {

                System.out.println(ESCRIBE_OPCIONES);
                opcion = sn.nextInt();

                switch (opcion) {
                case 1:

                    System.out.println("Consultar información completa del equipo");

                    break;

                case 2:

                    System.out.println("Consultar presupuesto total del equipo");

                    break;

                case 3:

                    System.out.println("Consultar ciudad en la que juega el equipo");

                    break;

                case 4:

                    System.out.println("Consultar información del estadio");

                    break;

                case 5:

                    System.out.println("Consultar la capacidad total del estadio");

                    break;

                case 6:

                    System.out.println("Consultar la fecha de construccion del estadio");

                    break;

                case 7:

                    System.out.println("Consultar información completa del jugador");

                    break;

                case 8:

                    System.out.println("Consultar maximo goleador");

                    break;

                case 9:

                    System.out.println("Consultar jugador con mas tarjetas rojas");

                    break;

                case 10:

                    System.out.println("Consultar palmares completo del equipo");

                    break;

                case 11:

                    System.out.println("Consultar ligas ganadas");

                    break;

                case 12:

                    System.out.println("Consultar copas del rey ganadas");

                    break;

                case 13:

                    System.out.println("Volviendo al menu principal");
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

    /**
     * Menu para el Usuario
     */

    public static void menuAdmin() {
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
            System.out.println("13- Volver al menu inicial");

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

                    System.out.println("Volviendo al menu principal");
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
