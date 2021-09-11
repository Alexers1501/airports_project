package sorting;

import java.util.ArrayList;

/**
 * Базовый класс для работы с двоиным деревом
 */
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

    /**
     * вставка поддерева по ключу
     * @param aTree
     */
    protected void insertByKey( BinaryTree aTree) {
        if ( aTree.key < key )
            if ( left != null ) left.insertByKey( aTree );
            else left = aTree;
        else
        if ( right != null ) right.insertByKey( aTree );
        else right = aTree;
    }

    /**
     * вставка поддерева по значению
     * @param aTree
     */
    public void insertByValue(BinaryTree aTree) {
        if ( aTree.value.compareTo(value) < 0 )
            if ( this.left != null ) this.left.insertByValue( aTree );
            else this.left = aTree;
        else
        if ( this.right != null ) this.right.insertByValue( aTree );
        else this.right = aTree;
    }

    /**
     * Метод реализует обход всего дерева по поддеревьям
     * @param visitor
     * @param sortList
     */
    protected void traverse(TreeVisitor visitor, ArrayList<Integer>  sortList) {
        if ( left != null)
            left.traverse( visitor, sortList);

        visitor.visit(this, sortList);

        if ( right != null )
            right.traverse( visitor, sortList);
    }
}
