CREATE TABLE IF NOT EXISTS 'Equipos' (
    'idEquipo' int(2) IDENTITY(1,1) PRIMARY KEY NOT NULL,
    'nombre' varchar(50) NOT NULL,
    'ciudad' varchar(50) NOT NULL,
    'estadio' varchar(50) NOT NULL,
    'fundacion' int(4), 
    'numero_socios' int(8) DEFAULT 0,
    'presupuesto' int(10),
    'colores' varchar(50) NOT NULL
)

CREATE TABLE IF NOT EXISTS 'Estadios' (
    'idEstadio' int(2) IDENTITY(1,1) PRIMARY KEY NOT NULL,
    'nombre' varchar(50) NOT NULL,
    'equipo' varchar(50) NOT NULL,
    'capacidad' int(6) DEFAULT 0, 
    'construccion' int(4) DEFAULT 0
)

CREATE TABLE IF NOT EXISTS 'Palmares' (
    'idPalmares' int(2) IDENTITY(1,1) PRIMARY KEY NOT NULL,
    'equipo' varchar(50) NOT NULL,
    'ligas' int(2),
    'copasDelRey' int(2),
    'superEspana' int(2), 
    'superEuropa' int(2),
    'champions' int(2),
    'mundialClubs' int(2)
)

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
