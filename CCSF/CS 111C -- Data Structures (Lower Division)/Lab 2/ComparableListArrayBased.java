// ADT ComparableListArrayBased
// add comparables, get comparables from a list,
// checks if list is in ascending order
//
// Editor: Catalina Lamboglia
// Date:   March 04, 2016
//
// Input:  NONE
// Output: List of comparables, boolean, comparable
//
// Exceptions: if list's size > MAX_LIST, out of bounds for adding to
//             or getting from list (index > MAX_LIST)
//
// Classes: ComparableListArrayBased.java manipulates Comparable objects
//          


// ********************************************************
// Array-based implementation of the ADT list.
// *********************************************************
public class ComparableListArrayBased implements 
                                ComparableListInterface 
// Purpose: Manipulates a list of Comparables
//
// Data:
// int: numItems is the number of items in the list
// Comparable: items list of comparables
{
  private static final int MAX_LIST = 50;
  private Comparable items[];  // an array of Comparables
  private int numItems;  // number of items in list

  public ComparableListArrayBased() 
  {
    items = new Comparable[MAX_LIST];
    numItems = 0;
  }  // end default constructor

  public boolean isEmpty() 
  {
    return (numItems == 0);
  } // end isEmpty

  public int size() 
  {
    return numItems;
  }  // end size

  public void removeAll() 
  {
    // Creates a new array; marks old array for
    // garbage collection.
    items = new Comparable[MAX_LIST];
    numItems = 0;
  } // end removeAll

  public void add(int index, Comparable item)
                  throws  ListIndexOutOfBoundsException 
  // Returns true of list of integers is in ascending order otherwise returns
  //    false
  // Preconditions: list is an array of comparables
  // Postconditions: Results in boolean
  {
    if (numItems >= MAX_LIST) 
    {
      throw new ListException("ListException on add");
    }  // end if
    if (index >= 0 && index <= numItems) 
    {
      // make room for new element by shifting all items at
      // positions >= index toward the end of the
      // list (no shift if index == numItems+1)
      for (int pos = numItems - 1; pos >= index; pos--) 
      {
          items[pos+1] = items[pos];
      } // end for
      // insert new item
      items[index] = item;
      numItems++;
    }
    else 
    {  // index out of range
      throw new ListIndexOutOfBoundsException(
       "ListIndexOutOfBoundsException on add");
    }  // end if
  } //end add

  public Comparable get(int index)
                    throws ListIndexOutOfBoundsException 
  // Returns item at formal argument index
  // Preconditions: index is >=0 and less than the number of items in the list
  // Postconditions: Returns object at given index, comparable object
  {
    if (index >= 0 && index < numItems) 
    {
      return items[index];
    }
    else  
    {  // index out of range
      throw new ListIndexOutOfBoundsException(
        "ListIndexOutOfBoundsException on get");
    }  // end if
  } // end get

  public void remove(int index)
                     throws ListIndexOutOfBoundsException 
  // Removes item from the list
  // 
  // Preconditions: index >= 0 and index < number of items
  // Postconditions: List has items-1 and all items with index > formal
  //                 argument index are now index - 1
  {
    if (index >= 0 && index < numItems) 
    {
      // delete item by shifting all items at
      // positions > index toward the beginning of the list
      // (no shift if index == size)
      for (int pos = index; pos <= numItems; pos++) 
      {
        items[pos-1] = items[pos];
      }  // end for
      numItems--;
    }
    else 
    {  // index out of range
        throw new ListIndexOutOfBoundsException(
        "ListIndexOutOfBoundsException on remove");
    }  // end if
  } // end remove

  public static boolean isInAscendingOrder(ComparableListArrayBased list)
  // Returns true of list of integers is in ascending order otherwise returns
  //    false
  // Preconditions: list is an array of comparables
  // Postconditions: Results in boolean
  { 
    if (list.size() <= 1)  // If there are 1 or less items then its already ASC
    {
      return true;
    }
    
    for(int i = 0; i < list.size(); i++)
    {
      if (i + 2 > list.size()) // Index check
      {
        return true;
      }

      int indexI = (int)list.get(i);  // Readability
      int IndexIPlusOne = (int)list.get(i + 1);

      if (indexI > IndexIPlusOne)
      {
        return false;
      }
    } 
    
     return true;
  }

  public boolean isInAscendingOrder()
  // Returns true of list of integers is in ascending order otherwise returns
  //    false
  // Preconditions: Used on array of comparables AND ComparableListArrayBased object
  // Postconditions: Results in boolean
  {
    if (numItems <= 1) // If there are 1 or less items then its already ASC
    {
      return true;
    }
    
    for(int i = 0; i < numItems; i++)
    {
      if (i + 2 > numItems) // Index check
      {
        return true;
      }
      if ((int)items[i].compareTo((int)items[i+1]) > 0)
      {
        return false;
      }

    }
    
    return true;
  }
  
}  // end ListArrayBased
