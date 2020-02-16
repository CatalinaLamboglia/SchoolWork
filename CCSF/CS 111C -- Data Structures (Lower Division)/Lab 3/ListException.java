// ListException calls super
//
// Author: Catalina Lamboglia
// Date:   March 21, 2016
//
// Input:  NONE
// Output: NONE
//
// Exceptions: NONE
//
// Classes: ListException: calls super
//      

package List;

public class ListException extends RuntimeException {
  public ListException(String s) {
    super(s);
  }  // end constructor
}  // end ListException