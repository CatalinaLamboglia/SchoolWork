// Shows the perfect factors of numbers 
//
// Author: Catalina Lamboglia
// Date:   Feb 10, 2016
//
// Input:  0 == number >= 1 (0 to exit program)
// Output: Perfect factors of user input.
//         Data should be all positive numbers.
//
// Exceptions: Any input other than a positive number.
//
// Classes: Factors.java asks for integer to be factored
//          and reports factors.

import java.util.Scanner; 

public class Factors
// Purpose: Takes input and passes it to showFactors method.
//
// Data:
// int: factoredNum is the number to be factored.
// Scanner: scan scans input

{
  public static void main(String []args)
  // Recieves input to pass to showFactors
  //
  // Precondition: 0 == factoredNum >= 1 
  // 0 will exit the program, 1 immediately reaches base case.
  // 
  // Postcondition: Refer to private showFactors postconditions.
  {  
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Enter the number you want to factor: ");
    System.out.println("Or enter 0 to exit the program");
    int factoredNum = scan.nextInt();
    
    while (factoredNum !=0)
    {
      System.out.println("Factors for " + factoredNum + " are:");
      showFactors(factoredNum);
       
      System.out.println("\nEnter the number you want to factor: ");
      factoredNum = scan.nextInt();
    }
  }

  public static void showFactors(int number)
  // Passes default value of 2 and number to private
  // overloaded private showFactors
  //
  // Precondition: number == 1 (will result in base case)
  // number >=2 will recieve a factor/factors of number
  // 
  // Postcondition: Refer to private showFactors postconditions.
  {
    showFactors(number, 2);
  }
  
  private static void showFactors(int number, int factor)
  // Factors number until number becomes 1 when 
  // divided by factor.
  //
  // Precondition: number == 1 (will result in base case)
  // number >=2 will recieve a factor/factors of number
  // 
  // Postcondition: if number >= 2 you will recieve the positive
  // factors of number.
  // Otherwise you will recieve a blank line.
  {
    // Base Case
    if (number == 1)
    {
      System.out.println("");
    }
    // If it doesn't factor then incriment factor
    else if (number % factor != 0)
    {
      showFactors(number, factor + 1);
    }
    // Reducing step
    else
    {
      showFactors(number/factor, factor);
      System.out.print(" " + factor);
    } 
  }
}