package sorting;

import java.util.ArrayList;

public class BinaryTree {
	public BinaryTree left; 
   public BinaryTree right;
   public int key;
   public String value;

   public BinaryTree(int k, String value) {

       this.key = k;
       this.value = value;
   }

   public void insert( BinaryTree aTree) {
       if ( aTree.value.compareTo(value) < 0 )
            if ( left != null ) left.insert( aTree );
            else left = aTree;
       else
            if ( right != null ) right.insert( aTree );
            else right = aTree;
//     if ( aTree.key < key )
//        if ( left != null ) left.insert( aTree );
//        else left = aTree;
//     else
//        if ( right != null ) right.insert( aTree );
//        else right = aTree;
   }
   public void traverse(TreeVisitor visitor, ArrayList<Integer>  sortList) {
      if ( left != null)
            left.traverse( visitor, sortList);

      visitor.visit(this, sortList);

      if ( right != null )
            right.traverse( visitor, sortList);
   }
}