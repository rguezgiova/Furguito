package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.exception.PersistenciaException;
import es.iespuertolacruz.furguito.modelo.Bbdd;
import es.iespuertolacruz.furguito.modelo.SqliteBbdd;

public class BbddTest {
    private static final String SQLTABLE = "src/resources/sql/equipos-crear.sql";
    private static final String SQLINSERT = "src/resources/sql/equipos-insertar.sql";
    Bbdd bbdd;
    SqliteBbdd sqliteBbdd;

    @BeforeEach
    public void setUp() {
        if (bbdd == null) {
            try {
                bbdd = new Bbdd("test", "id", "org.sqlite.JDBC", "jdbc:sqlite:furguito.db", null, null, SQLTABLE, SQLINSERT);
            } catch (PersistenciaException e) {
                fail("Error al inicializar Bbdd", e);
            }
        }
    }

    @Test
    public void constructorGenerarTest() {
        try {
            sqliteBbdd = new SqliteBbdd("test", "id", "org.sqlite.JDBC", "jdbc:sqlite:furguito.db", null, null, SQLTABLE, SQLINSERT);
        } catch (PersistenciaException e) {
            fail("Error al inicializar");
        }
    }

    @Test
    public void initErrorTest() {
        try {
            bbdd = new Bbdd("aaa", "id", "org.sqlite.JDBC", "jdbc:sqlite:furguito.db", null, null, null, null);
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("Se ha producido un error en la inicializacion de la BBDD"));
        }
    }

    @Test
    public void getConnectionUsuarioErrorTest() {
        try {
            bbdd = new Bbdd("test", null, "org.sqlite.JDBC", "jdbc:sqlite:furguito.db", "aaa", "aaa", null, null);
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("No se ha podido establecer conexion con la BBDD"));
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