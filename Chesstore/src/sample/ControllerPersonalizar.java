package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.Estructuras.AjedrezPersonalizado;

import java.io.IOException;

public class ControllerPersonalizar {

    @FXML ComboBox cmbPiezas;
    @FXML ComboBox cmbTablero;
    @FXML ComboBox cmbPeso;
    @FXML ComboBox cmbTrama;
    @FXML ComboBox cmbTipo;

    @FXML TextField txtNombre;
    @FXML TextField txtTarjeta;

    @FXML Text lblPiezas;
    @FXML Text lblTablero;
    @FXML Text lblPeso;
    @FXML Text lblTrama;
    @FXML Text lblTipo;
    @FXML Text lblCostoTotal;

    @FXML Button btnMandarCrear;

    String styleFuera = "-fx-background-color: #160E13; -fx-text-fill: WHITE";
    String styleDentro = "-fx-background-color: WHITE; -fx-text-fill: #160E13;";

    int precioPiezas = 0, precioTablero = 0, precioPeso = 0, precioTrama = 0, precioTipo = 0;

    @FXML
    public void initialize(){

        cmbPiezas.getItems().addAll("Madera","Plastico","Metal","Carton","Cristal","Porcelana");
        cmbTablero.getItems().addAll("Madera","Vinil","Carton","Cristal","Piedra");
        cmbPeso.getItems().addAll("Sin Peso","1/2Kg","1Kg","2Kg","3Kg","4Kg");
        cmbTrama.getItems().addAll("Star Wars","Normal","Egipcio","Simsons","Belico","Chino");
        cmbTipo.getItems().addAll("Torneo","Profesional","Lujoso","Casa Staunton","Clasico");

        cmbPiezas.setOnAction(event -> {

            switch (cmbPiezas.getSelectionModel().getSelectedIndex()){

                case 0: precioPiezas = 100; break;
                case 1: precioPiezas = 60; break;
                case 2: precioPiezas = 90; break;
                case 3: precioPiezas = 20; break;
                case 4: precioPiezas = 150; break;
                case 5: precioPiezas = 300; break;

            }

            lblPiezas.setText("Piezas " + precioPiezas + "$");

            costo();

        });
        cmbTablero.setOnAction(event -> {

            switch (cmbTablero.getSelectionModel().getSelectedIndex()){

                case 0: precioTablero = 150; break;
                case 1: precioTablero = 50; break;
                case 2: precioTablero = 30; break;
                case 3: precioTablero = 140; break;
                case 4: precioTablero = 120; break;

            }

            lblTablero.setText("Tablero " + precioTablero + "$");

            costo();

        });
        cmbPeso.setOnAction(event -> {

            switch (cmbPeso.getSelectionModel().getSelectedIndex()){

                case 0: precioPeso = 0; break;
                case 1: precioPeso = 10; break;
                case 2: precioPeso = 30; break;
                case 3: precioPeso = 70; break;
                case 4: precioPeso = 150; break;
                case 5: precioPeso = 310; break;

            }

            lblPeso.setText("Peso " + precioPeso + "$");

            costo();

        });
        cmbTrama.setOnAction(event -> {

            switch (cmbTrama.getSelectionModel().getSelectedIndex()){

                case 0: precioTrama = 200; break;
                case 1: precioTrama = 0; break;
                case 2:
                case 4:
                    precioTrama = 150; break;
                case 3: precioTrama = 50; break;
                case 5: precioTrama = 190; break;

            }

            lblTrama.setText("Trama " + precioTrama + "$");

            costo();

        });
        cmbTipo.setOnAction(event -> {

            switch (cmbTipo.getSelectionModel().getSelectedIndex()){

                case 0: precioTipo = 200; break;
                case 1: precioTipo = 300; break;
                case 2: precioTipo = 250; break;
                case 3: precioTipo = 1000; break;
                case 4: precioTipo = 100; break;

            }

            lblTipo.setText("Tipo " + precioTipo + "$");

            costo();

        });

        btnMandarCrear.setOnMouseEntered(event -> btnMandarCrear.setStyle(styleDentro));
        btnMandarCrear.setOnMouseExited(event -> btnMandarCrear.setStyle(styleFuera));


    }//initizalize

    public void costo(){

        lblCostoTotal.setText("Costo total " + (this.precioPiezas+this.precioTablero+this.precioPeso+this.precioTrama+this.precioTipo) + "$");

    }

    public void regresar(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PantallaMain.fxml"));
            Main.stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crear(){

        if(cmbPiezas.getSelectionModel().isEmpty() || cmbTablero.getSelectionModel().isEmpty()
        || cmbPeso.getSelectionModel().isEmpty() || cmbTrama.getSelectionModel().isEmpty()
        || cmbTipo.getSelectionModel().isEmpty() || txtNombre.getText().equals("")
                || txtTarjeta.getText().equals("")){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Chesstore");
            alert.setContentText("No has seleccionado todos los parametros para crear el ajedrez");
            alert.show();

        }
        else {

            String piezas = cmbPiezas.getSelectionModel().getSelectedItem().toString();
            String tablero = cmbTablero.getSelectionModel().getSelectedItem().toString();
            String peso = cmbPeso.getSelectionModel().getSelectedItem().toString();
            String trama = cmbTrama.getSelectionModel().getSelectedItem().toString();
            String tipo = cmbTipo.getSelectionModel().getSelectedItem().toString();
            String nombre = txtNombre.getText();
            String tarjeta = txtTarjeta.getText();
            int costo = precioPiezas + precioTablero + precioPeso + precioTrama + precioTipo;

            ControllerDespacho.list.add(new AjedrezPersonalizado(piezas, tablero, peso, trama, tipo,nombre,tarjeta,"$" + costo + ".00"));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Chesstore");
            alert.setContentText("Listo!");
            alert.show();

        }
    }

}
