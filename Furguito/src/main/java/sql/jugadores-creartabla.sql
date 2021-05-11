CREATE TABLE IF NOT EXISTS 'Jugadores' (
    'idJugador' int(2) IDENTITY(1,1) PRIMARY KEY NOT NULL,
    'equipo' varchar(50) NOT NULL,
    'nombre' varchar(50) NOT NULL,
    'dorsal' int(2) NOT NULL,
    'goles' int(2) DEFAULT 0, 
    'asistencias' int(2) DEFAULT 0,
    'amarillas' int(2) DEFAULT 0,
    'rojas' int(2) DEFAULT 0
)
