package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Jugador;
import es.iespuertolacruz.furguito.controller.JugadorController;
import es.iespuertolacruz.furguito.exception.JugadorException;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class JugadorControllerTest {

    static Jugador jugador;
    static JugadorController jugadorController;

    @BeforeAll
    public static void BeforeAll() {
        if (jugadorController == null) {
            try {
                jugadorController = new JugadorController();
            } catch (PersistenciaException exception) {
                fail("No se puede inicializar la BBDD", exception);
            }
        }
    }

    @Test
    public void validarJugadorNuloTest() {
        Jugador jugadorNulo = null;
        try {
            jugadorController.validar(jugadorNulo);
        } catch (JugadorException exception) {
            assertTrue(exception.getMessage().contains("Se esta intentando validar un objeto nulo"));
        }
    }

    @Test
    public void validarJugadorTest() {
        Jugador jugadorVacio = new Jugador(0, "", "", 0, 0, 0, 0, 0);
        try {
            jugadorController.validar(jugadorVacio);
        } catch (JugadorException exception) {
            assertTrue(exception.getMessage().contains("El nombre del jugador"));
        }
    }

    @Test
    public void insertarJugadorTest() {
        Jugador jugadorInsertar = new Jugador(234, "Villarreal", "Paco", 13, 5, 8, 1, 1);
        try {
            jugadorController.insertarJugador(jugadorInsertar);
        } catch (Exception exception) {
            fail("No se ha podido insertar el jugador", exception);
        }
    }

    @Test
    public void eliminarPalmaresTest() {
        try {
            jugadorController.eliminarJugador(234);
        } catch (PersistenciaException exception) {
            fail("Error al eliminar el jugador", exception);
        }
    }

    @Test
    public void modificarJugadorTest() {
        Jugador jugadorModificar = new Jugador(22, "Osasuna", "Pedro", 7, 12, 1, 2, 3);
        try {
            try {
                jugadorController.modificarJugador(jugadorModificar);
            } catch (JugadorException exception) {
                fail("Error en la validacion del palmares", exception);
            }
        } catch (PersistenciaException e) {
            fail("No se ha podido modificar el palmares");
        }
    }

    @Test
    public void obtenerGoleadoresTest() {
        ArrayList<Jugador> listaGoleadores = new ArrayList<Jugador>();
        try {
            listaGoleadores = jugadorController.consultarMaximosGoleadores();
        } catch (PersistenciaException exception) {
            fail("No se ha podido obtener la lista", exception);
        }
    }

    @Test
    public void obtenerExpulsadosTest() {
        ArrayList<Jugador> listaExpulsados = new ArrayList<Jugador>();
        try {
            listaExpulsados = jugadorController.consultarMasExpulsados();
        } catch (PersistenciaException exception) {
            fail("No se ha podido obtener la lista", exception);
        }
    }

    @Test
    public void consultarInformacionTest() {
        String nombre = "Pedro";
        ArrayList<Jugador> jugadorEncontrado = null;
        try {
            jugadorEncontrado = jugadorController.consultarInformacion(nombre);
        } catch (PersistenciaException e) {
            fail("No se ha encontrado el equipo");
        }
        System.out.println(jugadorEncontrado.toString());
        assertNotNull(jugadorEncontrado.get(0));
    }
    
}
