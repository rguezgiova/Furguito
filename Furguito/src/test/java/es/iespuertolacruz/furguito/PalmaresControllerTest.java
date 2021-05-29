package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Palmares;
import es.iespuertolacruz.furguito.controller.PalmaresController;
import es.iespuertolacruz.furguito.exception.PalmaresException;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class PalmaresControllerTest {

    static Palmares palmares;
    static PalmaresController palmaresController;

    @BeforeAll
    public static void BeforeAll() {
        if (palmaresController == null) {
            try {
                palmaresController = new PalmaresController();
            } catch (PersistenciaException exception) {
                fail("No se puede inicializar la BBDD", exception);
            }
        }
    }

    @Test
    public void validarPalmaresNulo() {
        Palmares palmaresNulo = null;
        try {
            palmaresController.validar(palmaresNulo);
        } catch (PalmaresException exception) {
            assertTrue(exception.getMessage().contains("Se esta intentando validar un objeto nulo"));
        }
    }

    @Test
    public void validarPalmaresVacioTest() {
        Palmares palmaresVacio = new Palmares(0, "", 0, 0, 0, 0, 0, 0);
        try {
            palmaresController.validar(palmaresVacio);
        } catch (PalmaresException exception) {
            assertTrue(exception.getMessage().contains("El nombre del equipo"));
        }
    }

    @Test
    public void insertarPalmaresTest() {
        Palmares palmaresInsertar = new Palmares(32, "Huesca", 0, 0, 0, 0, 0, 0);
        try {
            palmaresController.insertarPalmares(palmaresInsertar);
        } catch (Exception exception) {
            fail("No se ha podido insertar el palmares", exception);
        }
    }

    @Test
    public void eliminarPalmaresTest() {
        try {
            palmaresController.eliminarPalmares(32);
        } catch (PersistenciaException exception) {
            fail("Error al eliminar el palmares", exception);
        }
    }

    @Test
    public void modificarPalmaresTest() {
        Palmares palmaresModificar = new Palmares(10, "Girona", 0, 0, 0, 0, 0, 0);
        try {
            try {
                palmaresController.modificarPalmares(palmaresModificar);
            } catch (PalmaresException exception) {
                fail("Error en la validacion del palmares", exception);
            }
        } catch (PersistenciaException e) {
            fail("No se ha podido modificar el palmares");
        }
    }

    @Test
    public void palmaresLigasTest() {
        ArrayList<Palmares> listaLigas = new ArrayList<Palmares>();
        try {
            listaLigas = palmaresController.consultarLigas();
        } catch (PersistenciaException exception) {
            fail("No se ha podido obtener la lista", exception);
        }
    }

    @Test
    public void palmaresCopasTest() {
        ArrayList<Palmares> listaCopas = new ArrayList<Palmares>();
        try {
            listaCopas = palmaresController.consultarCopas();
        } catch (PersistenciaException exception) {
            fail("No se ha podido obtener la lista", exception);
        }
    }

    /**
     * 
     * @Test
    public void consultarPalmaresTest() {
        String nombre = "Barcelona";
        ArrayList<Palmares> listaPalmares = null;
        try {
            listaPalmares = palmaresController.consultarPalmares(nombre);
        } catch (PersistenciaException exception) {
            fail("No se ha podido obtener la lista", exception);
        }
        System.out.println(listaPalmares.toString());
        assertNotNull(listaPalmares.get(0));
    }
     */
    


}
