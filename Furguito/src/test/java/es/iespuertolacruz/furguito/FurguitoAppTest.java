package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.vista.FurguitoUserApp;

public class FurguitoAppTest {

    FurguitoUserApp furguitoApp;

    @BeforeEach
    public void setup() {
        if (furguitoApp == null) {
            furguitoApp = new FurguitoUserApp();
        }
    }

    @Test
    public void menuAdminTest() {
        assertTrue(true);
    }
}
