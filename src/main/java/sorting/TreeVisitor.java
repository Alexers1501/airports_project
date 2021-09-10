package sorting;

import java.util.ArrayList;

public class TreeVisitor {
    public void visit(BinaryTree node, ArrayList<Integer> sortList) {
        sortList.add(node.key);

    }
}
