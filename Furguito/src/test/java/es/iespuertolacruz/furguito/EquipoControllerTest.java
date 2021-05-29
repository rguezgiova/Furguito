package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Equipo;
import es.iespuertolacruz.furguito.controller.EquipoController;
import es.iespuertolacruz.furguito.exception.EquipoException;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class EquipoControllerTest {
    static Equipo equipo;
    static EquipoController equipoController;

    @BeforeAll
    public static void BeforeAll() {
        if (equipoController == null) {
            try {
                equipoController = new EquipoController();
            } catch (PersistenciaException e) {
                fail("No se puede inicializar la BBDD");
            }
        }
    }

    @Test
    public void validarEquipoNuloTest() {
        Equipo equipoNulo = null;
        try {
            equipoController.validar(equipoNulo);
        } catch (EquipoException e) {
            assertTrue(e.getMessage().contains("Se esta intentando validar un objeto nulo"));
        }
    }

    @Test
    public void validarPersonaVaciaTest() {
        Equipo equipoVacio = new Equipo(0, "", "", "", 0, 0, 0, "");
        try {
            equipoController.validar(equipoVacio);
        } catch (EquipoException e) {
            assertTrue(e.getMessage().contains("El nombre del equipo"));
        }
    }

    @Test
    public void insertarEquipoTest() {
        Equipo equipoInsertar = new Equipo(22, "Tenerife", "Tenerife", "Rguez Lopez", 1912, 5124, 111111111, "Blanco y azul");
        try {
            equipoController.insertarEquipo(equipoInsertar);
        } catch (Exception e) {
            fail("No se ha podido insertar al equipo");
        }
    }

    @Test
    public void eliminarEquipoTest() {
        try {
            equipoController.eliminarEquipo(22);
        } catch (PersistenciaException e) {
            fail("No se ha podido eliminar el equipo");
        }
    }

    @Test
    public void modificarEquipoTest() {
        Equipo equipoModificar = new Equipo(20, "nombre", "ciudad", "estadio", 0, 0, 0, "colores");
        try {
            equipoController.modificarEquipo(equipoModificar);
        } catch (PersistenciaException exception) {
            fail("Fallo al modificar el equipo");
        }
    }

    @Test
    public void consultarInformacionTest() {
        String equipo = "Barcelona";
        Equipo equipoEncontrado = null;
        try {
            equipoEncontrado = equipoController.consultarInformacion(equipo);
        } catch (PersistenciaException e) {
            fail("No se ha encontrado el equipo");
        }
        assertTrue(equipoEncontrado.getNombre().contains(equipo));
    }

    @Test
    public void consultarCiudadTest() {
        String equipo = "Bilbao";
        Equipo equipoEncontrado = null;
        try {
            equipoEncontrado = equipoController.consultarCiudad(equipo);
        } catch (PersistenciaException e) {
            fail("No se ha encontrado el equipo");
        }
        System.out.println(equipoEncontrado.toString());
        assertNotNull(equipoEncontrado);

    }

    @Test
    public void consultarPresupuestoTest() {
        String equipo = "Bilbao";
        Equipo equipoEncontrado = null;
        try {
            equipoEncontrado = equipoController.consultarCiudad(equipo);
        } catch (PersistenciaException e) {
            fail("No se ha encontrado el equipo");
        }
        assertNotNull(equipoEncontrado);
    }
}