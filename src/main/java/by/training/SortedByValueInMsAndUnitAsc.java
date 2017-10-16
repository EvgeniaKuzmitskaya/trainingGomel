package by.training;

import java.util.Comparator;

/**
 * Created by Evgenia on 02.10.2017.
 */
public class SortedByValueInMsAndUnitAsc implements Comparator<Values> {

    public int compare(Values o1, Values o2) {
        int result = new Double(o1.getValue_in_ms()).compareTo(o2.getValue_in_ms());
        if (result == 0){
            Units u1 = Units.valueOf(o1.getUnit().toUpperCase());
            Units u2 = Units.valueOf(o2.getUnit().toUpperCase());
            result = u1.compareTo(u2);
        }
        return result;
    }
 }

