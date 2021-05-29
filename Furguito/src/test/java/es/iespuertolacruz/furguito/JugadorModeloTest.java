package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Jugador;
import es.iespuertolacruz.furguito.exception.PersistenciaException;
import es.iespuertolacruz.furguito.modelo.Bbdd;
import es.iespuertolacruz.furguito.modelo.JugadorModelo;

public class JugadorModeloTest {
    static Jugador jugador;
    static JugadorModelo jugadorModelo;
    Bbdd bbdd;

    @BeforeAll
    public static void beforeAll() {
        if (jugadorModelo == null) {
            try {
                jugadorModelo = new JugadorModelo();
            } catch (PersistenciaException e) {
                fail("Se ha producido un error en la inicializacion de la BBDD");
            }
        }
    }

    @Test
    public void insertarJugadorTest() {
        Jugador jugadorInsertar = new Jugador(321, "equipo", "nombre", 1, 1, 1, 1, 1);
        try {
            jugadorModelo.insertar(jugadorInsertar);
        } catch (PersistenciaException exception) {
            fail("No se ha podido insertar al jugador", exception);
        }
    }

    @Test
    public void modificarJugadorTest() {
        Jugador jugadorModificar = new Jugador(23, "Paco", "Perez", 1, 1, 1, 1, 1);
        try {
            jugadorModelo.modificar(jugadorModificar);
        } catch (PersistenciaException exception) {
            fail("No se ha podido modificar al jugador", exception);
        }
    }

    @Test
    public void eliminarJugadorTest() {
        try {
            jugadorModelo.eliminar(321);
        } catch (PersistenciaException exception) {
            fail("No se ha podido eliminar al jugador", exception);
        }
    }

    @Test
    public void obtenerJugadorTest() {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        String nombre = "Messi";
        try {
            listaJugadores = jugadorModelo.obtenerJugador(nombre);
        } catch (PersistenciaException e) {
            fail("No se ha podido obtener a los jugadores");
        }
        assertNotNull(listaJugadores);
    }

    @Test
    public void obtenerGoleadoresTest() {
        try {
            jugadorModelo.obtenerGoleadores();
        } catch (PersistenciaException e) {
            fail("No se ha podido obtener a los jugadores");
        }
    }

    @Test
    public void obtenerExpulsadosTest() {
        try {
            jugadorModelo.obtenerExpulsados();
        } catch (PersistenciaException e) {
            fail("No se ha podido obtener a los jugadores");
        }
    }
}