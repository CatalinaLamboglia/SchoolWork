// Nodes for Linked List
//
// Author: Catalina Lamboglia
// Date:   March 21, 2016
//
// Input:  NONE
// Output: NONE
//
// Exceptions: NONE
//
// Classes: Node: for Linked List structure
//      

package List;

class Node
{
  Object item;
  Node next;
  
  Node (Object newItem)
  {
    item = newItem;
    next = null;
  }
  
  Node (Object newItem, Node nextNode)
  {
    item = newItem;
    next = nextNode;
  } 
}