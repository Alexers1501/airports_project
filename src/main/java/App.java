import parse.ParseCSV;
import parse.ParseYML;
import sorting.AirportsTree;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App
{
    /**
     * Главный класс программы: читает введную строку с консоли, вызывает методы классов парсинга и работы с
     * двоичным деревом, записывает время работы программы (чтения файла, фильтрации и сортировки)
     * @param args
     */
    public static void main( String[] args ){
        Scanner sc = new Scanner(System.in);

        int temp = 1;
        try {
            temp = Integer.parseInt(args[0]) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат числа на входе!");
            System.exit(1);
        }

        System.out.println("Введите строку: ");
        String filter = sc.nextLine();
        String fileCSV = "src\\main\\airports_data.csv";
        String fileYML = "src\\main\\resources\\application.yml";

        Instant time1 = Instant.now();
        //читаем yml
        int index = 1;
        if (args.length != 0 && args[0] != null)
            index = temp;
        else
            index = ParseYML.getFilterIndex(fileYML) - 1;

        HashMap<Integer,ArrayList<String>> map = ParseCSV.readCsv(fileCSV, index, filter);

        if (!map.isEmpty())
            AirportsTree.getAirports(map, index);

        Instant time2 = Instant.now();
        long time = time2.toEpochMilli() - time1.toEpochMilli();
        System.out.printf("Количество найденных строк: %d \n" +
                "Время, затраченное на поиск: %d мс", map.size(), time);

    }

}
