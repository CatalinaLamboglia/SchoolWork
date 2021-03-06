// ADT ListReferenceBased
//
// Author: Catalina Lamboglia
// Date:   March 21, 2016
//
// Input:  NONE
// Output: Booleans, linked list, int, Objects
//
// Exceptions: if index > numItems
//
// Classes: ListReferenceBased: Creates linked list and has operations for that list
//          

package List;


// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************
public class ListReferenceBased implements ListInterface
// Purpose: Manipulates a list of Objects
//
// Data:
// Node: head: References first element of linked list
// int: numItems: Number of items in the list
// 


{
  // reference to linked list of items
  private Node head;
  private int numItems; // number of items in list

  // definitions of constructors and methods
  //   . . .

  public ListReferenceBased() 
  {
    numItems = 0;
    head = null;
  }  // end default constructor

  public boolean isEmpty() 
  {
    return numItems == 0;
  }  // end isEmpty

  public int size()
  {
    return numItems;
  }  // end size

  private Node find(int index) 
  {
    // --------------------------------------------------
    // Locates a specified node in a linked list.
    // Precondition: index is the number of the desired
    // node. Assumes that 1 <= index <= numItems+1
    // Postcondition: Returns a reference to the desired
    // node.
    // --------------------------------------------------
    Node curr = head;
    for (int skip = 0; skip < index; skip++) 
    {
      curr = curr.next;
    } // end for
    return curr;
  } // end find

  public Object get(int index)
                throws ListIndexOutOfBoundsException 
  {
    if (index >= 0 && index < numItems) 
    {
      // get reference to node, then data in node
      Node curr = find(index);
      Object dataItem = curr.item;
      return dataItem;
    }
    else 
    {
      throw new ListIndexOutOfBoundsException(
                             "List index out of bounds on get");
    } // end if
  } // end get

  public void add(int index, Object item)
                  throws ListIndexOutOfBoundsException 
  {
    if (index >= 0 && index < numItems+1) 
    {
      if (index == 0) 
      {
        // insert the new node containing item at
        // beginning of list
        Node newNode = new Node(item, head);
        head = newNode;
      }
      else 
      {
        Node prev = find(index-1);

        // insert the new node containing item after
        // the node that prev references
        Node newNode = new Node(item, prev.next);
        prev.next = newNode;
      } // end if
      numItems++;
    }
    else 
    {
      throw new ListIndexOutOfBoundsException(
                             "List index out of bounds on add");
    } // end if
  }  // end add

  public void remove(int index)
                   throws ListIndexOutOfBoundsException 
  {
    if (index >= 0 && index < numItems) 
    {
      if (index == 0) 
      {
        // delete the first node from the list
        head = head.next;
      }
    else 
    {
      Node prev = find(index-1);
      // delete the node after the node that prev
      // references, save reference to node
      Node curr = prev.next;
      prev.next = curr.next;
    } // end if
    numItems--;
  } // end if
    else 
    {
      throw new ListIndexOutOfBoundsException(
                    "List index out of bounds on remove");
    } // end if
  }  // end remove

  public void removeAll() 
  {
    // setting head to null causes list to be
    // unreachable and thus marked for garbage
    // collection
    head = null;
    numItems = 0;
  } // end removeAll
  
  
  
  public int replace(Object oldValue, Object newValue)
  // Replaces oldValue in list with newValue
  //
  // Preconditions: oldValue is the same type as curr.item, 
  //                formal arguments and curr.item can be converted/cast to int
  //                
  // Postconditions: Returns replaced value as an int
  {
    
    int replaced = 0; // Count of items replaced
    
    for (Node curr = head; curr != null; curr = curr.next)
    { 
     if ((int)curr.item == ((int)oldValue))
     {
       curr.item = newValue;
       replaced++;
     }
    }
    return replaced;
  }
  
  public boolean equals(ListReferenceBased aList)
  // Returns true if the two lists are equal
  //
  // Preconditions: lists are linked list of objects
  //
  // Postconditions: Results in boolean
  { 
    Node curr;
    Node localList;
    
    
    for (curr = aList.head, localList = this.head;
          curr != null || localList != null;
           curr = curr.next, localList = localList.next)
    { 
      
      if ( (localList == null && curr != null) || (localList != null && curr == null))
      {
        return false;
      }
     
      if ((int)curr.item != (int)localList.item)
      {
        return false;
      }
    }
    return true;
  }
  
}