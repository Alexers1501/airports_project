package parse;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс для работы с yml файлами
 */
public class ParseYML{
    /**
     * Метод читает yml файл и возвращает в виде словаря
     * @param file
     * @return
     */
    private static HashMap<String, String> readYML(String file) {
        HashMap<String,String> map = new HashMap<>();
        try (FileReader reader = new FileReader(file);
             BufferedReader buffer = new BufferedReader(reader, 10)) {
            while (buffer.ready()) {
                String line = buffer.readLine();
                String[] splitedText = line.split(": ");
                ArrayList<String> columnList = new ArrayList<>();
                for (int i = 0; i < splitedText.length; i++) {
                    if (splitedText[i].startsWith("\"") && splitedText[i].endsWith("\""))
                        columnList.add(splitedText[i].substring(1, splitedText[i].length() - 1));
                    else columnList.add(splitedText[i]);
                }
                map.put(columnList.get(0), columnList.get(1));

            }
        } catch (IOException e) {
            System.out.printf("Произошла ошибка в чтении YML: %s \n ", e.getMessage());
        } finally {
            return map;
        }
    }

    /**
     * Метод возвращает значение из карты по переданном индексу
     * @param
     * @return
     */
    public static int getFilterIndex(String file){
        HashMap<String, String> map = readYML(file);
        try {
            return Integer.parseInt(map.get("column"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.printf("Файл yml пуст: %s \n", e.getMessage());
        }
        return 2;
    }
}
