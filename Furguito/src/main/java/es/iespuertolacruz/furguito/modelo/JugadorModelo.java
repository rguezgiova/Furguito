package es.iespuertolacruz.furguito.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import es.iespuertolacruz.furguito.api.Jugador;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class JugadorModelo {
    Jugador jugador;
    SqliteBbdd persistencia;
    private static final String ERROR_CONSULTA = "Se ha producido un error en la transformacion ";
    private static final String TABLA = "Jugadores";
    private static final String CLAVE = "idJugador";

    /**
     * Constructor de la clase
     * 
     * @throws PersistenciaException error controlado
     */
    public JugadorModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null);
    }

    /**
     * Metodo que se encarga de la insercion de un jugador en la BBDD
     * 
     * @param jugador a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertar(Jugador jugador) throws PersistenciaException {
        String sql = "";
        sql = "INSERT INTO " + TABLA + " (" + CLAVE
                + ", equipo, nombre, dorsal, goles, asistencias, amarillas, rojas) VALUES(" + jugador.getId() + ", '"
                + jugador.getEquipo() + "', '" + jugador.getNombre() + "', " + jugador.getDorsal() + ", "
                + jugador.getGoles() + ", " + jugador.getAsistencias() + ", " + jugador.getAmarillas() + ", "
                + jugador.getRojas() + ")";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo para modificar un jugador dentro de la BBDD
     * 
     * @param jugador a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificar(Jugador jugador) throws PersistenciaException {
        String sql = "";
        sql = "UPDATE " + TABLA + " SET equipo = '" + jugador.getEquipo() + "'" + ", nombre = '" + jugador.getNombre()
                + "'" + ", dorsal = " + jugador.getDorsal() + ", goles = " + jugador.getGoles() + ", asistencias = "
                + jugador.getAsistencias() + ", amarillas = " + jugador.getAmarillas() + ", rojas = "
                + jugador.getRojas() + " WHERE " + CLAVE + " = " + jugador.getId();
        persistencia.actualizar(sql);
    }

    /**
     * Metodo para borrar un jugador de la BBDD
     * 
     * @param id del jugador a borrar
     * @throws PersistenciaException error controlado
     */
    public void eliminar(int id) throws PersistenciaException {
        String sql = "";
        sql = "DELETE FROM " + TABLA + " WHERE " + CLAVE + " = " + id;
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que obtiene un jugador buscado por nombre
     * 
     * @param nombre del jugador a buscar
     * @return jugador
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Jugador> obtenerJugador(String nombre) throws PersistenciaException {
        ArrayList<Jugador> listaJugadores = null;
        String sql = "SELECT * FROM " + TABLA + " WHERE nombre LIKE '%" + nombre + "%'";
        listaJugadores = obtenerJugadores(sql);
        return listaJugadores;
    }

    /**
     * Funcion que devuelve los 5 maximos goleadores de la liga
     * 
     * @return lista de goleadores
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Jugador> obtenerGoleadores() throws PersistenciaException {
        ArrayList<Jugador> listaJugadores = null;
        String sql = "SELECT * FROM " + TABLA + " ORDER BY goles DESC LIMIT 5";
        listaJugadores = obtenerJugadores(sql);
        return listaJugadores;
    }

    /**
     * Funcion que devuelve los 10 jugadores con mas tarjetas rojas de la liga
     * 
     * @return lista de expulsados
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Jugador> obtenerExpulsados() throws PersistenciaException {
        ArrayList<Jugador> listaJugadores = null;
        String sql = "SELECT * FROM " + TABLA + " ORDER BY rojas DESC LIMIT 10";
        listaJugadores = obtenerJugadores(sql);
        return listaJugadores;
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Jugadores
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws PersistenciaException controlado
     */
    public ArrayList<Jugador> obtenerJugadores(String sql) throws PersistenciaException {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            resultSet = persistencia.buscarElementos(sql);
            while (resultSet.next()) {
                int identificador = resultSet.getInt("idJugador");
                String equipo = resultSet.getString("equipo");
                String nombre = resultSet.getString("nombre");
                int dorsal = resultSet.getInt("dorsal");
                int goles = resultSet.getInt("goles");
                int asistencias = resultSet.getInt("asistencias");
                int amarillas = resultSet.getInt("amarillas");
                int rojas = resultSet.getInt("rojas");
                jugador = new Jugador(identificador, equipo, nombre, dorsal, goles, asistencias, amarillas, rojas);
                listaJugadores.add(jugador);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(ERROR_CONSULTA, exception);
        } finally {
            persistencia.closeConnection(null, null, resultSet);
        }
        return listaJugadores;
    }
}