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

    }

}
