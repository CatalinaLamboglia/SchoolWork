//  Author:   Catalina Lamboglia
//  Date  :   10/02/2019
//  Homework assignment : 3
//  Objective : Implements ADT of BST
//****************************************************************

import java.lang.Math;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
    public static void main(String args[])
    {
        BinarySearchTree<Integer> bst = new  				 				BinarySearchTree<Integer>();
        bst.insert(12);
        bst.insert(9);
        bst.insert(23);
        bst.printInOrder();
        System.out.println("Height of tree: " + bst.height());
        if (bst.passedTest())
            System.out.println("Test was passed");
        else
            System.out.println("Test not passed");
        if(bst.allPassed())
            System.out.println("All levels passed");
        else
            System.out.println("Not all levels passed");
        System.out.println(bst.postOrder());
        System.out.println("The number of nodes is: " + bst.nodeCount());  
    }

    // Constructs tree
    public BinarySearchTree()
    {
        root = null; 
    }

    private static class BinaryNode<AnyType>
    {
        // Constructors
        BinaryNode(AnyType theElement)
        {
            this(theElement, null, null); 
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt)
        {
            element  = theElement; 
            left = lt; 
            right = rt; 
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }


    private BinaryNode<AnyType> root;
    private String contents;
    private int numberOfNodes;
    
    
    // Util methods
    public void makeEmpty()
    {
         root = null; 
    }
    public boolean isEmpty()
    {
        return root == null; 
    }
    public BinaryNode<AnyType> getRoot()
    {
        return root;
    } // end util methods

    public boolean contains(AnyType x)
    {
        return contains(x, root);
    }
    
    // Helper class for contains
    private boolean contains(AnyType x, BinaryNode<AnyType> t)
    {
        if(t == null) // Null can't be found
            return false;

        int compareResult = x.compareTo(t.element);
  
        if(compareResult < 0) // move left
            return contains(x, t.left);
        else if(compareResult > 0) // move right
            return contains(x, t.right);
        else // found, compare == 0
            return true;
    }
    
    public void insert(AnyType x)
    {
        root = insert(x, root); 
    }
    
    // Helper for insert
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t)
    {
        if(t == null)
            return new BinaryNode<AnyType>(x, null, null);
            
        int compareResult = x.compareTo(t.element);
        
        if(compareResult < 0) // insert onto left
            t.left = insert(x, t.left);
        else if(compareResult > 0) // insert onto right
            t.right = insert(x, t.right);
        else // compareResult == 0
            ;  // Duplicates not allowed, insert nothing
        return t;
    }
    
    public void remove(AnyType x)
    {
        root = remove(x, root); 
    }
    
    // Helper for remove
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t)
    {
        if(t == null)
            return t;   // Item not found, return null
            
        int compareResult = x.compareTo(t.element);
        
        if(compareResult < 0) // Move left
            t.left = remove(x, t.left);
        else if(compareResult > 0) // Move right
            t.right = remove(x, t.right);
        else if((t.left != null) && (t.right != null)) // Two children
        {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        }
        else
        { 
            if (t.left != null)
                t = t.left;
            else
                t = t.right;
        }
        return t;
    }
    
    // Finds smallest element by getting leftmost leaf
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t)
    {
        if(t == null)
           return null;
        else if(t.left == null)
            return t; // is leftmost
        return findMin(t.left);
    }
    
    // Print tree inorder
    public void printInOrder()
    {
        if(isEmpty())
            System.out.println("Empty tree");
        else
            printInOrder(root);
    }

    // Helper printTree for inorder
    private void printInOrder(BinaryNode<AnyType> t)
    {
        if(t != null)
        {
            printInOrder(t.left);
            System.out.println(t.element);
            printInOrder(t.right);
        }
    }
    
    public int height()
    {
        return height(root);
    }
    
    // Helper for height
    private int height(BinaryNode<AnyType> t)
    {
        if (t == null)
            return 0; // no height
        else
            return 1 + Math.max(height(t.left), height(t.right));
        
    }
    
    // For testing method
    public boolean passedTest()
    {
        return passedTest(root);
    }
    // "Helper"/actually to specification method
    private boolean passedTest(BinaryNode<AnyType> t)
    {
        if (Math.abs(height(t.right) - height(t.left)) > 1)
            return false;
        else
            return true;
    }
    
    public boolean allPassed()
    {
        return allPassed(root);
    }
    // Helper for allPassed
    private boolean allPassed(BinaryNode<AnyType> t)
    {
        if (!(passedTest(t.left) && passedTest(t.right))) // not true
            return false;
        else
            return true;
    }
    
    public String postOrder()
    {
        contents = new String();
        return postOrder(root);
    }
    
    // Helper, uses global variable "contents"
    private String postOrder(BinaryNode<AnyType> t)
    {
        if(t.left != null)
            postOrder(t.left);
        
        if (t.right != null)
            postOrder(t.right);
                
        contents = contents + t.element + ", ";

        return contents;
    }
    
    public int nodeCount()
    {
        numberOfNodes = 0; // global var
        return nodeCount(root);
    }
    
    // Helper, uses global variable, set to 0 prior
    // named numberOfNodes
    private int nodeCount(BinaryNode<AnyType> t)
    {
        if (t == null)
            return 0;
        else
        {
            nodeCount(t.left);
            nodeCount(t.right);
            numberOfNodes++;
        }
        return numberOfNodes;
    }

}