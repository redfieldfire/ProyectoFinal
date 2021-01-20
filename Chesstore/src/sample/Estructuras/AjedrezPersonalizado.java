package sample.Estructuras;

import javafx.beans.property.SimpleStringProperty;

public class AjedrezPersonalizado {

        SimpleStringProperty piezas;
        SimpleStringProperty tablero;
        SimpleStringProperty peso;
        SimpleStringProperty trama;
        SimpleStringProperty tipo;
        SimpleStringProperty nombre;
        SimpleStringProperty tarjeta;
        SimpleStringProperty costo;

        public AjedrezPersonalizado(String piezas, String tablero, String peso, String trama, String tipo,String nombre, String tarjeta,String costo){

            this.piezas = new SimpleStringProperty(piezas);
            this.tablero = new SimpleStringProperty(tablero);
            this.peso = new SimpleStringProperty(peso);
            this.trama = new SimpleStringProperty(trama);
            this.tipo = new SimpleStringProperty(tipo);
            this.nombre = new SimpleStringProperty(nombre);
            this.tarjeta = new SimpleStringProperty(tarjeta);
            this.costo = new SimpleStringProperty(costo);

        }

    public String getPiezas() {
        return piezas.get();
    }

    public SimpleStringProperty piezasProperty() {
        return piezas;
    }

    public void setPiezas(String piezas) {
        this.piezas.set(piezas);
    }

    public String getTablero() {
        return tablero.get();
    }

    public SimpleStringProperty tableroProperty() {
        return tablero;
    }

    public void setTablero(String tablero) {
        this.tablero.set(tablero);
    }

    public String getPeso() {
        return peso.get();
    }

    public SimpleStringProperty pesoProperty() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso.set(peso);
    }

    public String getTrama() {
        return trama.get();
    }

    public SimpleStringProperty tramaProperty() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama.set(trama);
    }

    public String getTipo() {
        return tipo.get();
    }

    public SimpleStringProperty tipoProperty() {
        return tipo;
    }

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getTarjeta() {
        return tarjeta.get();
    }

    public SimpleStringProperty tarjetaProperty() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta.set(tarjeta);
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public String getCosto() {
        return costo.get();
    }

    public SimpleStringProperty costoProperty() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo.set(costo);
    }
}
