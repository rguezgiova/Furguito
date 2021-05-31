package es.iespuertolacruz.furguito.api;

public class Estadio {

    int id;
    String nombre;
    String equipo;
    int capacidad;
    int construccion;

    /**
     * Constructor con todos los parametros
     * 
     * @param id           del estadio
     * @param nombre       del estadio
     * @param equipo       al que pertenece el estadio
     * @param capacidad    total del estadio
     * @param construccion fecha de construccion del estadio
     */
    public Estadio(int id, String nombre, String equipo, int capacidad, int construccion) {
        this.id = id;
        this.nombre = nombre;
        this.equipo = equipo;
        this.capacidad = capacidad;
        this.construccion = construccion;
    }

    /**
     * Constructor vacio
     */
    public Estadio() {
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

    /**
     * Metodo toString
     */
    @Override
    public String toString() {
        return " IDEstadio='" + getId() + "'" + ", Nombre='" + getNombre() + "'" + ", Equipo='" + getEquipo() + "'"
                + ", Capacidad='" + getCapacidad() + "'" + ", Construccion='" + getConstruccion() + "\n";
    }

}