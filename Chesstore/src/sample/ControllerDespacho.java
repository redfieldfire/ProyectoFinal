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
import sample.Estructuras.AjedrezPersonalizado;
import sample.Estructuras.Factura;


import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class ControllerDespacho {

    @FXML Text lblUsuario;
    @FXML TableView tabla;

    @FXML Text lbltableros, lblcosto;

    @FXML Button factura,fabrica;

    int suma = 0;
    String costo = "";

    TableColumn colpiezas =  new TableColumn("Piezas");
    TableColumn coltablero =  new TableColumn("Tablero");
    TableColumn colpeso =  new TableColumn("Peso");
    TableColumn coltrama =  new TableColumn("Trama");
    TableColumn coltipo =  new TableColumn("Tipo");
    TableColumn colnombre =  new TableColumn("Cliente");
    TableColumn coltarjeta =  new TableColumn("Numero de tarjeta");
    TableColumn colprecio =  new TableColumn("Precio");

    public static ObservableList<AjedrezPersonalizado> list = FXCollections.observableArrayList();
    public static Queue<Factura> cola = new LinkedList<>();

    String styleFuera = "-fx-background-color: #333365; -fx-border-color: WHITE; -fx-text-fill: WHITE";
    String styleDentro = "-fx-background-color: WHITE; -fx-border-color: #333365; -fx-text-fill: #333365;";

    @FXML
    public void initialize(){
        lblUsuario.setText(ControllerMain.nombre);

        colpiezas.setCellValueFactory(new PropertyValueFactory<AjedrezPersonalizado,String>("piezas"));
        coltablero.setCellValueFactory(new PropertyValueFactory<AjedrezPersonalizado,String>("tablero"));
        colpeso.setCellValueFactory(new PropertyValueFactory<AjedrezPersonalizado,String>("peso"));
        coltrama.setCellValueFactory(new PropertyValueFactory<AjedrezPersonalizado,String>("trama"));
        coltipo.setCellValueFactory(new PropertyValueFactory<AjedrezPersonalizado,String>("tipo"));
        colnombre.setCellValueFactory(new PropertyValueFactory<AjedrezPersonalizado,String>("nombre"));
        coltarjeta.setCellValueFactory(new PropertyValueFactory<AjedrezPersonalizado,String>("tarjeta"));
        colprecio.setCellValueFactory(new PropertyValueFactory<AjedrezPersonalizado,String>("costo"));

        tabla.getColumns().addAll(colpiezas,coltablero,colpeso,coltrama,coltipo,colprecio,colnombre,coltarjeta);
        tabla.setItems(list);

        ControllerFabrica.list.add(new Factura("300","3","Robert"));
        ControllerFabrica.list.add(new Factura("300","200","Robert"));
        ControllerFabrica.list.add(new Factura("300","1","Robert"));

        cola.add(new Factura("300","3","Robert"));
        cola.add(new Factura("300","200","Robert"));
        cola.add(new Factura("300","1","Robert"));

        list.add(new AjedrezPersonalizado("Piedra","Piedra","4Kg","Normal","Stauton","Bonds","56415","$7000"));
        list.add(new AjedrezPersonalizado("Piedra","Piedra","4Kg","Normal","Stauton","Bonds","56415","$7000"));
        list.add(new AjedrezPersonalizado("Piedra","Piedra","4Kg","Normal","Stauton","Bonds","56415","$7000"));
        list.add(new AjedrezPersonalizado("Piedra","Piedra","4Kg","Normal","Stauton","Bonds","56415","$7000"));
        list.add(new AjedrezPersonalizado("Piedra","Piedra","4Kg","Normal","Stauton","Bonds","56415","$7000"));
        list.add(new AjedrezPersonalizado("Piedra","Piedra","4Kg","Normal","Stauton","Bonds","56415","$7000"));
        list.add(new AjedrezPersonalizado("Piedra","Piedra","4Kg","Normal","Stauton","Bonds","56415","$7000"));

    }

    public void volver(){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("PantallaMain.fxml"));
            Main.stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void crearFactura(){

        if(list.size() > 0){

            suma = 0;

            costo = "";

            for(int x = 0 ; x < list.size(); x++){

                for(int y = 0 ; y < list.get(x).getCosto().length() ; y++){
                    if(list.get(x).getCosto().charAt(y) == '.') break;
                    if(list.get(x).getCosto().charAt(y) != '$'){
                        costo = costo + list.get(x).getCosto().charAt(y);
                    }
                }

                suma = suma + Integer.parseInt(costo);

                costo = "";

            }

            cola.add(new Factura(suma+"",(list.size()+1)+"",lblUsuario.getText()));
            ControllerFabrica.list.add(new Factura(suma+"",(list.size()+1)+"",lblUsuario.getText()));

            lblcosto.setText("Costo $" + suma + ".00");
            lbltableros.setText("#Tableros " + (list.size()+1));

            list.clear();

        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Chesstore");
            alert.setContentText("No hay ningun pedido");
            alert.show();
        }

    }

    public void irFabrica(){

        if(ControllerFabrica.list.size() > 0){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("PantallaFabrica.fxml"));
                Main.stage.setScene(new Scene(root));
            } catch (IOException e) {
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Chesstore");
                alert.setContentText("No hay pedidos en la fabrica");
                alert.show();
            }
        }
        else{
            Alert alert =  new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Chesstore");
            alert.setContentText("No hay pedidos en la fabrica");
            alert.show();
        }

    }

    public void entrarFabrica(){fabrica.setStyle(styleDentro);}
    public void salirFabrica(){fabrica.setStyle(styleFuera);}

    public void entrarFactura(){factura.setStyle(styleDentro);}
    public void salirFactura(){factura.setStyle(styleFuera);}


}
