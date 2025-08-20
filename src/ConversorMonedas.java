import javax.swing.*;

public class ConversorMonedas {
    public static void main(String[] args) {
        String[] monedas = {"Euros (EUR)", "Libras (GBP)", "Yenes (JPY)", "Pesos Mexicanos (MXN)"};
        double[] tasas = {0.93, 0.80, 147.50, 20.50};

        while (true) {
            // Menú de selección
            String seleccion = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecciona a qué moneda convertir:",
                    "Conversor de Dólares a Otras Monedas",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    monedas,
                    monedas[0]
            );

            if (seleccion == null) {
                JOptionPane.showMessageDialog(null, "¡Gracias por usar el conversor!");
                break;
            }

            // Encontrar la tasa correspondiente
            int index = -1;
            for (int i = 0; i < monedas.length; i++) {
                if (monedas[i].equals(seleccion)) {
                    index = i;
                    break;
                }
            }

            // Pedir cantidad
            String input = JOptionPane.showInputDialog("Ingresa la cantidad en DÓLARES:");

            if (input == null) break;

            try {
                double dolares = Double.parseDouble(input);
                double resultado = dolares * tasas[index];

                JOptionPane.showMessageDialog(null,
                        String.format("$%.2f USD = %.2f %s", dolares, resultado, seleccion.split(" ")[0])
                );

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingresa un número válido");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error inesperado");
            }
        }
    }
}