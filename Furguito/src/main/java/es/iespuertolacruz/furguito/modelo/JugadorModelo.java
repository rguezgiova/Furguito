package es.iespuertolacruz.furguito.modelo;

import es.iespuertolacruz.furguito.api.Jugador;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class JugadorModelo {
    MysqlBbdd persistencia;

    public JugadorModelo() {
        persistencia = new MysqlBbdd("org.sqlite.JDBC", "jdbc:sqlite:furguito.db", null, null);
    }
    
    public void insertarJugador(Jugador jugador) throws PersistenciaException {
        persistencia.insertarJugador(jugador);
    }

    public void modificarJugador(Jugador jugador) throws PersistenciaException {
        persistencia.modificarJugador(jugador);
    }

    public void eliminarJugador(Jugador jugador) throws PersistenciaException {
        persistencia.borrarJugador(jugador);
    }

    public void consultarInformacion() {

    }

    public void consultarMaximoGoleador() {
        
    }

    public void consultarMasExpulsado() {

    }
}