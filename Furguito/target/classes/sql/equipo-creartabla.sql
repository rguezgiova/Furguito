CREATE TABLE IF NOT EXISTS 'Equipos' (
    'idEquipo' int(2) PRIMARY KEY NOT NULL,
    'nombre' varchar(50) NOT NULL,
    'ciudad' varchar(50) NOT NULL,
    'estadio' varchar(50) NOT NULL,
    'fundacion' int(4), 
    'numero_socios' int(8) DEFAULT 0,
    'presupuesto' int(10),
    'colores' varchar(50) NOT NULL
)

