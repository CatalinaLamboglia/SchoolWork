// ComparaListInterface interface has add, get, remove, 
//   size, isEmpty methods from ComparableListArrayBased
//       
//
// Editor: Catalina Lamboglia
// Date:   March 04, 2016
//
// Input:  NONE
// Output: NONE
//
// Exceptions: NONE
//
// Classes: NONE
//

public interface ComparableListInterface
{
  public boolean isEmpty();
  public int size();
  public void add(int index, Comparable item)
                  throws ListIndexOutOfBoundsException,
                        ListException;
  public Comparable get(int index)
                        throws ListIndexOutOfBoundsException;
  public void remove(int index)
                     throws ListIndexOutOfBoundsException;
  public void removeAll();
}
