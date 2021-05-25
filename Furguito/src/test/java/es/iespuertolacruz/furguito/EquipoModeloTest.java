package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
            Equipo equipoEncontrado = equipoModelo.consultarInformacion("Barcelona");
            assertNotNull(equipoEncontrado, "No se debe de obtener un elemento nulo");
            assertEquals(equipoEncontrado.getNombre(), "Futbol Club Barcelona", "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
            fail("Se ha producido un error en la consulta del equipo: "+e.getMessage());

        }
    }


    @Test
    public void eliminarEquipoTest(){
        Equipo equipo;
        equipo = new Equipo("Deportivo Alaves", "Alava", "Mendizorroza", 1921, 17713, 64000000, "Blanco y azul");
        try {
            equipoModelo.eliminarEquipo(equipo);
        } catch (PersistenciaException e) {
            fail("No se ha podido eliminar el equipo");
        }

    }

    @Test
    public void insertarEquipoTest(){
        Equipo equipo;
        equipo = new Equipo(null, "Deportivo Ceuta", "Ceuta", "Ninguno", 1921, 17713, 64000000, "Blanco y azul");
        try{
            equipoModelo.insertarEquipo(equipo);
        }catch (PersistenciaException exception){
            fail("No se ha podido insertar el equipo");
        }
    }


    

    @Test
    public void initTest() {
        try {
           bbdd = new Bbdd("Equipos", "idEquipo", "org.sqlite.JDBC", "jdbc:sqlite:furguito.db", null, null);
        } catch (PersistenciaException e) {
            fail("Error: "+e.getMessage());

        }
    }

    

    
}