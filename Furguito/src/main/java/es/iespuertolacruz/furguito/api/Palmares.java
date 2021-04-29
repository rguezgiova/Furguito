package es.iespuertolacruz.furguito.api;

public class Palmares {

    String equipo;
    int ligas;
    int copasDelRey;
    int SuperEspana;
    int superEuropa;
    int champions;
    int mundialClubs;

    /**
     * Constructor con todos los parametros
     * 
     * @param equipo       nombre del equipo
     * @param ligas        totales ganadas
     * @param copasdelrey  totales ganadas
     * @param superespana  totales ganadas
     * @param supereuropa  totales ganadas
     * @param champions    totales ganadas
     * @param mundialclubs totales ganadas
     */
    public Palmares(String equipo, int ligas, int copasDelRey, int SuperEspana, int superEuropa, int champions,
            int mundialClubs) {
        this.equipo = equipo;
        this.ligas = ligas;
        this.copasDelRey = copasDelRey;
        this.SuperEspana = SuperEspana;
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
        return this.SuperEspana;
    }

    public void setSuperEspana(int SuperEspana) {
        this.SuperEspana = SuperEspana;
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

}
