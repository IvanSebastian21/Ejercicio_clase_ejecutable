package org.examen_java.service;

import org.examen_java.entities.Tarjeta;
import org.examen_java.exception.TarjetaInvalidaException;

import java.time.LocalDate;

public class TasaService {
    public double calcularTasa(String marca, double importe, Tarjeta tarjeta) throws TarjetaInvalidaException {
        if (!tarjeta.esValida()) {
            throw new TarjetaInvalidaException("Su tarjeta no es válida");
        }
        switch (marca) {
            case "VISA":
                LocalDate currentDate = LocalDate.now();
                int year = currentDate.getYear();
                int month = currentDate.getMonthValue();
                return (double) year / month;

            case "NARA":
                int dayOfMonth = LocalDate.now().getDayOfMonth();
                return dayOfMonth * 0.5;

            case "AMEX":
                int currentMonth = LocalDate.now().getMonthValue();
                return currentMonth * 0.1;

            default:
                throw new TarjetaInvalidaException("Marca de tarjeta inválida");
        }
    }
}

