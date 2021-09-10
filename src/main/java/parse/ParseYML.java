package parse;

import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ParseYML {
    public static HashMap<String, String> readYML(InputStream stream){
        Yaml yml = new Yaml();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            return yml.load(reader.readLine());
        } catch (IOException e) {
            System.out.printf("Ошибка чтения yml: %s \n", e.getMessage());
        }
        return new HashMap<String, String>();
    }

    public static Integer getFilterIndex(HashMap<String, String> map){
        return Integer.parseInt(map.get("column"));
    }
}
