package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Equipo;
import es.iespuertolacruz.furguito.exception.PersistenciaException;
import es.iespuertolacruz.furguito.modelo.Bbdd;
import es.iespuertolacruz.furguito.modelo.EquipoModelo;

public class EquipoModeloTest {
    static Equipo equipo;
    static EquipoModelo equipoModelo;
    Bbdd bbdd;

    @BeforeAll
    public static void beforeAll() {
        if (equipoModelo == null) {
            try {
                equipoModelo = new EquipoModelo();
            } catch (PersistenciaException e) {
                fail("Se ha producido un error en la inicializacion de la BBDD");
            }
        }
    }

    @Test
    public void buscarEquipoTest() {
        try {
            Equipo equipoEncontrado = equipoModelo.obtenerEquipo("Barcelona");
            assertNotNull(equipoEncontrado, "No se debe de obtener un elemento nulo");
            assertEquals(equipoEncontrado.getNombre(), "Futbol Club Barcelona", "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
            fail("Se ha producido un error en la consulta del equipo: " + e.getMessage());

        }
    }

    @Test
    public void insertarEquipoTest() {
        Equipo equipoInsertar = new Equipo(22, "Tenerife", "Tenerife", "Rguez Lopez", 1912, 5124, 111111111, "Blanco y azul");
        try {
            equipoModelo.insertar(equipoInsertar);
        } catch (Exception e) {
            fail("No se ha podido insertar al equipo");
        }
    }

    @Test
    public void eliminarEquipoTest() {
        try {
            equipoModelo.eliminar(22);
        } catch (PersistenciaException e) {
            fail("No se ha podido eliminar el equipo");
        }
    }

    @Test
    public void modificarEquipoTest() {
        equipo = new Equipo(20, "nombre", "ciudad", "estadio", 0, 0, 0, "colores");
        try {
            equipoModelo.modificar(equipo);
        } catch (PersistenciaException exception) {
            fail("Fallo al modificar el equipo");
        }
    }

    @Test
    public void consultarInformacionTest() {
        String equipo = "Barcelona";
        Equipo equipoEncontrado = null;
        try {
            equipoEncontrado = equipoModelo.obtenerEquipo(equipo);
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
            equipoEncontrado = equipoModelo.consultarCiudad(equipo);
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
            equipoEncontrado = equipoModelo.consultarCiudad(equipo);
        } catch (PersistenciaException e) {
            fail("No se ha encontrado el equipo");
        }
        assertNotNull(equipoEncontrado);
    }

}