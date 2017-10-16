package by.training;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * Created by Evgenia on 29.09.2017.
 */
public class MainClass {

    private static NumberFormat formatter = new DecimalFormat("#0.000");

    private static Values splitRow(String s) {
        Values values = null;
        StringTokenizer st = new StringTokenizer(s, " ");
        while (st.hasMoreTokens()) {
            Integer value = Integer.parseInt(st.nextToken());
            String unit = st.nextToken();
            double value_in_ms = Values.separate(value, unit);
            values = new Values(value,unit,value_in_ms);
        }
        return values;
    }

    public static void printList(String title, List<Values> list){
        System.out.println(title);
        for (Values v: list){
            System.out.println(v.getValue() + " " + v.getUnit()+ " = "
                    + doubleToString(v.getValue_in_ms()) + " ms");
        }
    }
    public static void printListNext(String title, List<Values> list){
        System.out.println(title);
        for (Values v: list){
            System.out.println(v.getValue() + " " + v.getUnit());
        }
    }

    public static List<Values> read(String fileName) throws FileNotFoundException {
        List<Values> list = new ArrayList<Values>();
        File file = new File("./" + fileName);
        //File file = new File("D:\\IdeaProjects\\trainingGomel\\src\\main\\" + fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    Values v = splitRow(s);
                    if (v != null){
                        list.add(v);
                    }
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void printYesNo(String title, List<Values> list, int value, Units unit){
        System.out.println(title);
        for (Values v: list){
            if (v.getValue() == value && unit.name().equals(v.getUnit().toUpperCase())){
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");
    }

    private static String doubleToString(double v){
        int i = (int)v;
        if (i == v){
            return Integer.toString(i);
        } else {
            return formatter.format(v);
        }
    }
}
