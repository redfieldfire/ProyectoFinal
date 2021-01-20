package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.LinkedList;

public class ControllerRegistro {

    @FXML TextField txtUsuario;
    @FXML TextField txtContrasenia1;
    @FXML TextField txtContrasenia2;

    @FXML Button btnRegistrar;

    String styleFuera = "-fx-background-color: #333365; -fx-text-fill: WHITE; -fx-border-color: WHITE;";
    String styleDentro = "-fx-background-color: WHITE; -fx-text-fill: #333365; -fx-border-color: #333365";

    public static LinkedList<Usuarios> linkedList = new LinkedList<>();

    Boolean posible = true;


    public void inicio(){

        try {
            Parent root6 = FXMLLoader.load(getClass().getResource("PantallaMain.fxml"));
            Main.stage.setScene(new Scene(root6));
        } catch (IOException e2) {
            e2.printStackTrace();
        }


    }

    public void registrar(){

        ingresar();

    }

    public void enter(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER) ingresar();
    }

    public void registrarFuera(){

        btnRegistrar.setStyle(styleFuera);

    }

    public void registrarDentro(){

        btnRegistrar.setStyle(styleDentro);

    }

    public void irALaLista(){
        if(linkedList.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Chesstore");
            alert.setContentText("No hay ningun usuario registrado");
            alert.show();
        }
        else {
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("PantallaListaUsuarios.fxml"));
                Main.stage.setScene(new Scene(root1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//else
    }

    public void ingresar(){

        posible = true;

        if(txtUsuario.getText().equals("") || txtContrasenia1.getText().equals("") || txtContrasenia2.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Chesstore");
            alert.setContentText("Hay campos vacios");
            alert.show();
        }

        for(int x = 0 ; x < linkedList.size(); x++){
            if(txtUsuario.getText().equals(linkedList.get(x).getUsuario())){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Chesstore");
                alert.setContentText("El usuario que insertarste ya esta en uso");
                alert.show();
                posible = false;

                break;
            }
        }

        if(txtContrasenia1.getText().equals(txtContrasenia2.getText())){
            if(posible == true){
                linkedList.add(new Usuarios(txtUsuario.getText(),txtContrasenia1.getText()));
                ControllerListaUsuarios.pila.add(new Usuarios(txtUsuario.getText(),txtContrasenia1.getText()));
                ControllerListaUsuarios.list.add(new Usuarios(txtUsuario.getText(),txtContrasenia1.getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Chesstore");
                alert.setContentText("Usuario ingresado correctamente!");
                alert.show();
            }
        }
        else{

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Chesstore");
            alert.setContentText("Las contraseñas no son iguales");
            alert.show();

        }


    }


}
