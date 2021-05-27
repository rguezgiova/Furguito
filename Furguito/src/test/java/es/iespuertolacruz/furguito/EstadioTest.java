package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Estadio;

public class EstadioTest {

    Estadio estadio;

    @BeforeEach
    public void setUp() {
        if (estadio == null) {
            estadio = generareEstadio(0, null, null, 0, 0);
        }
    }

    @Test
    public void generareEstadioVacioTest() {
        assertTrue(estadio.getNombre().contains("Wanda"));
        assertTrue(estadio.getEquipo().contains("Madrid"));
        assertEquals(68456, estadio.getCapacidad());
        assertEquals(2017, estadio.getConstruccion());
    }

    @Test
    public void generareEstadioTest() {
        estadio = generareEstadio(14, "Benito Villamarin", "Real Betis Balompie", 60721, 1929);
        assertTrue(estadio.getNombre().contains("Benito"));
        assertTrue(estadio.getEquipo().contains("Betis"));
        assertEquals(60721, estadio.getCapacidad());
        assertEquals(1929, estadio.getConstruccion());
    }

    @Test
    public void toStringTest() {
        assertNotNull(estadio.toString());
    }

    /**
     * Se genera un estadio para los test
     * 
     * @param nombre       del estadio
     * @param equipo       al que pertenece
     * @param capacidad    total
     * @param construccion fecha de construccion
     * 
     * @return estadio
     */
    public Estadio generareEstadio(int id, String nombre, String equipo, int capacidad, int construccion) {
        Estadio estadio = null;
        if (id > 0 && nombre != null && equipo != null && capacidad > 0 && construccion > 0) {
            estadio = new Estadio(id, nombre, equipo, capacidad, construccion);
        } else {
            estadio = new Estadio();
            estadio.setId(2);
            estadio.setNombre("Wanda Metropolitano");
            estadio.setEquipo("Atletico de Madrid");
            estadio.setCapacidad(68456);
            estadio.setConstruccion(2017);
        }
        return estadio;

    }

}
