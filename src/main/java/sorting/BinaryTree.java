package sorting;

import java.util.ArrayList;

public class BinaryTree {
	public BinaryTree left; 
   public BinaryTree right;
   public int key;

   public BinaryTree(int k) { 
      key = k;
   }

   public void insert( BinaryTree aTree) {
     if ( aTree.key < key )
        if ( left != null ) left.insert( aTree );
        else left = aTree;
     else
        if ( right != null ) right.insert( aTree );
        else right = aTree;
   }


   public void traverse(TreeVisitor visitor, ArrayList<Integer>  sortList) {
      if ( left != null) 
            left.traverse( visitor, sortList);

      visitor.visit(this, sortList);

      if ( right != null ) 
            right.traverse( visitor, sortList);
   }
}

class TreeVisitor {
	  public void visit(BinaryTree node, ArrayList<Integer>  sortList) {
		  sortList.add(node.key);

	  }
	};