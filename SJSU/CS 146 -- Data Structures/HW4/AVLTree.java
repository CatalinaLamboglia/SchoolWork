//  Author:   Catalina Lamboglia
//  Date  :   10/29/2019
//  Homework assignment : 4
//  Objective : Implements ADT of AVL Tree
//****************************************************************

import java.lang.Math;

public class AVLTree<AnyType extends Comparable<? super AnyType>>
{
    public static void main(String args[])
    {
        AVLTree<Integer> bst = new AVLTree<Integer>(); // name doesn't matter
        bst.insert(12);
        bst.insert(9);
        bst.insert(23);
        bst.insert(1);
        bst.insert(220);
        bst.insert(21);
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
    public AVLTree()
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
        root = insert(root, x); 
    }

    public void remove(AnyType x)
    {
        root = remove(root, x); 
    }
    
    // rotatoes right 
    private BinaryNode<AnyType> rightRotate(BinaryNode<AnyType> node) 
    { 
        BinaryNode<AnyType> leftNode = node.left; 
        BinaryNode<AnyType> leftRightNode = leftNode.right; 
  
        // rotate
        leftNode.right = node; 
        node.left = leftRightNode; 
  
        return node; // node is new "root"
    } 
  
    // left rotates
    private BinaryNode<AnyType> leftRotate(BinaryNode<AnyType> node) 
    { 
        BinaryNode<AnyType> rightNode = node.right; 
        BinaryNode<AnyType> leftRightNode = rightNode.left; 

        // rotate
        rightNode.left = node; 
        node.right = leftRightNode; 
  
        return rightNode; // rightNode is new "root"
    } 
  
    // get balance of node
    private int getBalance(BinaryNode<AnyType> node) 
    { 
        if (node == null) 
            return 0; 
  
        return height(node.left) - height(node.right); 
    } 
    
    // AVL insertion
    private BinaryNode<AnyType> insert(BinaryNode<AnyType> node, AnyType key) 
    { 
  
        // standard inserts
        if (node == null) 
            return (new BinaryNode<AnyType>(key)); 
            
        if (key.compareTo(node.element) < 0) 
            node.left = insert(node.left, key); 
        else if (key.compareTo(node.element) > 0) 
            node.right = insert(node.right, key); 
        else // key == node.element 
            return node; 
  
        int balance = getBalance(node); // h(left)-h(right)
        int compareResult = key.compareTo(node.element);
        
        // insertion cases:
        
        // left left -- more on left so balance is pos
        if (balance > 1 && key.compareTo(node.left.element) < 0) 
            return rightRotate(node); 
  
        // right right 
        if (balance < -1 && key.compareTo(node.right.element) > 0)
        { 
            return leftRotate(node); 
        }
           
        // right left
        if (balance < -1 && key.compareTo(node.right.element) < 0)
        { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 
  
        // left right -- more on left so balance is pos
        if (balance > 1 && key.compareTo(node.left.element) > 0) 
        { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 
        // no rotation
        return node; 
    } 
    
    // AVL remove
    private BinaryNode<AnyType> remove(BinaryNode<AnyType> root, AnyType key)  
    {  
        // already null so return null  
        if (root == null)  
            return root;  
  
        // smaller so go left  
        if (key.compareTo(root.element) < 0)  
        {
            root.left = remove(root.left, key);  
        }
        // bigger so go right 
        else if (key.compareTo(root.element) > 0)
        {  
            root.right = remove(root.right, key);
        }  
  
        // found: key == element
        else
        {  
            // has one or no children
            if ((root.left == null) || (root.right == null))  
            {  
                BinaryNode<AnyType> temp = null;  
                if (temp == root.left)  
                    temp = root.right;  
                else
                    temp = root.left;  
  
                // no children  
                if (temp == null)  
                {  
                    temp = root;  
                    root = null;  
                }  
                else // one child
                {  
                    root = temp; // replace with single child 
                }
            }  
            else
            {  
                // two children, inorder minimum successor  
                BinaryNode<AnyType> min = findMin(root.right);  
  
                // replace with inorder successor's element
                root.element = min.element;  
  
                // remove the inorder minimum successor  
                root.right = remove(root.right, min.element);  
            }  
        } 
        // nothing so return null -- no need to rebalance  
        if (root == null)
        {  
            return root;
        }  
  
        // rebalances: 
        int balance = getBalance(root); // h(left)-h(right)
  
        // left left -- more on left so balance is pos
        if (balance > 1 && getBalance(root.left) >= 0)
        {  
            return rightRotate(root);  
        }
        
        // right right 
        if (balance < -1 && getBalance(root.right) <= 0) 
        { 
            return leftRotate(root);  
        }
  
        // left right -- more on left so balance is pos
        if (balance > 1 && getBalance(root.left) < 0)  
        {  
            root.left = leftRotate(root.left);  
            return rightRotate(root);  
        }  

        // right left  
        if (balance < -1 && getBalance(root.right) > 0)  
        {  
            root.right = rightRotate(root.right);  
            return leftRotate(root);  
        }  
  
        return root;  
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