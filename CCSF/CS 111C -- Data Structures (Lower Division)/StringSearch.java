import java.util.Scanner;
public class StringSearch
{
  public static void main(String []args)
  {  
    String[] sArray = {"a", "abso", "absolve", "bxz", "chair", "ywx", "yzx", 
	                      "zebra", "zz"};
	 Scanner scan = new Scanner(System.in);
	 
	 System.out.println("Enter your string: ");
	 String search = scan.nextLine();
	 
	 int index = binarySearch(sArray, 0, 15, search);
	 
	 
	 System.out.println("The searched string was " + search + " and it was found at index " + index);
	 System.out.println("The array of strings is as follows: ");
	 
	 for(int i = 0; i < sArray.length; i++)
	 {
	   System.out.println("String " + sArray[i] + " at index " + i);
    }
  }


  public static int binarySearch(String anArray[], int first,
                               int last, String s) 
  {
    int index;
    if (first > last) {
      index = -1;      // value not in original array
    }
    else {
      // Invariant: If value is in anArray,
      //            anArray[first] <= value <= anArray[last]
      int mid = (first + last)/2;
      if (s.compareTo(anArray[mid]) == 0) {
        index = mid;  // value found at anArray[mid]
      }
      else if (s.compareTo(anArray[mid]) < 0) {
        // point X
        index = binarySearch(anArray, first, mid-1, s);
      }
      else {
        // point Y
        index = binarySearch(anArray, mid+1, last, s);
      }  // end if
    }  // end if

    return index;
  }  // end binarySearch
}
