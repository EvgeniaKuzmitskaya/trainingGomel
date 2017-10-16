package by.training;

import java.util.Comparator;

/**
 * Created by Evgenia on 02.10.2017.
 */
public class SortedByValueAndUnitDesc implements Comparator<Values> {

    public int compare(Values o1, Values o2) {
        int result = new Integer(o2.getValue()).compareTo(o1.getValue());
        if (result == 0){
            Units u1 = Units.valueOf(o1.getUnit().toUpperCase());
            Units u2 = Units.valueOf(o2.getUnit().toUpperCase());
            result = u1.compareTo(u2);
        }
        return result;
    }
}



