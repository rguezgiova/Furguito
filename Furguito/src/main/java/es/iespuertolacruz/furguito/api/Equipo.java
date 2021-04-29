package es.iespuertolacruz.furguito.api;

public class Equipo {

    String nombre;
    String ciudad;
    String estadio;
    int fundacion;
    int numeroSocios;
    double presupuesto;
    String colores;

    /**
     * Constructor con todos los parametros
     * 
     * @param nombre      del club
     * @param ciudad      en la que juega el club
     * @param estadio     del club
     * @param fundacion   fecha de fundacion del club
     * @param numsocios   totales del club
     * @param presupuesto total anual del club
     * @param colores     del club
     */
    public Equipo(String nombre, String ciudad, String estadio, int fundacion, int numeroSocios, double presupuesto,
            String colores) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estadio = estadio;
        this.fundacion = fundacion;
        this.numeroSocios = numeroSocios;
        this.presupuesto = presupuesto;
        this.colores = colores;
    }

    /**
     * Constructor vacio
     */
    public Equipo() {
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

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstadio() {
        return this.estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getFundacion() {
        return this.fundacion;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    public int getNumeroSocios() {
        return this.numeroSocios;
    }

    public void setNumeroSocios(int numeroSocios) {
        this.numeroSocios = numeroSocios;
    }

    public double getPresupuesto() {
        return this.presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getColores() {
        return this.colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    /**
     * Metodo toString
     */
    @Override
    public String toString() {
        return "Nombre='" + getNombre() + "\n" + "Ciudad='" + getCiudad() + "\n" + "Estadio='" + getEstadio() + "\n"
                + "Fecha de fundacion='" + getFundacion() + "\n" + "Numero de socios='" + getNumeroSocios() + "\n"
                + "Presupuesto anual='" + getPresupuesto() + "\n" + "Colores del club='" + getColores() + "\n";
    }
}
