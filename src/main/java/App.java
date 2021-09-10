import parse.ParseCSV;
import parse.ParseYML;
import sorting.AirportsTree;

import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String filter = sc.nextLine();
        String file = "src\\main\\airports_data.csv";
        InputStream stream = App.class.getResourceAsStream("/application.yml");

        Instant time1 = Instant.now();
        //читаем yml
        int index = ParseYML.getFilterIndex(ParseYML.readYML(stream)) - 1;
        if (args.length != 0 && args[0] != null)
            index = Integer.parseInt(args[0]);

        HashMap<Integer,ArrayList<String>> map = ParseCSV.readCsv(file, index, filter);

        if (!map.isEmpty())
            AirportsTree.searchAirports(map, index);

        Instant time2 = Instant.now();
        long time = time2.toEpochMilli() - time1.toEpochMilli();
        System.out.printf("Количество найденных строк: %d \n" +
                "Время, затраченное на поиск: %d мс", map.size(), time);

    }
}
