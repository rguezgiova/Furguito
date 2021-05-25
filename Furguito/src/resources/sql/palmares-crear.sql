CREATE TABLE IF NOT EXISTS 'Palmares' (
    'idPalmares' INTEGER PRIMARY KEY,
    'equipo' varchar(50) NOT NULL,
    'ligas' int(2),
    'copasDelRey' int(2),
    'superEspana' int(2), 
    'superEuropa' int(2),
    'champions' int(2),
    'mundialClubs' int(2)
);