// Driver program for the ADT ListReferenceBased
//
// Author: Catalina Lamboglia
// Date:   March 21, 2016
//
// Input:  integers
// Output: Linked list of integers, whether the list is equal,
//         integer for number of items replaced
//
// Exceptions: input anything other than an int when making case selection
//
// Classes: ListReferenceBasedDriver: Manipulates linked lists to replace values,
//                                      or check for equality of lists
//          
package List;

import java.io.*;
import java.util.Scanner;

public class ListReferenceBasedDriver extends ListReferenceBased
// Purpose: Manipulates a list of Objects
//
// Data:
// String: holder holds an int from scanner
// int: sentinel: determines switch statement and ends while if == 3
// int: j controls index increase for add method (j + 1 for each while loop)
// int: listSize: stores list.size() to free up memory in for loop
// int: replaceValue: value to be replaced
// int: modValue: value that replaced value will be modified to
// int: numberReplaced: number of items replaced
// Scanner: scan: recievces user input
// Scanner intContainer: parses string into ints for add method
// ListReferenceBased: list: first linked list, to be used in both equals and replace methods
// ListReferenceBased: list2: second linked list, used solely in equals method

{
  public static void main(String []args)
  // Recieves input to pass to ListReferenceBased
  //
  // Precondition: ints are inputted at the correct time 
  //               (When prompted for option selection, and the value to be replaced
  //                                                    /what to replace to)
  //               
  // Postcondition: Option 1: List with replaced values
  //                Option 2: Output stating whether the lists are equal
  {
    String holder;      // Scanner integer holder for add method
    int sentinel = 0;
    int j = 0;          // Secondary index counter
    int listSize;
    int replaceValue;   // Value to be replaced
    int modValue;       // Value to change to
    int numberReplaced; // replace method's return value

    Scanner scan = new Scanner(System.in);
    Scanner intContainer;
    ListReferenceBased list = new ListReferenceBased();
    ListReferenceBased list2 = new ListReferenceBased();
    
    
    while (sentinel != 3)
    { 
      j = 0;
      
      System.out.println("What do you want to do?");
      System.out.println("1) Replace a value in a list of integers");
      System.out.println("2) Compare two lists of integers");
      System.out.println("3) Quit");
      System.out.print("Enter your choice: ");
      sentinel = scan.nextInt();
      
      scan.nextLine(); //Cleaning the buffer
      
      switch(sentinel)
      {
        case 1: //To change values
        {
          j = 0;
          System.out.print("Input a list of integers deliminted by a space: ");
          holder = scan.nextLine();
          intContainer = new Scanner(holder);
          while (intContainer.hasNext())
          {
            intContainer.useDelimiter("\\s+");
            list.add(j,intContainer.nextInt()); //adds in the index after the previous (first at 0, then 1, 2... n)
            j++;
          }
          System.out.print("Enter a value to be modified: ");
          modValue = scan.nextInt();
          System.out.println();
          
          System.out.print("Enter a replacement value: ");
          replaceValue = scan.nextInt();
          System.out.println();
          
          numberReplaced = list.replace(modValue, replaceValue);
          
          System.out.print("Modified List: ");
          listSize = list.size();
          for(int i = 0; i < listSize; i++)
          {
            System.out.print(list.get(i) + " ");
          }
          System.out.println("");
          System.out.println("Number of items replaced: " + numberReplaced);
          scan.nextLine();  // Cleaning the buffer
          System.out.println();
          break;
        }
        case 2: //Check for equality
        {
          j = 0;
          
          System.out.print("Enter first list to be compared: ");
          holder = scan.nextLine();
          System.out.println();
          intContainer = new Scanner(holder);
          while (intContainer.hasNext())
          {
            intContainer.useDelimiter("\\s+");
            list.add(j,intContainer.nextInt()); //adds in the index after the previous (first at 0, then 1, 2... n)
            j++;
          }
          
          j = 0;
          System.out.print("Enter second list to be compared: ");
          holder = scan.nextLine();
          System.out.println();
          intContainer = new Scanner(holder);
          while (intContainer.hasNext())
          {
            intContainer.useDelimiter("\\s+");
            list2.add(j,intContainer.nextInt()); //adds in the index after the previous (first at 0, then 1, 2... n)
            j++;
          }
          
          
          if (list.equals(list2) == true)
          {
            System.out.println("The two lists are equal");
          }
          else
          {
            System.out.println("The two lists are not equal");
          }
          System.out.println();
          break;
        }
        case 3:
        break;
        
        default:
        {
          System.out.println("Invalid input. Please enter 1, 2, or 3.");
          break;
        }
      }
 
      list = new ListReferenceBased();
      list2 = new ListReferenceBased();
      
    } // end of while
  }// end of main
}