package by.training;

/**
 * Created by Evgenia on 01.10.2017.
 */
public class Values {

    private int value;
    private String unit;
    private double value_in_ms;


    public Values(int value, String unit, double value_in_ms) {
        this.value = value;
        this.unit = unit;
        this.value_in_ms = value_in_ms;
    }

    public int getValue() {
        return value;
    }
    public String getUnit() {
        return unit;
    }
    public double getValue_in_ms() {
        return value_in_ms;
    }

    public static Double separate(int value, String unit) {
        Units u = Units.valueOf(unit.toUpperCase());
        return value * u.modifier;
    }
    public String toString() {
        return getValue() + " " + getUnit() + " = " + getValue_in_ms() + " ms";
    }
}
