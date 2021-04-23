package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Equipo;

public class EquipoTest {

    Equipo equipo;

    @BeforeEach
    public void setUp() {
        if (equipo == null) {
            equipo = generarEquipo(null, null, null, 0, 0, 0, null);
        }
    }

    @Test
    public void generarEquipoVacioTest() {
        assertTrue(equipo.getNombre().contains("Cadiz"));
        assertTrue(equipo.getCiudad().contains("Cadiz"));
        assertTrue(equipo.getEstadio().contains("Carranza"));
        assertEquals(1910, equipo.getFundacion());
        assertEquals(16000, equipo.getNumsocios());
        assertEquals(51000000.00, equipo.getPresupuesto());
        assertTrue(equipo.getColores().contains("Amarillo"));
    }

    @Test
    public void generarEquipoTest() {
        equipo = generarEquipo("Villareal C.F.", "Castellon", "Estadio de la Ceramica", 1923, 15000, 117000000,
                "Amarillo");
        assertTrue(equipo.getNombre().contains("Villareal"));
        assertTrue(equipo.getCiudad().contains("Castellon"));
        assertTrue(equipo.getEstadio().contains("Ceramica"));
        assertEquals(1923, equipo.getFundacion());
        assertEquals(15000, equipo.getNumsocios());
        assertEquals(117000000, equipo.getPresupuesto());
        assertTrue(equipo.getColores().contains("Amarillo"));
    }

    @Test
    public void toStringTest() {
        assertNotNull(equipo.toString());
    }

    /**
     * Se genera un equipo para los test
     * 
     * @param nombre      del equipo
     * @param ciudad      en la que juega el equipo
     * @param estadio     en el que juega el equipo
     * @param fundacion   fecha de fundacion del equipo
     * @param numsocios   numero total de socios
     * @param presupuesto total anual
     * @param colores     del equipo
     * @return equipo
     */
    public Equipo generarEquipo(String nombre, String ciudad, String estadio, int fundacion, int numsocios,
            double presupuesto, String colores) {
        Equipo equipo = null;
        if (nombre != null && ciudad != null && fundacion > 0 && numsocios > 0 && presupuesto > 0 && colores != null) {
            equipo = new Equipo(nombre, ciudad, estadio, fundacion, numsocios, presupuesto, colores);
        } else {
            equipo = new Equipo();
            equipo.setNombre("Cadiz C.F.");
            equipo.setCiudad("Cadiz");
            equipo.setEstadio("Ramon de Carranza");
            equipo.setFundacion(1910);
            equipo.setNumsocios(16000);
            equipo.setPresupuesto(51000000.00);
            equipo.setColores("Amarillo y azul");
        }
        return equipo;

    }

}
