package es.iespuertolacruz.furguito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Plantilla;

public class PlantillaTest {

    Plantilla plantilla;

    @BeforeEach
    public void setUp() {
        if (plantilla == null) {
            plantilla = generarPlantilla(null, null, 0, 0, 0, 0, 0);
        }
    }

    @Test
    public void generarPlantillaVaciaTest(){
        assertTrue(plantilla.getEquipo().contains("Madrid"));
        assertTrue(plantilla.getNombre().contains("Sergio"));
        assertEquals(4, plantilla.getDorsal());
        assertEquals(11, plantilla.getGoles());
        assertEquals(0, plantilla.getAsistencias());
        assertEquals(10, plantilla.getAmarillas());
        assertEquals(0, plantilla.getRojas());
    }

    @Test
    public void generarPlantillaTest(){
        plantilla = new Plantilla("Real Club Celta de Vigo", "Iago Aspas", 10, 12, 10, 6, 0);
        assertTrue(plantilla.getEquipo().contains("Celta"));
        assertTrue(plantilla.getNombre().contains("Aspas"));
        assertEquals(10, plantilla.getDorsal());
        assertEquals(12, plantilla.getGoles());
        assertEquals(10, plantilla.getAsistencias());
        assertEquals(6, plantilla.getAmarillas());
        assertEquals(0, plantilla.getRojas());
    }

    @Test
    public void toStringTest(){
        assertNotNull(plantilla.toString());
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
    public Plantilla generarPlantilla(String equipo, String nombre, int dorsal, int goles, int asistencias, int amarillas, int rojas){
        Plantilla plantilla = null;
        if(equipo != null && nombre !=null){
            plantilla = new Plantilla(equipo, nombre, dorsal, goles, asistencias, amarillas, rojas);
        }else {
            plantilla = new Plantilla();
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
