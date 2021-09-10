import classes.Airport;
import parse.ParseCSV;
import sorting.BinaryTree;
import sorting.TreeVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Введите строку");
//        String str = sc.nextLine();
        String file = "src\\main\\airports_data.csv";
        ArrayList<Airport> list= ParseCSV.getAirportsList(file);
        System.out.println("Начальный список");
        list.forEach(s -> s.print());

        BinaryTree myTree;
        myTree = new BinaryTree(Integer.parseInt(list.get(0).getYear()),
                list.get(0).getMake());// создать дерево (с ключом)
        for (int i = 1; i < list.size(); i++) {
            myTree.insert(new BinaryTree(Integer.parseInt(list.get(i).getYear()),
                    list.get(i).getMake()));// присоединять поддеревья
        }
        HashMap<Integer, Airport> dict = new HashMap<>();
        for (Airport arp : list){
            dict.put(new Integer(arp.getYear()), arp);
        }
        ArrayList<Integer> sortedList = new ArrayList<>();
        myTree.traverse(new TreeVisitor(), sortedList);
        System.out.println("Сортированный список");
        for (int key : sortedList){
            dict.get(key).print();
        }

    }
}
