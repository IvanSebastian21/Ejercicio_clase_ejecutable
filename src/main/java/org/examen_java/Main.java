package org.examen_java;

import org.examen_java.entities.Operacion;
import org.examen_java.entities.Tarjeta;
import org.examen_java.exception.TarjetaInvalidaException;
import org.examen_java.service.TasaService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Crear tarjetas
        Tarjeta visa = new Tarjeta("VISA", "1234-5678-9012-3456", "ivan dev", LocalDate.of(2025, 6, 30));
        Tarjeta nara = new Tarjeta("NARA", "5678-9012-3456-7890", "sebastian devops", LocalDate.of(2026, 8, 15));
        Tarjeta amex = new Tarjeta("AMEX", "9876-5432-1098-7654", "gaby lead", LocalDate.of(2027, 9, 10));

        // Crear operaciones
        try {
            Operacion operacion1 = new Operacion(visa, 500);
            Operacion operacion2 = new Operacion(nara, 900);

            // Calcular la tasa de operaciones
            TasaService tasaService = new TasaService();
            double tasaOperacion1 = tasaService.calcularTasa(visa.getMarca(), operacion1.getImporte(), visa);
            double tasaOperacion2 = tasaService.calcularTasa(nara.getMarca(), operacion2.getImporte(), nara);

            // Imprimir la información y resultados
            System.out.println("Información de tarjetas:");
            System.out.println(visa.toString());
            System.out.println(nara.toString());
            System.out.println(amex.toString());

            System.out.println("\nResultado de operaciones:");
            System.out.println("Operación 1 válida: " + (operacion1.esValida() ? "Sí" : "No"));
            System.out.println("Operación 2 válida: " + (operacion2.esValida() ? "Sí" : "No"));

            System.out.println("\nTarjetas distintas:");
            System.out.println("Tarjeta 1 es distinta de Tarjeta 2: " + (visa.esDistintaDe(nara) ? "Sí" : "No"));

            System.out.println("\nTasa de operaciones:");
            System.out.println("Tasa de operación 1: " + tasaOperacion1);
            System.out.println("Tasa de operación 2: " + tasaOperacion2);

        } catch (TarjetaInvalidaException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}