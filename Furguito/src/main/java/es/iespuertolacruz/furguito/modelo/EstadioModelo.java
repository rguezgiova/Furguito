package es.iespuertolacruz.furguito.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import es.iespuertolacruz.furguito.api.Estadio;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class EstadioModelo {
    Estadio estadio;
    SqliteBbdd persistencia;
    private static final String ERROR_CONSULTA = "Se ha producido un error en la transformacion ";
    private static final String TABLA = "Estadios";
    private static final String CLAVE = "idEstadio";
    private static final String SQLTABLE = "src/resources/sql/estadios-crear.sql";
    private static final String SQLINSERT = "src/resources/sql/estadios-insertar.sql";

    public EstadioModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null, SQLTABLE, SQLINSERT);
    }

    /**
     * Metodo que se encarga de la insercion de un equipo en la BBDD
     * 
     * @param estadio a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertar(Estadio estadio) throws PersistenciaException {
        String sql = "";
        sql = "INSERT INTO " + TABLA + " (" + CLAVE + ", nombre, equipo, capacidad, construccion) VALUES("
                + estadio.getId() + ", '" + estadio.getNombre() + "', '" + estadio.getEquipo() + "', '"
                + estadio.getCapacidad() + "', '" + estadio.getConstruccion() + "')";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo para borrar un estadio de la BBDD
     * 
     * @param estadio a borrar
     * @throws PersistenciaException error controlado
     */
    public void eliminar(int id) throws PersistenciaException {
        String sql = "";
        sql = "DELETE FROM " + TABLA + " WHERE " + CLAVE + " = " + id;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo para modificar un estadio dentro de la BBDD
     * 
     * @param estadio a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificar(Estadio estadio) throws PersistenciaException {
        String sql = "";
        sql = "UPDATE " + TABLA + " SET nombre = '" + estadio.getNombre() + "'" + ", equipo = '" + estadio.getEquipo()
                + "'" + ", capacidad = " + estadio.getCapacidad() + "" + ", construccion = " + estadio.getConstruccion()
                + " WHERE " + CLAVE + " = " + estadio.getId();
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que obtiene un estadio buscado por ID
     * 
     * @param nombre del estadio a buscar
     * @return equipo
     * @throws PersistenciaException error controlado
     */
    public Estadio obtenerEstadio(String nombre) throws PersistenciaException {
        Estadio estadio = null;
        ArrayList<Estadio> listaEstadios = null;
        String sql = "SELECT * FROM " + TABLA + " where nombre = '" + nombre + "'";
        listaEstadios = obtenerEstadios(sql);
        if (!listaEstadios.isEmpty()) {
            estadio = listaEstadios.get(0);
        }
        return estadio;
    }

    /**
     * Funcion que obtiene el nombre y la capacidad del estadio buscado
     * 
     * @param nombre del estadio a buscar
     * @return estadio y capacidad
     * @throws PersistenciaException error controlado
     */
    public Estadio obtenerCapacidad(String nombre) throws PersistenciaException {
        Estadio estadio = null;
        ArrayList<Estadio> listaEstadios = null;
        String sql = "SELECT * FROM " + TABLA + " where nombre = '" + nombre + "'";
        listaEstadios = obtenerEstadios(sql);
        if (!listaEstadios.isEmpty()) {
            estadio = listaEstadios.get(0);
        }
        return estadio;
    }

    /**
     * Funcion que obtiene el nombre y el anio del estadio buscado
     * 
     * @param nombre del estadio a buscar
     * @return estadio y anio
     * @throws PersistenciaException error controlado
     */
    public Estadio obtenerAnio(String nombre) throws PersistenciaException {
        Estadio estadio = null;
        ArrayList<Estadio> listaEstadios = null;
        String sql = "SELECT * FROM " + TABLA + " where nombre = '" + nombre + "'";
        listaEstadios = obtenerEstadios(sql);
        if (!listaEstadios.isEmpty()) {
            estadio = listaEstadios.get(0);
        }
        return estadio;
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Estadios
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws PersistenciaException controlado
     */
    private ArrayList<Estadio> obtenerEstadios(String sql) throws PersistenciaException {
        ArrayList<Estadio> listaEstadios = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            resultSet = persistencia.buscarElementos(sql);
            while (resultSet.next()) {
                int identificador = resultSet.getInt("idEstadio");
                String nombre = resultSet.getString("nombre");
                String equipo = resultSet.getString("equipo");
                int capacidad = resultSet.getInt("capacidad");
                int construccion = resultSet.getInt("construccion");
                estadio = new Estadio(identificador, nombre, equipo, capacidad, construccion);
                listaEstadios.add(estadio);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(ERROR_CONSULTA, exception);
        } finally {
            persistencia.closeConnection(null, null, resultSet);
        }
        return listaEstadios;
    }
}