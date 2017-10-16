package by.training;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Evgenia on 29.09.2017.
 */
public class Loader {

    public static void main(String[] args){

        if (args != null && args.length > 0){
            if (args.length < 1 || args.length > 1){
                System.out.println("Неверное количество аргументов");
            }
        } else
        try {
            Scanner sc = new Scanner(System.in);
            sc.useLocale(Locale.ENGLISH);
            System.out.println("Введите название файла");
            String fileName = sc.nextLine();
            List<Values> list = MainClass.read(fileName);
            MainClass.printList("task1", list);
            Collections.sort(list, new SortedByValueInMsAndUnitAsc());
            MainClass.printListNext("task2", list);
            MainClass.printYesNo("task3", list, 2, Units.KMH);
            Collections.sort(list, new SortedByValueAndUnitDesc());
            MainClass.printListNext("task4", list);
            } catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }
    }
}
