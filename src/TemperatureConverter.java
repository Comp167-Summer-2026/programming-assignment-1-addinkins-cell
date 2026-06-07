import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {
        double convertedValue = 0.0;

        if (unit.equals("C") || unit.equals("c")) {
            convertedValue = (temperature * 9.0 / 5.0) + 32.0;
        }
        else if (unit.equals("F") || unit.equals("f")) {
            convertedValue = (temperature - 32.0) * 5.0 / 9.0;
        }

        return convertedValue;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean on = true;

        while (on) {
            System.out.print("Enter temperature (or 'stop' to quit): ");
            String input = scnr.next();

            if (input.equalsIgnoreCase("stop")) {
                on = false;
            } else {
                Scanner stringCheck = new Scanner(input);

                if (stringCheck.hasNextDouble()) {
                    double tempValue = stringCheck.nextDouble();

                    // Keep re-prompting until a valid unit is entered
                    boolean validUnit = false;
                    while (!validUnit) {
                        System.out.print("Enter the unit (C or F): ");
                        String unitValue = scnr.next();

                        if (unitValue.equalsIgnoreCase("C") || unitValue.equalsIgnoreCase("F")) {
                            double result = convertTemperature(tempValue, unitValue);
                            String fromUnit = unitValue.toUpperCase();
                            String toUnit = fromUnit.equals("C") ? "F" : "C";

                            System.out.printf("%.2f\u00B0%s is equal to %.2f\u00B0%s%n",
                                    tempValue, fromUnit, result, toUnit);

                            validUnit = true;
                        } else {
                            System.out.println("Error: Unrecognized unit. Please enter C or F.");
                        }
                    }

                } else {
                    System.out.println("Error: Invalid temperature input. Please enter a valid number.");
                }

                stringCheck.close();
            }
        }

        System.out.println("Program exited gracefully.");
        scnr.close();
    }
}
