class RangeDemo
{
    public static void main(String args[])
    {
        rangeParse("9-10, $, $-$, 1-, 99, 9, 7, -9,3-4,10-11, 123-1456,$-9");
    }
    
    
    public static void rangeParse(String s)
    {
        String from = "DEBUG";
        String to = "DEBUG";
        s = s.replaceAll("\\s","");
        String[] args = s.split(",");
        String workArg;
        String[] tempStringHold;
        for(int i = 0; i < args.length; i++)
        {
            workArg = args[i];
            
            if (workArg.startsWith("-")) // "-#"
            {
                from = "0";
                if(workArg.split("-")[1].equals("$") ||
                    workArg.indexOf("-") == (workArg.length() - 1))
                    to = "end";
                else
                    to = workArg.split("-")[1];
            }
            else if (workArg.contains("-")) //"#-" or "#-#"
            {
                if(workArg.indexOf("-") != (workArg.length() - 1)) // "#-#"
                {
                    tempStringHold = workArg.split("-");
                    if (tempStringHold[0].equals("$")) // "$-#"
                    {
                        from = "end";
                        to = "end";
                    }
                    else if (tempStringHold[1].equals("$")) // "#-$"
                    {
                        from = tempStringHold[0];
                        to = "end";
                    }
                    else // "#-#"
                    {
                        from = tempStringHold[0];
                        to = tempStringHold[1];
                    }
                        
                }
                else //"#-"
                {
                    tempStringHold = workArg.split("-");
                    if(tempStringHold[0].equals("$"))
                        from = "end";
                    else
                        from = tempStringHold[0];
                    to = "end";

                }
            }
            else // "#"
            {
                if(workArg.equals("$"))
                {
                    from = "end";
                    to = "end";
                }
                else
                {
                    from = workArg;
                    to = workArg;
                }
            }
            System.out.println("For arg " + (i+1) + " from is: " + from + 
                               " to is: " + to);  
        }
    }
}