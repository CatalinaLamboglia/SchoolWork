//  Author:   Catalina Lamboglia
//  Date  :   09/06/16
//  Homework assignment : 1
//  Objective : This program generates an array of IP Addresses,
//              sorts them, and shows the desired head and tail amounts
//****************************************************************
public class IPAddress
{
    //*********************************main()*********************************
    public static void main(String args[])
    {
        IPAddress ip = new IPAddress();
        String[] unique = ip.ugen(25000);
        String[] nonUnique = ip.gen(25000);
        
        println("Top 10 of nonUnique");
        ip.head(nonUnique, 10);
        println("\n" + "Tail 10 of unique");
        ip.tail(unique, 24990);
        println("\n" + "Top 10 of sortedUniq");
        String[] sortedUniq = ip.sort(unique);
        ip.head(sortedUniq, 10);
        
    }
    
    
    //******************************IPAddress()*******************************
    public IPAddress(){}
    
    //*********************************gen()**********************************
    public String[] gen(int n)
    //  Generates an array of n elements filled with non-unique
    //  IP addresses
    //  Precon : non negative parameter of type int
    //  Postcon: Array of n elements filled with unique
    //           IP addresses
    {
        if (n < 0) // Default statement
        {
            println("Parameter must be a positive integer.");
            println("Number of elements will now default to 25000.");
            n = 25000;
        }
        String[] tempAddress = new String[n];
        for (int i = 0; i < n; i++)
        {
            tempAddress[i] = new String(rand(0,255) +"." +
            rand(0,255) + "." + rand(0,255) + "." + rand(0,255));
        }
        return tempAddress;
    }
    
    //*********************************ugen()*********************************
    public String[] ugen(int n)
    //  Generates an array of n elements filled with unique
    //  IP addresses
    //  Precon : Formal parameter is an integer
    //  Postcon: Array of n elements filled with unique
    //           IP addresses
    {
        if (n < 0) // Default statement
        {
            println("Parameter must be a positive integer.");
            println("Number of elements will now default to 25000.");
            n = 25000;
        }
        String[] tempAddress = new String[n];
        String holder; // String to check against rest of array
        boolean duplicate = false;
        
        tempAddress[0] = new String(rand(0,255) + "." +
        rand(0,255) + "." + rand(0,255) + "." + rand(0,255));
        
        for (int i = 1; i < n; i++)
        {
            holder = new String(rand(0,255) + "." +
            rand(0,255) + "." + rand(0,255) + "." + rand(0,255));
            
            for (int f = 0; f > i; f++) // Check for conflicts
            {
                if (holder.equals(tempAddress[f]))
                {
                    duplicate = true;
                    holder = new String(rand(0,255) + "." +
                    rand(0,255) + "." + rand(0,255) + "." + rand(0,255));
                }
                
                if (duplicate) // Begin from 0 and reprocess
                {
                    duplicate = false;
                    f = 0;
                }
            }
            // After all conflicts are resolved, add to array
            tempAddress[i] = holder;
        }
        return tempAddress;
    }
    
    
    //*********************************head()*********************************
    public void head(String[] s, int n)
    //  Prints top n elements of array s
    //  Precon : Formal parameters are of the correct data types
    //  Postcon: Print lines of top n elements of array s
    {
        final int NUM_ELEM = s.length; // Save memory
        if (n > NUM_ELEM) // Print entire array if n is out of bounds
        {
            n = NUM_ELEM;
            println("Supplied 'print limit' (the second parameter)"+
            " is out of bounds," +
            " entire array will be printed instead.");
            for(String s1 : s)
            println(s1);
        }
        else
        {
            for (int i = 0; i < n; i++)
            println(s[i]);
        }
        
        
    }
    
    //*********************************tail()*********************************
    public void tail(String[] s, int n)
    //  Prints last n elements of array s
    //  Precon : Formal parameters are of the correct data types
    //  Postcon: Print lines of last n elements of array s
    {
        final int NUM_ELEM = s.length; // Save memory
        if (n > NUM_ELEM)
        {
            println("Supplied 'print start' (the second parameter)"+
            " is out of bounds," +
            " last half of the array will be printed instead.");
            for(n = NUM_ELEM / 2; n < NUM_ELEM; n++)
                 println(s[n]);
        }
        else
        {
            for(; n < NUM_ELEM; n++)
                 println(s[n]);
        }
        
    }
    
    //*********************************sort()*********************************
    public String[] sort(String s[])
    //  Sorts array of strings
    //  Precon : Formal parameter is of the correct data type
    //  Postcon: Sorted array of strings
    {
        
        final int NUM_ELEM = s.length;
        String[] tempAddress = new String[NUM_ELEM];
        
        for(int i = 0; i < NUM_ELEM; i++)
             tempAddress[i] = s[i];
        
        java.util.Arrays.sort(tempAddress);
        return tempAddress;
    }
    
    //*******************************println()********************************
    public static void println(Object ... o)
    {
        if (o.length == 0)
            System.out.println();
        else
            System.out.println("" + o[0]);
    }
    
    //*********************************rand()*********************************
    public int rand(int a, int b)
    {
        return ((int)((b - a + 1) * Math.random() + a));
    }
}
