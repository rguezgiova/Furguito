package es.iespuertolacruz.furguito.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PalmaresTest {

    Palmares palmares;

    @BeforeEach
    public void setUp() {
        if (palmares == null) {
            palmares = generarPalmares(0, null, 0, 0, 0, 0, 0, 0);
        }
    }


    @Test
    public void generarPalmaresVacioTest() {
        assertTrue(palmares.getEquipo().contains("Barcelona"));
        assertEquals(26, palmares.getLigas());
        assertEquals(31, palmares.getCopasDelRey());
        assertEquals(13, palmares.getSuperEspana());
        assertEquals(5, palmares.getSuperEuropa());
        assertEquals(5, palmares.getChampions());
        assertEquals(3, palmares.getMundialClubs());
    }

    @Test
    public void generarPalmaresVacio() {
        palmares = generarPalmares(2, "Valencia C.F.", 6, 8, 1, 2, 0, 0);
        assertEquals(2, palmares.getId());
        assertTrue(palmares.getEquipo().contains("Valencia"));
        assertEquals(6, palmares.getLigas());
        assertEquals(8, palmares.getCopasDelRey());
        assertEquals(1, palmares.getSuperEspana());
        assertEquals(2, palmares.getSuperEuropa());
        assertEquals(0, palmares.getChampions());
        assertEquals(0, palmares.getMundialClubs());
    }



    @Test
    public void toStringTest() {
        assertNotNull(palmares.toString());
    }

    /**
     * Se genera un palmares para los test
     * 
     * @param equipo       equipo
     * @param ligas        ganadas
     * @param copasdelrey  ganadas
     * @param superespana  SuperCopas de espana ganadas
     * @param supereuropa  SuperCopas de europa
     * @param champions    ganadas
     * @param mundialclubs ganados
     * @return palmares
     */
    public Palmares generarPalmares(int id, String equipo, int ligas, int copasdelrey, int superespana, int supereuropa,
            int champions, int mundialclubs) {
        Palmares palmares = null;
        if (equipo != null) {
            palmares = new Palmares(id, equipo, ligas, copasdelrey, superespana, supereuropa, champions, mundialclubs);
        } else {
            palmares = new Palmares();
            palmares.setId(1);
            palmares.setEquipo("F.C. Barcelona");
            palmares.setLigas(26);
            palmares.setCopasDelRey(31);
            palmares.setSuperEspana(13);
            palmares.setSuperEuropa(5);
            palmares.setChampions(5);
            palmares.setMundialClubs(3);
        }
        return palmares;
    }

}
