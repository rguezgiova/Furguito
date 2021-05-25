package es.iespuertolacruz.furguito.api;

import com.google.inject.internal.util.Objects;

public class Palmares {

    String id;
    String equipo;
    int ligas;
    int copasDelRey;
    int superEspana;
    int superEuropa;
    int champions;
    int mundialClubs;

    /**
     * Constructor con todos los parametros
     * 
     * @param id           del palmares
     * @param equipo       nombre del equipo
     * @param ligas        totales ganadas
     * @param copasDelRey  totales ganadas
     * @param superEspana  totales ganadas
     * @param superEuropa  totales ganadas
     * @param champions    totales ganadas
     * @param mundialClubs totales ganadas
     */
    public Palmares(String id, String equipo, int ligas, int copasDelRey, int superEspana, int superEuropa,
            int champions, int mundialClubs) {
        this.id = id;
        this.equipo = equipo;
        this.ligas = ligas;
        this.copasDelRey = copasDelRey;
        this.superEspana = superEspana;
        this.superEuropa = superEuropa;
        this.champions = champions;
        this.mundialClubs = mundialClubs;
    }

    /**
     * Constructor vacio
     */
    public Palmares() {
    }

    /**
     * Getters y Setters
     * 
     */
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipo() {
        return this.equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getLigas() {
        return this.ligas;
    }

    public void setLigas(int ligas) {
        this.ligas = ligas;
    }

    public int getCopasDelRey() {
        return this.copasDelRey;
    }

    public void setCopasDelRey(int copasDelRey) {
        this.copasDelRey = copasDelRey;
    }

    public int getSuperEspana() {
        return this.superEspana;
    }

    public void setSuperEspana(int superEspana) {
        this.superEspana = superEspana;
    }

    public int getSuperEuropa() {
        return this.superEuropa;
    }

    public void setSuperEuropa(int superEuropa) {
        this.superEuropa = superEuropa;
    }

    public int getChampions() {
        return this.champions;
    }

    public void setChampions(int champions) {
        this.champions = champions;
    }

    public int getMundialClubs() {
        return this.mundialClubs;
    }

    public void setMundialClubs(int mundialClubs) {
        this.mundialClubs = mundialClubs;
    }

    @Override
    public String toString() {
        return "Equipo='" + getEquipo() + "\n" + "Ligas='" + getLigas() + "\n" + "Copas del rey='" + getCopasDelRey()
                + "\n" + "Supercopas de Espana='" + getSuperEspana() + "\n" + "Supercopas de Europa='"
                + getSuperEuropa() + "\n" + "Champions League='" + getChampions() + "\n" + "Mundiales de clubs='"
                + getMundialClubs() + "\n";
    }

    /**
     * Funcion equals de comparacion
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Palmares)) {
            return false;
        }
        Palmares palmares = (Palmares) o;
        return Objects.equal(id, palmares.id) && Objects.equal(equipo, palmares.equipo) && ligas == palmares.ligas
                && copasDelRey == palmares.copasDelRey && superEspana == palmares.superEspana
                && superEuropa == palmares.superEuropa && champions == palmares.champions
                && mundialClubs == palmares.mundialClubs;
    }
}