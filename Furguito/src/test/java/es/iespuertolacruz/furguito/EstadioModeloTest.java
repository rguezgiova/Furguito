package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Estadio;
import es.iespuertolacruz.furguito.exception.PersistenciaException;
import es.iespuertolacruz.furguito.modelo.Bbdd;
import es.iespuertolacruz.furguito.modelo.EstadioModelo;

public class EstadioModeloTest {
    static Estadio estadio;
    static EstadioModelo estadioModelo;
    Bbdd bbdd;

    @BeforeAll
    public static void beforeAll() {
        if (estadioModelo == null) {
            try {
                estadioModelo = new EstadioModelo();
            } catch (PersistenciaException e) {
                fail("Se ha producido un error en la inicializacion de la BBDD");
            }
        }
    }

    @Test
    public void buscarEstadioTest() {
        try {
            Estadio estadioEncontrado = estadioModelo.obtenerEstadio("Mendizorroza");
            assertNotNull(estadioEncontrado, "No se debe de obtener un elemento nulo");
            assertEquals(estadioEncontrado.getNombre(), "Mendizorroza", "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
            fail("Se ha producido un error en la consulta del estadio: " + e.getMessage());

        }
    }

    @Test
    public void insertarEstadioTest() {
        Estadio estadioInsertar = new Estadio(22, "Rguez Lopez", "Tenerife", 22824, 1925);
        try {
            estadioModelo.insertar(estadioInsertar);
        } catch (Exception e) {
            fail("No se ha podido insertar el estadio");
        }
    }
}