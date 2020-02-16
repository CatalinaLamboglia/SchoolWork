// Driver program for the ADT ComparableListArrayBased
//
// Author: Catalina Lamboglia
// Date:   March 04, 2016
//
// Input:  integers and string as a sentinel
// Output: List of integers, whether the list is in ascending order
//
// Exceptions: if user input is not an integer/string when required
//
// Classes: ComparableListArrayBasedDriver.java Takes user input and passes into
//            ComparableListArrayBased.java
//          

import java.io.*;
import java.util.Scanner;

public class ComparableListArrayBasedDriver extends ComparableListArrayBased
// Purpose: Manipulates a list of Comparables
//
// Data:
// int: holder holds an int from scanner
// int: listSize holder for list size to reduce memory usage (from for loop calls)
// int: j controls index increase for add method (j + 1 for each while loop)
// String: sentinel the sentinel for the while loop, n/N to exit loop
// String: n holds "n" for sentinel equals 
// boolean: asc and ascDependant hold evaluation for respective methods
// ComparableListArrayBased: list list of comparables
{
  public static void main(String []args)
  // Recieves input to pass to ComparableListArrayBased
  //
  // Precondition: holder recieves an integer
  //               j <= MAX_SIZE which is 50,
  //               sentinel recieves a string
  //               
  // Postcondition: List of integers and whether theyre in ASC order
  {
    String holder; // Scanner integer holder for add method
    int j = 0; // Secondary index counter
    int listSize;
    String sentinel = "initial";
    String n = "n";  //"no"
    boolean asc = true;
    boolean ascDependant = true;  
    ComparableListArrayBased list = new ComparableListArrayBased();

    Scanner scan = new Scanner(System.in);
    Scanner intContainer;
    
    
    while (sentinel.equalsIgnoreCase(n) != true)
    { 
      j = 0;

      System.out.println("Input a list of integers deliminted by a space: ");
      holder = scan.nextLine();
      intContainer = new Scanner(holder);
      while (intContainer.hasNext())
      {
        intContainer.useDelimiter("\\s+");
        list.add(j,intContainer.nextInt());     //adds in the index after the previous (first at 0, then 1, 2... n)
        j++;
      }
      
            
      System.out.print("List of integers as of now: ");
      listSize = list.size();
      for(int i = 0; i < listSize; i++)
      {
        System.out.print(list.get(i) + " ");
      }
      
      asc = isInAscendingOrder(list);  // Independant of impementation method
      if (asc == true)
      {
        System.out.println("\nYour list of integers is in ascending order");
      }
      else
      {
        System.out.println("\nYour list of integers is not in ascending order");
      }
      
      ascDependant = list.isInAscendingOrder();  //Dependant of implementation method
      if (ascDependant == true)
      {
        System.out.println("Your list of integers is in ascending order");
      }
      else
      {
        System.out.println("Your list of integers is not in ascending order");
      }
      
      System.out.println("Do you want to continue? [Y/N] (Single Letter)");
      sentinel = scan.nextLine();
      
      list = new ComparableListArrayBased();
      
     }
  }
}