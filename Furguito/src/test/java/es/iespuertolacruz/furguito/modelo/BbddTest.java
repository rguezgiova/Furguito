package es.iespuertolacruz.furguito.modelo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class BbddTest {
    Bbdd bbdd;
    SqliteBbdd sqliteBbdd;

    @BeforeEach
    public void setUp() {
        if (bbdd == null) {
            try {
                bbdd = new Bbdd("Equipos", "idEquipo", "org.sqlite.JDBC", "jdbc:sqlite:furguito.db", null, null);
            } catch (PersistenciaException e) {
                fail("Error al inicializar Bbdd", e);
            }
        }
    }

    @AfterEach
    public void afterEach() {
        try {
            bbdd.actualizar("DROP TABLE Equipos");
        } catch (PersistenciaException e) {
            fail("Error al eliminar la tabla");
        }
    }

    @Test
    public void constructorGenerarTest() {
        try {
            sqliteBbdd = new SqliteBbdd("Equipos", "idEquipo", "org.sqlite.JDBC", "jdbc:sqlite:furguito.db", null, null);
        } catch (PersistenciaException e) {
            fail("Error al inicializar");
        }
    }

    @Test
    public void initErrorTest() {
        try {
            bbdd = new Bbdd("aaa", "id", "org.sqlite.JDBC", "jdbc:sqlite:furguito.db", null, null);
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error en la inicializacion de la BBDD"));
        }
    }

    @Test
    public void getConnectionErrorTest() {
        try {
            bbdd = new Bbdd("Equipos", "idEquipo", "", "jdbc:sqlite:furguito.db", null, null);
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error en la inicializacion"));
        }
    }

    @Test
    public void getConnectionUsuarioErrorTest() {
        try {
            bbdd = new Bbdd("Equipo", "idEquipo", "org.sqlite.JDBC", "jdbc:sqlite:furguito.db", "asdf", "asdf");
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error en la inicializacion"));
        }
    }

    @Test
    public void actualizarErrorTest() {
        try {
            bbdd.actualizar("error");
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error en la consulta"), "La consulta deberia dar error");
        }
    }
}