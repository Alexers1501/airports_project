package sorting;

import classes.Airport;

import java.util.ArrayList;
import java.util.HashMap;

public class AirportsTree extends BinaryTree{
    public String value;

    public AirportsTree(int k, String value) {
        super(k);
        this.value = value;
    }

    public static AirportsTree createTree(ArrayList<Airport> list){
        AirportsTree myTree;
        myTree = new AirportsTree(Integer.parseInt(list.get(0).getYear()),
                list.get(0).getMake());// создать дерево (с ключом)
        for (int i = 1; i < list.size(); i++) {
            myTree.insert(new AirportsTree(Integer.parseInt(list.get(i).getYear()),
                    list.get(i).getMake()));// присоединять поддеревья
        }
        return myTree;
    }
    public static AirportsTree createTreeWithFilter(ArrayList<Airport> list, String filter){
        AirportsTree myTree;
        int i = 0;
        while(!list.get(i).getMake().startsWith(filter)){
            i++;
        }
        myTree = new AirportsTree(Integer.parseInt(list.get(i).getYear()),
                list.get(i).getMake());// создать дерево (с ключом)
        for (int j = i + 1; j < list.size(); j++) {
            if (list.get(j).getMake().startsWith(filter))
                myTree.insert(new AirportsTree(Integer.parseInt(list.get(j).getYear()),
                        list.get(j).getMake()));// присоединять поддеревья
        }
        return myTree;
    }

    public void insert( AirportsTree aTree) {
        if ( aTree.value.compareTo(value) < 0 )
            if ( left != null ) left.insert( aTree );
            else left = aTree;
        else
        if ( right != null ) right.insert( aTree );
        else right = aTree;
    }
    public static void searchAirports(ArrayList<Airport> list, int idx, String filter){
        AirportsTree myTree = AirportsTree.createTreeWithFilter(list, filter);
        HashMap<Integer, Airport> dict = new HashMap<>();
        for (Airport arp : list){
            dict.put(new Integer(arp.getYear()), arp);
        }
        ArrayList<Integer>  sortedList = new ArrayList<>();
        myTree.traverse(new TreeVisitor(), sortedList);
        for (int key : sortedList){
            dict.get(key).print();
        }
    }
}