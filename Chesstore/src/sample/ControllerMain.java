package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;


public class ControllerMain {

    @FXML TextField txtUsuario;
    @FXML PasswordField txtPassword;
    @FXML Text txtRegistrarse,play;

    @FXML Button acceder;
    @FXML Button cliente;

    String styleFuera = "-fx-background-color: #151925; -fx-text-fill: WHITE;";
    String styleDentro = "-fx-background-color: WHITE; -fx-text-fill: #151925;";

    public static String nombre;

    Boolean posible = false;

    public void accederAction(){
        acceder();
    }//acceder

    public void clickAcceder(KeyEvent event){

        if(event.getCode() == KeyCode.ENTER) acceder();

    }

    public void accederEntrar(){

            acceder.setStyle(styleDentro);

    }//entrar

    public void accederSalir(){

            acceder.setStyle(styleFuera);

    }//salir

    public void clienteAction(){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("PantallaPersonalizar.fxml"));
            Main.stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//cliente

    public void clienteEntrar(){

        cliente.setStyle(styleDentro);

    }//entrar

    public void clienteSalir(){

        cliente.setStyle(styleFuera);

    }//salir

    public void acceder(){

        posible = false;

        if(txtUsuario.getText().equals("") || txtPassword.getText().equals("")){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Chesstore");
            alert.setContentText("Hay campos vacios");
            alert.show();

        }

            for(int x = 0; x < ControllerRegistro.linkedList.size(); x++){
                if(ControllerRegistro.linkedList.get(x).getUsuario().equals(txtUsuario.getText()) && ControllerRegistro.linkedList.get(x).getContraseña().equals(txtPassword.getText())) posible = true;
            }
            if(posible == true) {
                try {
                    nombre = txtUsuario.getText();
                    Parent root = FXMLLoader.load(getClass().getResource("PantallaDespacho.fxml"));
                    Main.stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Chesstore");
                alert.setContentText("El usuario o contraseña con incorrectos");
                alert.show();
            }

    }

    public void cerrar(){
        System.exit(0);
    }

    public void irRegistro(){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("PantallaRegistro.fxml"));
            Main.stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void registrarseEntrar(){
        txtRegistrarse.setFill(Color.BLUE);
    }

    public void resgistrarseSalir(){
        txtRegistrarse.setFill(Color.WHITE);
    }

    public void jugar(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AjedrezJuego.fxml"));
            Main.stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void salirJugar(){play.setFill(Color.WHITE);}
    public void entrarJugar(){play.setFill(Color.BLUEVIOLET);}

}//controller
