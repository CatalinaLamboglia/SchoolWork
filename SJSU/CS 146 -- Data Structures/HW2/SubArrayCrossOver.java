//  Author:   Catalina Lamboglia
//  Date  :   09/27/2019
//  Homework assignment : 2
//  Objective : Finds the value n where n is the number of elements
//              in an array where the brute force solution 
//              loses to recursive solution
//              of the maximum sum subarray problem
//****************************************************************

import java.lang.Math;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class SubArrayCrossOver
{
    public static void main(String args[])
    {
        long startTime;
        long endTime;
        long bruteTime;
        long recursiveTime;
        
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        testArray.add(rand());
        
        startTime = System.nanoTime();
        bruteForce(testArray.toArray(new Integer[testArray.size()]));
        endTime = System.nanoTime();
        bruteTime = endTime - startTime;
        
        startTime = System.nanoTime();
        maxSub(testArray.toArray(new Integer[testArray.size()]), 0, testArray.size() - 1);
        endTime = System.nanoTime();
        recursiveTime = endTime - startTime;
        
        System.out.println("N is: " + testArray.size());
        System.out.println("Time for Brute: " + bruteTime);
        System.out.println("Time for Recursion: " + recursiveTime);
        
        while (testArray.size() < 25)
        {
            testArray.add(rand());
            startTime = System.nanoTime();
            bruteForce(testArray.toArray(new Integer[testArray.size()]));
            endTime = System.nanoTime();
            bruteTime = endTime - startTime;
        
            startTime = System.nanoTime();
            maxSub(testArray.toArray(new Integer[testArray.size()]), 0, testArray.size() - 1);
            endTime = System.nanoTime();
            recursiveTime = endTime - startTime;
          
            System.out.println("N is: " + testArray.size());
            System.out.println("Time for Brute: " + bruteTime);
            System.out.println("Time for Recursion: " + recursiveTime);
        }

        
        
    }
    
    public static Integer rand()
    {
        Random random = new Random();
        return (random.nextInt(50 + 50) - 50);
    }
    
    public static void bruteForce(Integer a[])
    {
        Integer n = a.length;
        Integer max = -9999999;
        Integer sum;
        Integer low;
        Integer high;
        for (Integer i = 0; i < n; i++)
        {
            sum = 0;
            for (Integer j = 0; j < n; j++)
            {
                sum = sum + a[j];
                if (sum > max)
                {
                    max = sum;
                    low = i;
                    high = j;
                }
            }
        }
    }
    
    public static Integer[] maxCrossing(Integer a[], Integer low, Integer mid, Integer high)
    {
        Integer leftSum = -999999;
        Integer sum = 0;
        Integer maxLeft = 0;
        for (Integer i = mid; i > low; i--)
        {
            sum = sum + a[i];
            if (sum > leftSum)
            {
                leftSum = sum;
                maxLeft = i;
            }
        }
        Integer rightSum = -9999999;
        sum = 0;
        Integer maxRight = 0;
        for (Integer j = mid+1; j < high; j++)
        {
            sum = sum + a[j];
            if( sum > rightSum)
            {
                rightSum = sum;
                maxRight = j;
            }
        }
        Integer[] returned = {maxLeft, maxRight, leftSum+rightSum};
        return returned;
    }
    
    public static Integer[] maxSub(Integer a[], Integer low, Integer high)
    {
        if (high == low)
        {
            Integer basecase[] = {low, high, a[low]};
            return basecase;
        }
        else
        {
            Integer mid = (int)Math.floor((low+high)/2);
            
            Integer leftLow, rightLow, crossLow;
            Integer leftHigh, rightHigh, crossHigh;
            Integer leftSum, rightSum, crossSum;
            
            Integer returnedLeft[] = new Integer[3];
            Integer returnedRight[] = new Integer[3];
            Integer returnedCross[] = new Integer[3];
            
            returnedLeft = maxSub(a, low, mid);
            returnedRight = maxSub(a, mid+1, high);
            returnedCross = maxCrossing(a, low, mid, high);
            
            leftLow = returnedLeft[0];
            leftHigh = returnedLeft[1];
            leftSum = returnedLeft[2];
            
            rightLow = returnedRight[0];
            rightHigh = returnedRight[1];
            rightSum = returnedRight[2];
            
            crossLow = returnedCross[0];
            crossHigh = returnedCross[1];
            crossSum = returnedCross[2];
            
            if((leftSum >= rightSum) && (leftSum >= crossSum))
                return returnedLeft;
            else if ( (rightSum >= leftSum) && (rightSum >= crossSum))
                return returnedRight;
            else
                return returnedCross;
            
        }
    }
}