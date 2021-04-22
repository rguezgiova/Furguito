package es.iespuertolacruz.furguito.exception;

public class PlantillaException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor con mensaje personalizado
     * 
     * @param mensaje personalizado
     */
    public PlantillaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y la excepcion que se produce
     * 
     * @param mensaje   mensaje de la excepcion
     * @param exception que produce el error
     */
    public PlantillaException(String mensaje, Exception exception) {
        super(mensaje, exception);
    }

}
