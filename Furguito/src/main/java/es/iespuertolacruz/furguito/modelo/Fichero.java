package es.iespuertolacruz.furguito.modelo;

import java.io.File;
import java.util.Scanner;

import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class Fichero {

    /**
     * Funcion que verifica si un fichero existe
     * @param fichero a verificar
     * @return true/false segun exista el fichero
     */
    public boolean validar(File fichero) {
        return fichero.exists();
    }

    /**
     * Funcion encargada de leer un fichero
     * @param nombre del fichero a leer
     * @throws PersistenciaException error controlado
     */
    public String leer(String nombre) throws PersistenciaException {
        StringBuilder informacion = null;
        File fichero = null;
        Scanner scanner = null;

        try {
            fichero = new File(nombre);
            if (!validar(fichero)) {
                throw new PersistenciaException("El fichero a leer no existe");
            }
            informacion = new StringBuilder();
            scanner = new Scanner(fichero);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                informacion.append(linea + "\n");
            }
        } catch (PersistenciaException exception) {
            throw exception;
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error en la lectura del fichero", exception);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return informacion.toString();
    }
}