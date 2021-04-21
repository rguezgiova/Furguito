package main.java.es.iespuertodelacruz.neftagiovanni.api;

public class Estadio {

    String nombre;
    String equipo;
    int capacidad;
    int construccion;

    /**
     * Constructor con todos los parametros
     * 
     * @param nombre       del estadio
     * @param equipo       al que pertenece el estadio
     * @param capacidad    total del estadio
     * @param construccion fecha de construccion del estadio
     */
    public Estadio(String nombre, String equipo, int capacidad, int construccion) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.capacidad = capacidad;
        this.construccion = construccion;
    }

    /**
     * Getters y Setters
     * 
     */
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return this.equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getConstruccion() {
        return this.construccion;
    }

    public void setConstruccion(int construccion) {
        this.construccion = construccion;
    }

    @Override
    public String toString() {
        return "Nombre='" + getNombre() + "\n" + "Equipo='" + getEquipo() + "\n" + "Capacidad total='" + getCapacidad()
                + "\n" + "Fecha de construccion='" + getConstruccion();
    }

}
