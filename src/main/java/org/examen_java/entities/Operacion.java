package org.examen_java.entities;

import org.examen_java.exception.TarjetaInvalidaException;

public class Operacion {
    private Tarjeta tarjeta;
    private double importe;

    // Constructor, getters y setters

    public Operacion(Tarjeta tarjeta, double importe) throws TarjetaInvalidaException {
        if (!tarjeta.esValida()) {
            throw new TarjetaInvalidaException("Su tarjeta no es válida");
        }
        this.tarjeta = tarjeta;
        this.importe = importe;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "tarjeta=" + tarjeta +
                ", importe=" + importe +
                '}';
    }

    // Métodos

    public boolean esValida() {
        return importe <= 1000;
    }
}