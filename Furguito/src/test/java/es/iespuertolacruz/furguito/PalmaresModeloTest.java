package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.*;
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
            } catch (PersistenciaException exception) {
                fail("Se ha producido un error en la inicializacion de la BBDD", exception);
            }
        }
    }

    /**
     * @Test
    public void palmaresNombreTest(){
        ArrayList<Palmares> listaPalmares = new ArrayList<>();
        try {
            listaPalmares = palmaresModelo.palmaresEquipo("Futbol Club Barcelona");
        } catch (PersistenciaException exception) {
            fail("No se ha podido obtener el palmares del equipo", exception);
        }
        assertTrue(listaPalmares.get(1).getEquipo().contains("Futbol Club Barcelona"));
    }
     */
    

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