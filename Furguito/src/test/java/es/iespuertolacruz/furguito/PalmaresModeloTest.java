package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Palmares;
import es.iespuertolacruz.furguito.exception.PersistenciaException;
import es.iespuertolacruz.furguito.modelo.PalmaresModelo;

public class PalmaresModeloTest {
    static Palmares palmares;
    static PalmaresModelo palmaresModelo;

    @BeforeAll
    public static void beforeAll() {
        if (palmaresModelo == null) {
            try {
                palmaresModelo = new PalmaresModelo();
            } catch (PersistenciaException e) {
                fail("Se ha producido un error en la inicializacion de la BBDD");
            }
        }
    }

    @Test
    public void buscarPalmaresTest() {
        try {
            ArrayList<Palmares> palmaresEncontrado = palmaresModelo.PalmaresEquipo("Futbol Club Barcelona");
            assertNotNull(palmaresEncontrado, "No se debe de obtener un elemento nulo");
            assertEquals(palmaresEncontrado.getEquipo(), "Futbol Club Barcelona", "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
            fail("Se ha producido un error en la consulta del palmares: " + e.getMessage());

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