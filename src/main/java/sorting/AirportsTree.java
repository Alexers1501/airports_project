package sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class AirportsTree extends BinaryTree{

    public AirportsTree(int k, String value) {
        super(k, value);
    }

    protected static AirportsTree createTree(HashMap<Integer,ArrayList<String>> map, int index){
        AirportsTree myTree;
        int startKey = 0;
        Set<Integer> keys = map.keySet();
        for(int key: keys){
            startKey = key;
            break;
        }
        myTree = new AirportsTree(startKey, map.get(startKey).get(index));// создать дерево (с ключом)

        for (int key : keys){
            if (key != startKey)
                myTree.insertByValue(new AirportsTree(key, map.get(key).get(index)));// присоединять поддеревья
        }

        return myTree;
    }

    public static void searchAirports(HashMap<Integer,ArrayList<String>> list, int idx){
        AirportsTree myTree = AirportsTree.createTree(list, idx);

        ArrayList<Integer>  sortedList = new ArrayList<>();
        myTree.traverse(new TreeVisitor(), sortedList);
        for (int key : sortedList){
            printAirport(list.get(key));
        }
    }
    protected static void printAirport(ArrayList<String> list){
        System.out.printf("%-8s %-40s %-15s %-25s %-5s %-5s %-20s %-20s %-5s %-5s %-5s %-20s %-15s %-20s \n",
                list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6),
                list.get(7), list.get(8), list.get(9), list.get(10), list.get(11), list.get(12), list.get(13));
    }
}