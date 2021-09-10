package parse;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;

import classes.Airport;

public class ParseCSV {

    /**
     * Этот метод читает данные из файла CSV и записывает их в список
     * @param file
     * @return List<ArrayList<String>>
     */
    private static List<ArrayList<String>> read_csv(String file){
        //Загружаем строки из файла
        List<ArrayList<String>> products = new ArrayList<>();
        List<String> fileLines = null;
        try {
            fileLines = Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String fileLine : fileLines) {
            String[] splitedText = fileLine.split(",");
            ArrayList<String> columnList = new ArrayList<String>();
            for (int i = 0; i < splitedText.length; i++) {
                //Если колонка начинается на кавычки или заканчиваеться на кавычки
                if (IsColumnPart(splitedText[i])) {
                    String lastText = columnList.get(columnList.size() - 1);
                    columnList.set(columnList.size() - 1, lastText + ","+ splitedText[i]);
                } else {
                    columnList.add("~" + splitedText[i] + "~");
                }
            }
            products.add(columnList);
        }
        return products;
    }
    //Проверка является ли колонка частью предыдущей колонки
    private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        //Если в тексте одна ковычка и текст на нее заканчиваеться значит это часть предыдущей колонки
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
    }

    /**
     * Этот метод формирует из листа данных из файла CSV в лист с экземплярами класса Airport
     * @param file путь до файла
     * @return ArrayList<Airport>
     */
    public static ArrayList<Airport> getAirportsList(String file){
        List<ArrayList<String>> list = read_csv(file);
        ArrayList<Airport> airports = new ArrayList<>();
        for(ArrayList<String> data : list){
            Airport airport = new Airport(data.get(0), data.get(1), data.get(2),
                    data.get(3), data.get(4));
            airports.add(airport);
        }
        return airports;
    }
    public static void main( String[] args )
    {
        String file = "src\\main\\airports_data.csv";
        ArrayList<Airport> list= getAirportsList(file);
        list.forEach(s -> s.print());


    }
}
