package es.iespuertolacruz.furguito.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Estadio;
import es.iespuertolacruz.furguito.exception.EstadioException;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class EstadioControllerTest {
    static Estadio equipo;
    static EstadioController estadioController;

    @BeforeAll
    public static void BeforeAll() {
        if (estadioController == null) {
            try {
                estadioController = new EstadioController();
            } catch (PersistenciaException e) {
                fail("No se puede inicializar la BBDD");
            }
        }
    }

    @Test
    public void validarEquipoNuloTest() {
        Estadio estadioNulo = null;
        try {
            estadioController.validar(estadioNulo);
        } catch (EstadioException e) {
            assertTrue(e.getMessage().contains("Se esta intentando validar un objeto nulo"));
        }
    }

    @Test
    public void validarEstadioVacioTest() {
        Estadio estadioVacio = new Estadio(0, "", "", 0, 0);
        try {
            estadioController.validar(estadioVacio);
        } catch (EstadioException e) {
            assertTrue(e.getMessage().contains("El nombre del equipo"));
        }
    }

    @Test
    public void insertarEstadioTest() {
        Estadio estadioInsertar = new Estadio(22, "Rguez Lopez", "Tenerife", 22824, 1925);
        try {
            estadioController.insertarEstadio(estadioInsertar);
        } catch (Exception e) {
            fail("No se ha podido insertar el estadio");
        }
    }

    @Test
    public void eliminarEstadioTest() {
        try {
            estadioController.eliminarEstadio(22);
        } catch (PersistenciaException e) {
            fail("Error al eliminar el equipo");
        }
    }

    @Test
    public void modificarEstadioTest() {
        Estadio estadioModificar = new Estadio(20, "nombre", "equipo", 1, 1);
        try {
            try {
                estadioController.modificarEstadio(estadioModificar);
            } catch (EstadioException exception) {
                fail("Error en la validacion del estadio", exception);
            }
        } catch (PersistenciaException e) {
            fail("No se ha podido modificar el estadio");
        }
    }

    @Test
    public void obtenerEstadioTest() {
        String nombre = "Ipurua";
        Estadio estadioEncontrado = null;
        try {
            estadioEncontrado = estadioController.consultarInformacion(nombre);
        } catch (PersistenciaException exception) {
            fail("No se ha podido obtener el estadio", exception);
        }
        assertTrue(estadioEncontrado.getNombre().contains(nombre));
    }

    @Test
    public void obtenerCapacidadTest() {
        String nombre = "Balaidos";
        Estadio estadioEncontrado = null;
        try {
            estadioEncontrado = estadioController.consultarCapacidad(nombre);
        } catch (PersistenciaException exception) {
            fail("No se ha podido obtener el estadio", exception);
        }
        assertNotNull(estadioEncontrado);
    }

    @Test
    public void obtenerAnioTest() {
        String nombre = "Balaidos";
        Estadio estadioEncontrado = null;
        try {
            estadioEncontrado = estadioController.consultarAnioConstruccion(nombre);
        } catch (PersistenciaException exception) {
            fail("No se ha podido obtener el estadio", exception);
        }
        assertNotNull(estadioEncontrado);
    }
}