package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Equipo;
import es.iespuertolacruz.furguito.exception.PersistenciaException;
import es.iespuertolacruz.furguito.modelo.Bbdd;
import es.iespuertolacruz.furguito.modelo.EquipoModelo;

public class EquipoModeloTest {
    Equipo equipo;
    static EquipoModelo equipoModelo;
    Bbdd bbdd;
/**
 * @BeforeAll
    public static void beforeAll() {
        if (equipoModelo == null) {
            try {
                equipoModelo = new EquipoModelo();
            } catch (PersistenciaException e) {
                fail("Se ha producido un error en la inicializacion de la BBDD");
            }
        }
    }
 
    

    @BeforeEach
    public void crearEquipo() {
        equipo = new Equipo("1", "Deportivo Alaves", "Alava", "Mendizorroza", 17713, 2122, 64000000, "Azul y blanco");
        try {
            equipoModelo.insertarEquipo(equipo);
        } catch (Exception e) {
            fail("Se ha producido un error insertando el equipo");
        }
    }

    @AfterEach
    public void eliminarEquipo() {
        if (equipo != null) {
            try {
                equipoModelo.eliminarEquipo(equipo);
            } catch (Exception e) {
                fail("Se ha producido un error eliminando el equipo");
            }
        }
    }
    

    @Test
    public void buscarEquipoTest() {
        try {
            Equipo equipoEncontrado = equipoModelo.consultarInformacion("Deportivo Alaves");
            assertNotNull(equipoEncontrado, "No se debe de obtener un elemento nulo");
            assertEquals(equipo, equipoEncontrado, "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
            fail("Se ha producido un error en la consulta del equipo: "+e.getMessage());

        }
    }
    */

    @Test
    public void initTest() {
        try {
           bbdd = new Bbdd("org.sqlite.JDBC", "jdbc:sqlite:furguito.db", null, null);
        } catch (PersistenciaException e) {
            fail("putamadre: "+e.getMessage());

        }
    }
}