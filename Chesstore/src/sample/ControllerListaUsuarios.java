package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Stack;

public class ControllerListaUsuarios {

    @FXML TableView tabla;
    @FXML Text usuarioBorrado;
    @FXML Button borrar;

    public static Stack<Usuarios> pila = new Stack<>();
    public static ObservableList<Usuarios> list = FXCollections.observableArrayList();

    TableColumn colUsuario = new TableColumn("Usuario");
    TableColumn colContraseña = new TableColumn("Contraseña");

    String styleFuera = "-fx-background-color: #d0d0d0; -fx-border-color: BLACK; -fx-text-fill: BLACK;";
    String styleDentro = "-fx-background-color: BLACK; -fx-border-color: #d0d0d0; -fx-text-fill: #d0d0d0;";

    @FXML
    public void initialize(){

        colUsuario.setCellValueFactory(new PropertyValueFactory<Usuarios,String>("usuario"));
        colContraseña.setCellValueFactory(new PropertyValueFactory<Usuarios,String>("contraseña"));

        tabla.getColumns().addAll(colUsuario,colContraseña);

        tabla.setItems(list);

    }

    public void salirBorrar(){borrar.setStyle(styleFuera);}
    public void entrarBorrar(){borrar.setStyle(styleDentro);}
    public void borrarUsuario(){

        if(list.size() > 1) {
            Usuarios usuario = pila.pop();
            usuarioBorrado.setText(usuario.getUsuario());
            list.remove(list.size() - 1);
            ControllerRegistro.linkedList.remove(ControllerRegistro.linkedList.size()-1);
        }
        else if(list.size() == 1){
            pila.pop();
            list.remove(list.size() - 1);
            ControllerRegistro.linkedList.remove(ControllerRegistro.linkedList.size()-1);

            try {
                Parent root4 = FXMLLoader.load(getClass().getResource("PantallaRegistro.fxml"));
                Main.stage.setScene(new Scene(root4));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Chesstore");
            alert.setContentText("Se eliminaron todos los usuarios");
            alert.show();

        }

    }

    public void volver1(){
        try {
            Parent root3 = FXMLLoader.load(getClass().getResource("PantallaRegistro.fxml"));
            Main.stage.setScene(new Scene(root3));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
