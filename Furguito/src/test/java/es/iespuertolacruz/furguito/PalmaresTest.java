package es.iespuertolacruz.furguito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.furguito.api.Palmares;

public class PalmaresTest {

    Palmares palmares;

    @BeforeEach
    public void setUp() {
        if (palmares == null) {
            palmares = generarPalmares(null, 0, 0, 0, 0, 0, 0);
        }
    }


    @Test
    public void generarPalmaresVacioTest(){
        assertTrue(palmares.getEquipo().contains("Barcelona"));
        assertEquals(26, palmares.getLigas());
        assertEquals(31, palmares.getCopasdelrey());
        assertEquals(13, palmares.getSuperespana());
        assertEquals(5, palmares.getSupereuropa());
        assertEquals(5, palmares.getChampions());
        assertEquals(3, palmares.getMundialclubs());
    }

    @Test
    public void generarPalmaresVacio(){
        palmares = generarPalmares("Valencia C.F.", 6, 8, 1, 2, 0, 0);
        assertTrue(palmares.getEquipo().contains("Valencia"));
        assertEquals(6, palmares.getLigas());
        assertEquals(8, palmares.getCopasdelrey());
        assertEquals(1, palmares.getSuperespana());
        assertEquals(2, palmares.getSupereuropa());
        assertEquals(0, palmares.getChampions());
        assertEquals(0, palmares.getMundialclubs());
    }



    @Test
    public void toStringTest(){
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
    public Palmares generarPalmares(String equipo, int ligas, int copasdelrey, int superespana, int supereuropa,
            int champions, int mundialclubs) {
        Palmares palmares = null;
        if (equipo != null) {
            palmares = new Palmares(equipo, ligas, copasdelrey, superespana, supereuropa, champions, mundialclubs);
        } else {
            palmares = new Palmares();
            palmares.setEquipo("F.C. Barcelona");
            palmares.setLigas(26);
            palmares.setCopasdelrey(31);
            palmares.setSuperespana(13);
            palmares.setSupereuropa(5);
            palmares.setChampions(5);
            palmares.setMundialclubs(3);
        }
        return palmares;
    }

}
