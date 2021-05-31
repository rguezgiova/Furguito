package es.iespuertolacruz.furguito.modelo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Palmares;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class PalmaresModeloTest {
    static Palmares palmares;
    static PalmaresModelo palmaresModelo;

    @BeforeAll
    public static void beforeAll() {
        if (palmaresModelo == null) {
            try {
                palmaresModelo = new PalmaresModelo();
            } catch (PersistenciaException exception) {
                fail("Se ha producido un error en la inicializacion de la BBDD", exception);
            }
        }
    }

    @Test
    public void palmaresNombreTest() {
        ArrayList<Palmares> listaPalmares = new ArrayList<>();
        String nombre = "Sociedad";
        try {
            listaPalmares = palmaresModelo.palmaresEquipo(nombre);
        } catch (PersistenciaException e) {
            fail("No se ha podido obtener el palmares");
        }
        assertNotNull(listaPalmares);
    }

    @Test
    public void obtenerPalmaresErrorTest() {
        try {
            palmaresModelo.obtenerPalmares("SELECT nada from nada");
        } catch (PersistenciaException exception) {
            assertNotNull(exception);
        }
    }

    @Test
    public void insertarPalmaresTest() {
        Palmares palmaresInsertar = new Palmares(22, "equipo", 1, 1, 1, 1, 1, 1);
        try {
            palmaresModelo.insertar(palmaresInsertar);
        } catch (PersistenciaException e) {
            fail("No se ha podido insertar el palmares");
        }
    }

    @Test
    public void eliminarPalmaresTest() {
        try {
            palmaresModelo.eliminar(22);
        } catch (PersistenciaException e) {
            fail("Se ha producido un error al eliminar");
        }
    }
}