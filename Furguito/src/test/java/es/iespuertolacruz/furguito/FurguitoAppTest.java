package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FurguitoAppTest {

    FurguitoApp furguitoApp;

    @BeforeEach
    public void setup() {
        if (furguitoApp == null) {
            furguitoApp = new FurguitoApp();
        }
    }

    @Test
    public void menuAdminTest() {
        assertTrue(true);
    }
}
