package es.iespuertolacruz.furguito.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import es.iespuertolacruz.furguito.api.Palmares;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class PalmaresModelo {
    SqliteBbdd persistencia;
    Palmares palmares;
    private static final String ERROR_CONSULTA = "Se ha producido un error en la transformacion ";
    private static final String TABLA = "Palmares";
    private static final String CLAVE = "idPalmares";
    private static final String SQLTABLE = "src/resources/sql/palmares-crear.sql";
    private static final String SQLINSERT = "src/resources/sql/palmares-insertar.sql";

    public PalmaresModelo() throws PersistenciaException {
        persistencia = new SqliteBbdd(TABLA, CLAVE, null, null, SQLTABLE, SQLINSERT);
    }

    /**
     * Metodo que se encarga de la insercion del palmares de un equipo en la BBDD
     * 
     * @param palmares a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertar(Palmares palmares) throws PersistenciaException {
        String sql = "";
        sql = "INSERT INTO " + TABLA + " (" + CLAVE
                + ", equipo, ligas, copasDelRey, superEspana, SuperEuropa, champions, mundialClubs) VALUES("
                + palmares.getId() + ", '" + palmares.getEquipo() + "', " + palmares.getLigas() + ", "
                + palmares.getCopasDelRey() + ", " + palmares.getSuperEspana() + ", " + palmares.getSuperEuropa() + ", "
                + palmares.getChampions() + ", " + palmares.getMundialClubs() + ")";
        persistencia.actualizar(sql);
    }

    /**
     * Metodo para borrar un palmares de la BBDD
     * 
     * @param palmares a borrar
     * @throws PersistenciaException error controlado
     */
    public void eliminar(int id) throws PersistenciaException {
        String sql = "";
        sql = "DELETE FROM " + TABLA + " WHERE " + CLAVE + " = " + id;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo para modificar el palmares de un equipo dentro de la BBDD
     * 
     * @param palmares a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificar(Palmares palmares) throws PersistenciaException {
        String sql = "";
        sql = "UPDATE " + TABLA + " SET equipo = '" + palmares.getEquipo() + "'" + ", ligas = " + palmares.getLigas()
                + "" + ", copasDelRey = " + palmares.getCopasDelRey() + "" + ", superEspana = "
                + palmares.getSuperEspana() + ", superEuropa = " + palmares.getSuperEuropa() + ", champions = "
                + palmares.getChampions() + ", mundialClubs = " + palmares.getMundialClubs() + " WHERE " + CLAVE + " = "
                + palmares.getId();
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que obtiene el palmares del equipo buscado
     * 
     * @param equipo  nombre del equipo
     * @param equipo2 TODO
     * @return palmares completo del equipo
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Palmares> palmaresEquipo(String equipo) throws PersistenciaException {
        Palmares palmares = null;
        ArrayList<Palmares> listaPalmares = null;
        String sql = "SELECT * FROM " + TABLA + " WHERE nombre LIKE '%" + equipo + "%'";
        listaPalmares = obtenerPalmares(sql);
        if (!listaPalmares.isEmpty()) {
            palmares = listaPalmares.get(0);
        }
        return listaPalmares;
    }

    /**
     * Funcion que devuelve los 3 equipos con mas ligas
     * 
     * @return lista de equipos
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Palmares> palmaresLigas() throws PersistenciaException {
        ArrayList<Palmares> listaLigas = null;
        String sql = "SELECT * FROM " + TABLA + " ORDER BY ligas DESC LIMIT 3";
        listaLigas = obtenerPalmares(sql);
        return listaLigas;
    }

    /**
     * Funcion que devuelve los 3 equipos con mas copas del rey
     * 
     * @return lista de equipos
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Palmares> palmaresCopas() throws PersistenciaException {
        ArrayList<Palmares> listaCopas = null;
        String sql = "SELECT * FROM " + TABLA + " ORDER BY copasDelRey DESC LIMIT 3";
        listaCopas = obtenerPalmares(sql);
        return listaCopas;
    }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Palmares
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws PersistenciaException controlado
     */
    public ArrayList<Palmares> obtenerPalmares(String sql) throws PersistenciaException {
        ArrayList<Palmares> listaPalmares = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            resultSet = persistencia.buscarElementos(sql);
            while (resultSet.next()) {
                int identificador = resultSet.getInt("idPalmares");
                String equipo = resultSet.getString("equipo");
                int ligas = resultSet.getInt("ligas");
                int copasDelRey = resultSet.getInt("copasDelRey");
                int superEspana = resultSet.getInt("SuperEspana");
                int superEuropa = resultSet.getInt("SuperEuropa");
                int champions = resultSet.getInt("champions");
                int mundialClubs = resultSet.getInt("mundialClubs");
                palmares = new Palmares(identificador, equipo, ligas, copasDelRey, superEspana, superEuropa, champions,
                        mundialClubs);
                listaPalmares.add(palmares);
            }
        } catch (Exception exception) {
            throw new PersistenciaException(ERROR_CONSULTA, exception);
        } finally {
            persistencia.closeConnection(null, null, resultSet);
        }
        return listaPalmares;
    }
}