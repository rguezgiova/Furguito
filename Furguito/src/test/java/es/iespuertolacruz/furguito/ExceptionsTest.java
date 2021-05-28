package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.exception.*;

public class ExceptionsTest {

    @Test
    public void persistenciaExceptionTest() {
        Exception persistenciaException = new PersistenciaException("Mensaje de error");
        assertTrue(persistenciaException.getMessage().contains("Mensaje de error"), "No genera el mensaje de error");

    }

    @Test
    public void persistenciaExceptionCausaTest() {
        Exception persistenciaException = new PersistenciaException("Mensaje de error", new Exception());
        assertTrue(persistenciaException.getMessage().contains("Mensaje de error"), "No genera el mensaje de error");
    }

    @Test
    public void equipoExceptionTest() {
        Exception equipoException = new EquipoException("Mensaje de error");
        assertTrue(equipoException.getMessage().contains("Mensaje de error"), "No genera el mensaje de error");

    }

    @Test
    public void equipoExceptionCausaTest() {
        Exception equipoException = new EquipoException("Mensaje de error", new Exception());
        assertTrue(equipoException.getMessage().contains("Mensaje de error"), "No genera el mensaje de error");
    }

    @Test
    public void estadioExceptionTest() {
        Exception estadioException = new EstadioException("Mensaje de error");
        assertTrue(estadioException.getMessage().contains("Mensaje de error"), "No genera el mensaje de error");

    }

    @Test
    public void estadioExceptionCausaTest() {
        Exception estadioException = new EstadioException("Mensaje de error", new Exception());
        assertTrue(estadioException.getMessage().contains("Mensaje de error"), "No genera el mensaje de error");
    }

    @Test
    public void ficheroExceptionTest() {
        Exception ficheroException = new FicheroException("Mensaje de error");
        assertTrue(ficheroException.getMessage().contains("Mensaje de error"), "No genera el mensaje de error");

    }

    @Test
    public void ficheroExceptionCausaTest() {
        Exception ficheroException = new FicheroException("Mensaje de error", new Exception());
        assertTrue(ficheroException.getMessage().contains("Mensaje de error"), "No genera el mensaje de error");
    }

    @Test
    public void jugadorExceptionTest() {
        Exception jugadorException = new JugadorException("Mensaje de error");
        assertTrue(jugadorException.getMessage().contains("Mensaje de error"), "No genera el mensaje de error");

    }

    @Test
    public void jugadorExceptionCausaTest() {
        Exception jugadorException = new JugadorException("Mensaje de error", new Exception());
        assertTrue(jugadorException.getMessage().contains("Mensaje de error"), "No genera el mensaje de error");
    }

    @Test
    public void palmaresExceptionTest() {
        Exception palmaresException = new PalmaresException("Mensaje de error");
        assertTrue(palmaresException.getMessage().contains("Mensaje de error"), "No genera el mensaje de error");

    }

    @Test
    public void palmaresExceptionCausaTest() {
        Exception palmaresException = new PalmaresException("Mensaje de error", new Exception());
        assertTrue(palmaresException.getMessage().contains("Mensaje de error"), "No genera el mensaje de error");
    }

    


}
