import classes.Airport;
import parse.ParseCSV;
import parse.ParseYML;
import sorting.AirportsTree;
import sorting.TreeVisitor;

import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Введите строку");
//        String str = sc.nextLine();
        String file = "src\\main\\airports_data.csv";
        ArrayList<Airport> list = ParseCSV.getAirportsList(file);

        String filter = "Ch";

        Instant time1 = Instant.now();

        //читаем yml
        InputStream stream = App.class.getResourceAsStream("/application.yml");
        int index = ParseYML.getFilterIndex(ParseYML.readYML(stream));
        System.out.println("index " + index);

        AirportsTree.searchAirports(list, index, filter);

        Instant time2 = Instant.now();
        long time = time2.toEpochMilli() - time1.toEpochMilli();
        System.out.printf("Количество найденных строк: %d \n" +
                "Время, затраченное на поиск: %d мс", list.size(), time);

    }
}
