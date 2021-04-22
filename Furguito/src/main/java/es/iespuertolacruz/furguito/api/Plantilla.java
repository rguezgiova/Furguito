package es.iespuertolacruz.furguito.api;

public class Plantilla {

    String equipo;
    String nombre;
    int dorsal;
    String posicion;
    int goles;
    int asistencias;
    int amarillas;
    int rojas;

    /**
     * Constructor con todos los parametros
     * 
     * @param equipo      al que pertenece el jugador
     * @param nombre      del jugador
     * @param dorsal      del jugador
     * @param posicion    del jugador
     * @param goles       totales del jugador
     * @param asistencias totales del jugador
     * @param amarillas   totales del jugador
     * @param rojas       totales del jugador
     */
    public Plantilla(String equipo, String nombre, int dorsal, String posicion, int goles, int asistencias,
            int amarillas, int rojas) {
        this.equipo = equipo;
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.goles = goles;
        this.asistencias = asistencias;
        this.amarillas = amarillas;
        this.rojas = rojas;
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

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return this.dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return this.posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getGoles() {
        return this.goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getAsistencias() {
        return this.asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getAmarillas() {
        return this.amarillas;
    }

    public void setAmarillas(int amarillas) {
        this.amarillas = amarillas;
    }

    public int getRojas() {
        return this.rojas;
    }

    public void setRojas(int rojas) {
        this.rojas = rojas;
    }

    @Override
    public String toString() {
        return "Equipo='" + getEquipo() + "\n" + "Nombre='" + getNombre() + "\n" + "Dorsal='" + getDorsal() + "\n"
                + "Posicion='" + getPosicion() + "\n" + "Goles='" + getGoles() + "\n" + "Asistencias='"
                + getAsistencias() + "\n" + "Amarillas='" + getAmarillas() + "\n" + "Rojas='" + getRojas() + "\n";
    }

}
