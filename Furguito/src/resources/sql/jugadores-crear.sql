CREATE TABLE IF NOT EXISTS 'Jugadores' (
    'idJugador' INTEGER PRIMARY KEY,
    'equipo' varchar(50) NOT NULL,
    'nombre' varchar(50) NOT NULL,
    'dorsal' int(2) NOT NULL,
    'goles' int(2) DEFAULT 0, 
    'asistencias' int(2) DEFAULT 0,
    'amarillas' int(2) DEFAULT 0,
    'rojas' int(2) DEFAULT 0
);
