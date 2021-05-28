package es.iespuertolacruz.furguito.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import es.iespuertolacruz.furguito.api.Equipo;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class EquipoModelo {
    Equipo equipo;
    SqliteBbdd persistencia;
    private static final String ERROR_CONSULTA = "Se ha producido un error en la transformacion ";
    private static final String TABLA = "Equipos";
    private static final String CLAVE = "idEquipo";
    private static final String SQLTABLE = "src/resources/sql/equipos-crear.sql";
    private static final String SQLINSERT = "src/resources/sql/equipos-insert.sql";

    public EquipoModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null, SQLTABLE, SQLINSERT);
    }

    /**
     * Metodo que se encarga de la insercion de un equipo en la BBDD
     * 
     * @param equipo a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertar(Equipo equipo) throws PersistenciaException {
        String sql = "";
        sql = "INSERT INTO " + TABLA + " ("+ CLAVE + ", nombre, ciudad, estadio, fundacion, numero_socios, presupuesto, colores) VALUES("
                + equipo.getId() + ", '" + equipo.getNombre() + "', '" + equipo.getEstadio() + "', " + equipo.getFundacion() + ", "
                + equipo.getNumeroSocios() + ", " + equipo.getPresupuesto() + ", '" + equipo.getColores() + "')";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo para borrar un equipo de la BBDD
     * 
     * @param equipo a borrar
     * @throws PersistenciaException error controlado
     */
    public void eliminar(int id) throws PersistenciaException {
        String sql = "";
        sql = "DELETE FROM " + TABLA + " WHERE "+ CLAVE + " = " + id;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo para modificar un equipo dentro de la BBDD
     * 
     * @param equipo a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificar(Equipo equipo) throws PersistenciaException {
        String sql = "";
        sql = "UPDATE " + TABLA + " SET nombre = '" + equipo.getNombre() + "'" + ", ciudad = '" + equipo.getCiudad() + "'"
                + ", estadio = '" + equipo.getEstadio() + "'" + ", fundacion = " + equipo.getFundacion()
                + ", numero_socios = " + equipo.getNumeroSocios() + ", presupuesto = " + equipo.getPresupuesto()
                + ", colores = '" + equipo.getColores() + "' WHERE " + CLAVE + " = " + equipo.getId();
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que obtiene un equipo buscado por nombre
     * 
     * @param nombre del equipo a buscar
     * @return equipo
     * @throws PersistenciaException error controlado
     */
    public Equipo obtenerEquipo(String nombre) throws PersistenciaException {
        Equipo equipo = null;
        ArrayList<Equipo> listaEquipos = null;
        String sql = "SELECT * FROM " + TABLA + " where nombre LIKE '%" + nombre + "%'";
        listaEquipos = obtenerEquipos(sql);
        if (!listaEquipos.isEmpty()) {
            equipo = listaEquipos.get(0);
        }
        return equipo;
    }

    /**
     * Funcion que obtiene el nombre y la ciudad en la que juega el equipo buscado
     * 
     * @param nombre del equipo
     * @return nombre del equipo y ciudad
     * @throws PersistenciaException error controlado
     */
    public Equipo consultarCiudad(String nombre) throws PersistenciaException {
        Equipo equipo = null;
        ArrayList<Equipo> listaEquipos = null;
        String sql = "SELECT * FROM Equipos where nombre LIKE '%" + nombre + "%'";
        listaEquipos = obtenerEquipos(sql);
        if (!listaEquipos.isEmpty()) {
            equipo = listaEquipos.get(0);
        }
        return equipo;
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Equipos
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws PersistenciaException error controlado
     */
    private ArrayList<Equipo> obtenerEquipos(String sql) throws PersistenciaException {
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            resultSet = persistencia.buscarElementos(sql);
            while (resultSet.next()) {
                int identificador = resultSet.getInt("idEquipo");
                String nombre = resultSet.getString("nombre");
                String ciudad = resultSet.getString("ciudad");
                String estadio = resultSet.getString("estadio");
                int fundacion = resultSet.getInt("fundacion");
                int numeroSocios = resultSet.getInt("numero_socios");
                int presupuesto = resultSet.getInt("presupuesto");
                String colores = resultSet.getString("colores");
                equipo = new Equipo(identificador, nombre, ciudad, estadio, fundacion, numeroSocios, presupuesto,
                        colores);
                listaEquipos.add(equipo);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(ERROR_CONSULTA, exception);
        } finally {
            persistencia.closeConnection(null, null, resultSet);
        }
        return listaEquipos;
    }
}