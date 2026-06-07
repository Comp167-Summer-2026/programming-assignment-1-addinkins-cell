import java.util.Scanner;

public class TemperatureConverter {
    public static double convertTemperature(double temperature, String unit) {
        double convertValue = 0.0;
        if (unit.equals("C") || unit.equals("c")) {
            convertValue = (temperature * 9.0/5.0) + 32.0;
        }
        else if (unit.equals("F") || unit.equals("f")) {
            convertValue = (temperature - 32.0) * 5.0/9.0;
        }
        return convertValue;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean on = true;
        while (on) {
            System.out.print("Enter a temperature value or type 'stop' to quit: ");
            String input = scnr.next();
            if (input.equals("stop")) {
                on = false;
            }
            else {
                Scanner stringCheck = new Scanner(input);
                if (stringCheck.hasNextDouble()) {
                    double tempValue = stringCheck.nextDouble();
                    System.out.print("Enter the unit C or F: ");
                    String unit = scnr.next();
                    if (unit.equals("C") || unit.equals("F")) {
                        double result = convertTemperature(tempValue, unit);
                        System.out.printf("%.2f%s is equal to %.2f%s\n",
                                tempValue, unit.toUpperCase(),
                                result, (unit.equalsIgnoreCase("C") ? "F" : "C"));
                    }
                    else {
                        // Display error message for unrecognized unit labels
                        System.out.println("Error, Unrecognized unit, Use C or F.");
                    }

                }
                else {
                    // Display error message for non-numeric temperature values (like "abc")
                    System.out.println("Error: Invalid temperature input Please enter  valid number.");
                }

                stringCheck.close();
            }
        }

        System.out.println("Program exited.");
        scnr.close();
    }
}