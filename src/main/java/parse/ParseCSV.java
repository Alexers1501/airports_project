package parse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ParseCSV {

    /**
     * Этот метод читает данные из файла CSV и записывает их в список
     * @param file
     * @return List<ArrayList<String>>
     */
    public static HashMap<Integer,ArrayList<String>> readCsv(String file, int index, String filter){
        //Загружаем строки из файла
        HashMap<Integer,ArrayList<String>> products = new HashMap<>();
        try (FileReader reader = new FileReader(file);
             BufferedReader buffer = new BufferedReader(reader, 500)){
            while (buffer.ready()){
                String line = buffer.readLine();
                String[] splitedText = line.split(",");
                ArrayList<String> columnList = new ArrayList<>();
                for (int i = 0; i < splitedText.length; i++) {
                    if (splitedText[i].startsWith("\"") && splitedText[i].endsWith("\""))
                        columnList.add(splitedText[i].substring(1, splitedText[i].length() - 1));
                    else columnList.add(splitedText[i]);
                }
                if ((columnList.get(index)).startsWith(filter))
                    products.put(Integer.parseInt(columnList.get(0)), columnList);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

}
