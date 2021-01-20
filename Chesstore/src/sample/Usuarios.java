package sample;

import javafx.beans.property.SimpleStringProperty;

public class Usuarios {

  SimpleStringProperty usuario;
  SimpleStringProperty contraseña;

    public Usuarios(String usuario, String contraseña){
        this.usuario = new SimpleStringProperty(usuario);
        this.contraseña = new SimpleStringProperty(contraseña);
    }

    public String getUsuario() {
        return usuario.get();
    }

    public SimpleStringProperty usuarioProperty() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario.set(usuario);
    }

    public String getContraseña() {
        return contraseña.get();
    }

    public SimpleStringProperty contraseñaProperty() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña.set(contraseña);
    }
}
