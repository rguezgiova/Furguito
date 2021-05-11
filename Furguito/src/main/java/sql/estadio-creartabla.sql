
CREATE TABLE IF NOT EXISTS 'Estadios' (
    'idEstadio' int(2) PRIMARY KEY NOT NULL,
    'nombre' varchar(50) NOT NULL,
    'equipo' varchar(50) NOT NULL,
    'capacidad' int(6) DEFAULT 0, 
    'construccion' int(4) DEFAULT 0
)
