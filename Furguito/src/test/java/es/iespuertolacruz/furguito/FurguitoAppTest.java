package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.exception.EquipoException;
import es.iespuertolacruz.furguito.exception.EstadioException;
import es.iespuertolacruz.furguito.exception.JugadorException;
import es.iespuertolacruz.furguito.exception.PalmaresException;
import es.iespuertolacruz.furguito.exception.PersistenciaException;
import es.iespuertolacruz.furguito.vista.FurguitoVista;

public class FurguitoAppTest {
    private ByteArrayInputStream testIn;
    String[] args = null;
    FurguitoVista furguitoApp;

    @BeforeEach
    public void setup() {
        if (furguitoApp == null) {
            try {
                furguitoApp = new FurguitoVista();
            } catch (PersistenciaException e) {
                fail("Error al iniciar la vista");
            }
        }
    }

    @Test
    public void salirMenuPrincipalTest() {
        args = null;
        testIn = new ByteArrayInputStream("3".getBytes());
        System.setIn(testIn);

        try {
            FurguitoVista.menuPrincipal();
        } catch (PersistenciaException | EquipoException | EstadioException | JugadorException | PalmaresException e) {
            fail("Se ha producido un error ejecuntando el menu");
        }
    }

    @Test
    public void opcionDefaultMenuPrincipalTest() {
        args = null;
        testIn = new ByteArrayInputStream("0\r3".getBytes());
        System.setIn(testIn);

        try {
            FurguitoVista.menuPrincipal();
        } catch (PersistenciaException | EquipoException | EstadioException | JugadorException | PalmaresException e) {
            fail("Se ha producido un error ejecuntando el menu");
        }
    }

    @Test
    public void salirMenuAdminTest() {
        args = null;
        testIn = new ByteArrayInputStream("13".getBytes());
        System.setIn(testIn);

        try {
            FurguitoVista.menuAdmin();
        } catch (PersistenciaException | EquipoException | EstadioException | JugadorException | PalmaresException e) {
            fail("Se ha producido un error ejecuntando el menu");
        }
    }

    @Test
    public void opcionDefaultMenuAdminTest() {
        args = null;
        testIn = new ByteArrayInputStream("0\r13".getBytes());
        System.setIn(testIn);

        try {
            FurguitoVista.menuAdmin();
        } catch (PersistenciaException | EquipoException | EstadioException | JugadorException | PalmaresException e) {
            fail("Se ha producido un error ejecuntando el menu");
        }
    }

    @Test
    public void opcion8MenuInvitadoTest() {
        args = null;
        testIn = new ByteArrayInputStream("8\r13".getBytes());
        System.setIn(testIn);

        try {
            FurguitoVista.menuInvitado();
        } catch (PersistenciaException e) {
            fail("Se ha producido un error ejecuntando el menu");
        }
    }

    @Test
    public void opcion9MenuInvitadoTest() {
        args = null;
        testIn = new ByteArrayInputStream("9\r13".getBytes());
        System.setIn(testIn);

        try {
            FurguitoVista.menuInvitado();
        } catch (PersistenciaException e) {
            fail("Se ha producido un error ejecuntando el menu");
        }
    }

    @Test
    public void opcion11MenuInvitadoTest() {
        args = null;
        testIn = new ByteArrayInputStream("11\r13".getBytes());
        System.setIn(testIn);

        try {
            FurguitoVista.menuInvitado();
        } catch (PersistenciaException e) {
            fail("Se ha producido un error ejecuntando el menu");
        }
    }

    @Test
    public void opcion12MenuInvitadoTest() {
        args = null;
        testIn = new ByteArrayInputStream("12\r13".getBytes());
        System.setIn(testIn);

        try {
            FurguitoVista.menuInvitado();
        } catch (PersistenciaException e) {
            fail("Se ha producido un error ejecuntando el menu");
        }
    }

    @Test
    public void salirMenuInvitadoTest() {
        args = null;
        testIn = new ByteArrayInputStream("13".getBytes());
        System.setIn(testIn);

        try {
            FurguitoVista.menuInvitado();
        } catch (PersistenciaException e) {
            fail("Se ha producido un error ejecuntando el menu");
        }
    }

    @Test
    public void opcionDefaultMenuInvitadoTest() {
        args = null;
        testIn = new ByteArrayInputStream("0\r13".getBytes());
        System.setIn(testIn);

        try {
            FurguitoVista.menuInvitado();
        } catch (PersistenciaException e) {
            fail("Se ha producido un error ejecuntando el menu");
        }
    }
}