//  Author:   Catalina Lamboglia
//  Date  :   09/27/2019
//  Homework assignment : 2
//  Objective : Max Heapifies a Heap
//****************************************************************

import java.lang.Math;

public class MaxHeapify
{
    public static void main(String args[])
    {
        int array[] = {0, 15, 2, 18, 7, 4, 14, 20, 71, 6, 3};
        threeLargest(array);
        for( int i = (int)Math.floor(array.length - 2); i > 0; i--)
            maxHeapify( array, i );
        String output = "Array is as follows: ";
        for (int a : array)
        {
            output = output + a + ", ";
        }
        System.out.println(output);
        
        
    }
    
    public static void maxHeapify(int a[], int i)
    {
         int l = i * 2;
         int largest;
         int r = (i * 2) + 1;
         int temp;
         if ((l <= a.length-1) && (a[l] > a[i]))
             largest = l;
         else
             largest = i;
         if ((r <= a.length-1) && (a[r] > a[largest]))
             largest = r;
         if (largest != i)
         {
         
             temp = a[i];
             a[i] = a[largest];
             a[largest] = temp;
             maxHeapify(a, largest);
         }
    }
    
    public static void threeLargest(int array[])
    {
        int largest = array[0];
        int secondLargest = -9999999;
        int thirdLargest = -9999999;
        int temp;
        int secondTemp;
        
        for(int i = 1; i < array.length; i++)
        {
             if (array[i] >= largest)
             {
                 temp = largest;
                 largest = array[i];
                 secondTemp = secondLargest;
                 secondLargest = temp;
                 thirdLargest = secondTemp;
             }
             else if (array[i] >= secondLargest)
             {
                 temp = secondLargest;
                 secondLargest = array[i];
                 thirdLargest = temp;
             }
             else if (array[i] >= thirdLargest)
                 thirdLargest = array[i];
         }
         System.out.println(largest + " " + secondLargest +" " + thirdLargest);
    
    }
}
