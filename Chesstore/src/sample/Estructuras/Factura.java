package sample.Estructuras;

import javafx.beans.property.SimpleStringProperty;

public class Factura {

        SimpleStringProperty costo;
        SimpleStringProperty cantidad;
        SimpleStringProperty empleado;

        public Factura(String costo, String cantidad,String empleado){

            this.costo = new SimpleStringProperty(costo);
            this.cantidad = new SimpleStringProperty(cantidad);
            this.empleado = new SimpleStringProperty(empleado);

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

    public String getCantidad() {
        return cantidad.get();
    }

    public SimpleStringProperty cantidadProperty() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad.set(cantidad);
    }

    public String getEmpleado() {
        return empleado.get();
    }

    public SimpleStringProperty empleadoProperty() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado.set(empleado);
    }
}
