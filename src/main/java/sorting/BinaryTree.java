package sorting;

import java.util.ArrayList;

public class BinaryTree {
    private BinaryTree left;
    private BinaryTree right;
    public int key;
    String value;

    public BinaryTree(int k) {

        key = k;
    }
    public BinaryTree(int k, String value) {

        key = k;
        this.value = value;
    }

    protected void insertByKey( BinaryTree aTree) {
        if ( aTree.key < key )
            if ( left != null ) left.insertByKey( aTree );
            else left = aTree;
        else
        if ( right != null ) right.insertByKey( aTree );
        else right = aTree;
    }

    public void insertByValue(BinaryTree aTree) {
        if ( aTree.value.compareTo(value) < 0 )
            if ( this.left != null ) this.left.insertByValue( aTree );
            else this.left = aTree;
        else
        if ( this.right != null ) this.right.insertByValue( aTree );
        else this.right = aTree;
    }

    protected void traverse(TreeVisitor visitor, ArrayList<Integer>  sortList) {
        if ( left != null)
            left.traverse( visitor, sortList);

        visitor.visit(this, sortList);

        if ( right != null )
            right.traverse( visitor, sortList);
    }
}
