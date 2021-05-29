package es.iespuertolacruz.furguito.api;

public class Jugador {

    int id;
    String equipo;
    String nombre;
    int dorsal;
    int goles;
    int asistencias;
    int amarillas;
    int rojas;

    /**
     * Constructor con todos los parametros
     * 
     * @param id          del jugador
     * @param equipo      al que pertenece el jugador
     * @param nombre      del jugador
     * @param dorsal      del jugador
     * @param goles       totales del jugador
     * @param asistencias totales del jugador
     * @param amarillas   totales del jugador
     * @param rojas       totales del jugador
     */
    public Jugador(int id, String equipo, String nombre, int dorsal, int goles, int asistencias, int amarillas,
            int rojas) {
        this.id = id;
        this.equipo = equipo;
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.goles = goles;
        this.asistencias = asistencias;
        this.amarillas = amarillas;
        this.rojas = rojas;
    }

    /**
     * Constructor vacio
     */
    public Jugador() {
    }

    /**
     * Getters y Setters
     * 
     */
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}