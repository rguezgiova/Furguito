package es.iespuertolacruz.furguito.validaciones;

public class ValidarUsuario {
    private String usuario;
    private String password;
    private String usuarioAlmancenado = "admin";
    private String passwordAlmancenado = "admin";

    public String getUsuario() {
        return this.usuario;
    }
  
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
  
     public String getPassword() {
        return this.password;
    }
  
     public void setPassword(String password) {
        this.password = password;
    }

   /**
    * Funcion encargada de realizar la validacion del usuario 
    * @param usuario a validar
    * @param password validar
    * @return true/false segun sea correcta o no la validacion
    */
   public boolean validar() {
       if (usuarioAlmancenado.equals(this.usuario) && passwordAlmancenado.equals(this.password))
         return true;
       else
         return false;
   }
}