package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Equipo;
import es.iespuertolacruz.furguito.controller.EquipoController;
import es.iespuertolacruz.furguito.exception.EquipoException;
import es.iespuertolacruz.furguito.exception.PersistenciaException;
import es.iespuertolacruz.furguito.modelo.Bbdd;

public class EquipoControllerTest {
    static Equipo equipo;
    static EquipoController equipoController;
    Bbdd bbdd;

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
    public void validarPersonaNulaTest() {
        Equipo equipoNulo = null;
        try {
            equipoController.validar(equipoNulo);
        } catch (EquipoException e) {
            assertTrue(e.getMessage().contains("Se esta intentando validar un objeto vacio"));
        }
    }

    @Test
    public void validarPersonaVaciaTest() {
        Persona personaNula = new Persona("", "", "", "", 0);
        try {
            personaController.validarPersona(personaNula);
        } catch (PersonaException e) {
            assertTrue(e.getMessage().contains("El telefono de la persona"));
        }
    }
}