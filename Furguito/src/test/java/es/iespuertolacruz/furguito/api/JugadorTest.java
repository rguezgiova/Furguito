package es.iespuertolacruz.furguito.api;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JugadorTest {

    Jugador jugador;

    @BeforeEach
    public void setUp() {
        if (jugador == null) {
            jugador = generarJugador(0, null, null, 0, 0, 0, 0, 0);
        }
    }

    @Test
    public void generarPlantillaVaciaTest() {
        assertEquals(300, jugador.getId());
        assertTrue(jugador.getEquipo().contains("Madrid"));
        assertTrue(jugador.getNombre().contains("Sergio"));
        assertEquals(4, jugador.getDorsal());
        assertEquals(11, jugador.getGoles());
        assertEquals(0, jugador.getAsistencias());
        assertEquals(10, jugador.getAmarillas());
        assertEquals(0, jugador.getRojas());
    }

    @Test
    public void generarPlantillaTest() {
        jugador = new Jugador(200, "Real Club Celta de Vigo", "Iago Aspas", 10, 12, 10, 6, 0);
        assertEquals(200, jugador.getId());
        assertTrue(jugador.getEquipo().contains("Celta"));
        assertTrue(jugador.getNombre().contains("Aspas"));
        assertEquals(10, jugador.getDorsal());
        assertEquals(12, jugador.getGoles());
        assertEquals(10, jugador.getAsistencias());
        assertEquals(6, jugador.getAmarillas());
        assertEquals(0, jugador.getRojas());
    }

    @Test
    public void toStringTest() {
        assertNotNull(jugador.toString());
    }

    /**
     * Se incluye un jugador en la plantilla para los test
     * @param equipo del jugador
     * @param nombre del jugador
     * @param dorsal del jugador
     * @param goles totales del jugador
     * @param asistencias totales del jugador
     * @param amarillas totales del jugador
     * @param rojas totales del jugador
     * @return 
     */
    public Jugador generarJugador(int id, String equipo, String nombre, int dorsal, int goles, int asistencias, int amarillas, int rojas){
        Jugador plantilla = null;
        if(equipo != null && nombre !=null){
            plantilla = new Jugador(id, equipo, nombre, dorsal, goles, asistencias, amarillas, rojas);
        }else {
            plantilla = new Jugador();
            plantilla.setId(300);
            plantilla.setEquipo("Real Madrid C.F.");
            plantilla.setNombre("Sergio Ramos");
            plantilla.setDorsal(4);
            plantilla.setGoles(11);
            plantilla.setAsistencias(0);
            plantilla.setAmarillas(10);
            plantilla.setRojas(0);
        }
        return plantilla;
    }
    
}
