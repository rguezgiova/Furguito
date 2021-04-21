package main.java.es.iespuertodelacruz.neftagiovanni.api;

public class Palmares {

    String equipo;
    int ligas;
    int copasdelrey;
    int superespana;
    int supereuropa;
    int champions;
    int mundialclubs;

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
    public Palmares(String equipo, int ligas, int copasdelrey, int superespana, int supereuropa, int champions,
            int mundialclubs) {
        this.equipo = equipo;
        this.ligas = ligas;
        this.copasdelrey = copasdelrey;
        this.superespana = superespana;
        this.supereuropa = supereuropa;
        this.champions = champions;
        this.mundialclubs = mundialclubs;
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

    public int getCopasdelrey() {
        return this.copasdelrey;
    }

    public void setCopasdelrey(int copasdelrey) {
        this.copasdelrey = copasdelrey;
    }

    public int getSuperespana() {
        return this.superespana;
    }

    public void setSuperespana(int superespana) {
        this.superespana = superespana;
    }

    public int getSupereuropa() {
        return this.supereuropa;
    }

    public void setSupereuropa(int supereuropa) {
        this.supereuropa = supereuropa;
    }

    public int getChampions() {
        return this.champions;
    }

    public void setChampions(int champions) {
        this.champions = champions;
    }

    public int getMundialclubs() {
        return this.mundialclubs;
    }

    public void setMundialclubs(int mundialclubs) {
        this.mundialclubs = mundialclubs;
    }

    @Override
    public String toString() {
        return "Equipo='" + getEquipo() + "\n" + "Ligas='" + getLigas() + "\n" + "Copas del rey='" + getCopasdelrey()
                + "\n" + "Supercopas de Espana='" + getSuperespana() + "\n" + "Supercopas de Europa='"
                + getSupereuropa() + "\n" + "Champions League='" + getChampions() + "\n" + "Mundiales de clubs='"
                + getMundialclubs() + "\n";
    }

}
