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