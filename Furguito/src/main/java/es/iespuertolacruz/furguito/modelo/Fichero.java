package es.iespuertolacruz.furguito.modelo;

import java.io.File;
import java.util.Scanner;

import es.iespuertolacruz.furguito.exception.FicheroException;
import es.iespuertolacruz.furguito.exception.PersistenciaException;

public class Fichero {

    /**
     * Funcion que verifica si el fichero existe
     * 
     * @param fichero
     * @return true o false
     */
    public boolean validar(File fichero) {
        return fichero.exists();
    }

    /**
     * Funcion encargada de leer un ficher
     * 
     * @param nombre nombre del fichero a leer
     * @throws FicheroException Error controlado en la lectura del fichero
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
        } catch (PersistenciaException e) {
            throw e;
        } catch (Exception e) {
            throw new PersistenciaException("Se ha producido un error en la lectura del fichero", e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return informacion.toString();
    }
}