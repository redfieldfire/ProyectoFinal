package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import sample.Estructuras.Factura;

import javax.swing.*;
import java.io.IOException;


public class ControllerFabrica {

    @FXML TableView tabla;
    @FXML Button btnFabricar;
    @FXML Text ultimoPedido;
    @FXML ComboBox comboTodo;

    TableColumn colCosto = new TableColumn("Costo");
    TableColumn colCantidad = new TableColumn("Cantidad de tableros");
    TableColumn colEmpleado = new TableColumn("Empleado");

    String styleFuera = "-fx-border-color: WHITE; -fx-background-color: BLACK; -fx-text-fill: WHITE;";
    String styleDentro = "-fx-border-color: BLACK; -fx-background-color: WHITE; -fx-text-fill: BLACK";

    public static ObservableList<Factura> list = FXCollections.observableArrayList();
    boolean ordenado = false;

    @FXML
    public void initialize(){

        colCosto.setCellValueFactory(new PropertyValueFactory<Factura,String>("costo"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<Factura,String>("cantidad"));
        colEmpleado.setCellValueFactory(new PropertyValueFactory<Factura,String>("empleado"));

        tabla.getColumns().addAll(colEmpleado,colCantidad,colCosto);

        tabla.setItems(list);

        //ultimoPedido.setText(list.get(list.size()-1).getCantidad() + " Ajedrez(es) con un costo $" + list.get(list.size()-1).getCosto() + ".00");

        comboTodo.getItems().addAll("Ordenar cantidad por burbuja","Ordenar cantidad por inserción","Busqueda de cantidad por binario");
        ordenado = false;

    }

    public void entrar(){

        btnFabricar.setStyle(styleDentro);

    }
    public void salir(){

        btnFabricar.setStyle(styleFuera);

    }
    public void fabricar(){

        if(list.size() > 1) {

           fabricarUltimo();

        }
        else if (list.size() == 1){

            fabricarUltimo();

            volver();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Chesstore");
            alert.setContentText("Se terminaron los pedidos");
            alert.show();

        }
    }

    public void volver(){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("PantallaDespacho.fxml"));
            Main.stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void fabricarUltimo(){

        Factura factura = ControllerDespacho.cola.poll();
        list.remove(0);

        ultimoPedido.setText(factura.getCantidad()+ " Ajedrez(es) con un costo $" + factura.getCosto() + ".00");

    }

    int sig = 0 , pos = 0;
    String costo,empleado,cantidad;

    public void ordenYBusqueda(){

        switch(comboTodo.getSelectionModel().getSelectedIndex()){

            case 0:

                for(int x = 0 ; x < list.size() - 1; x++){
                for(int y = 0 ; y < list.size() - 1; y++){

                    sig = y+1;

                    if(Integer.parseInt(list.get(y).getCantidad()) > Integer.parseInt(list.get(sig).getCantidad())){

                        cantidad = list.get(y).getCantidad();
                        costo = list.get(y).getCosto();
                        empleado = list.get(y).getEmpleado();

                        list.get(y).setCantidad(list.get(sig).getCantidad());
                        list.get(y).setEmpleado(list.get(sig).getEmpleado());
                        list.get(y).setCosto(list.get(sig).getCosto());

                        list.get(sig).setCantidad(cantidad);
                        list.get(sig).setEmpleado(empleado);
                        list.get(sig).setCosto(costo);

                    }
                }
            }

                ControllerDespacho.cola.clear();
                ControllerDespacho.cola.addAll(list);

                ordenado = true;

                comboTodo.getSelectionModel().clearSelection();

                break;

            case 1:

                for(int i = 0; i < list.size(); i++){

                    pos = i;

                    cantidad = list.get(i).getCantidad();
                    costo = list.get(i).getCosto();
                    empleado = list.get(i).getEmpleado();

                        while( (pos > 0) && (Integer.parseInt(list.get(pos-1).getCantidad()) > Integer.parseInt(cantidad))){

                            list.get(pos).setCosto(list.get(pos-1).getCosto());
                            list.get(pos).setCantidad(list.get(pos-1).getCantidad());
                            list.get(pos).setEmpleado(list.get(pos-1).getEmpleado());

                            pos--;

                        }

                    list.get(pos).setCosto(costo);
                    list.get(pos).setCantidad(cantidad);
                    list.get(pos).setEmpleado(empleado);

                }

                ControllerDespacho.cola.clear();
                ControllerDespacho.cola.addAll(list);

                ordenado = true;

                comboTodo.getSelectionModel().clearSelection();

                break;

            case 2:

                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                if(ordenado == true) {

                    int centro, primero = 0, ultimo = list.size() - 1, valorCentro, numBuscar;
                    numBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad a buscar"));
                    boolean encontrado = false;
                    centro = 0;

                    while (primero <= ultimo) {

                        centro = (primero + ultimo) / 2;

                        valorCentro = Integer.parseInt(list.get(centro).getCantidad());

                        if (numBuscar == valorCentro) {
                            alert.setContentText("La cantidad " + numBuscar + " se encuentra en la posición " + centro);
                            alert.show();
                            int numero = centro - 1;
                            tabla.getSelectionModel().select(numero);
                            encontrado = true;
                            break;
                        } else if (numBuscar < valorCentro) {
                            ultimo = centro - 1;
                        } else {
                            primero = centro + 1;
                        }

                    }//while

                    if (encontrado == false) {
                        alert.setContentText("No se ha encontrado esa cantidad");
                        alert.show();
                    }

                    encontrado = false;

                }
                else{
                    alert.setContentText("Se debe ordenar antes de buscar");
                    alert.show();
                }

                comboTodo.getSelectionModel().clearSelection();

                break;

        }
    }

    public void ordenar(){
        for(int i = 0; i < list.size(); i++){

            pos = i;

            cantidad = list.get(i).getCantidad();
            costo = list.get(i).getCosto();
            empleado = list.get(i).getEmpleado();

            while( (pos > 0) && (Integer.parseInt(list.get(pos-1).getCantidad()) > Integer.parseInt(cantidad))){

                list.get(pos).setCosto(list.get(pos-1).getCosto());
                list.get(pos).setCantidad(list.get(pos-1).getCantidad());
                list.get(pos).setEmpleado(list.get(pos-1).getEmpleado());

                pos--;

            }

            list.get(pos).setCosto(costo);
            list.get(pos).setCantidad(cantidad);
            list.get(pos).setEmpleado(empleado);

        }

        ControllerDespacho.cola.clear();
        ControllerDespacho.cola.addAll(list);
    }

}
