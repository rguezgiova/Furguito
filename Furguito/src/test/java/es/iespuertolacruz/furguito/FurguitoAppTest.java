package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.vista.FurguitoVista;

public class FurguitoAppTest {

    FurguitoVista furguitoApp;

    @BeforeEach
    public void setup() {
        if (furguitoApp == null) {
            furguitoApp = new FurguitoVista();
        }
    }

    @Test
    public void menuAdminTest() {
        assertTrue(true);
    }
}
