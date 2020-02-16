import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

interface Tools
{
    public static void print(Object ... o)
    {
        if (o.length == 0)
            System.out.print("");
        else
            System.out.print("" + o[0]);
    }
    public static void println(Object ... o)
    {
        if (o.length == 0)
            System.out.println();
        else
            System.out.println("" + o[0]);
    }
    public static String[] system(String cmd)
    {
      ArrayList<String> al = new ArrayList<>();
      String shell = "/bin/bash", option = "-c";
      if(System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1)
      {
         shell = "cmd"; option="/C";
      }
      String ar[] = {shell, option, cmd};

      try
      {
         Process p = (new ProcessBuilder(ar)).redirectErrorStream(true).start();
         Scanner sc = new Scanner(p.getInputStream());
         while(sc.hasNext()) al.add(sc.nextLine());
         sc.close();
      }catch(Exception e){System.err.println("commanmd error");}
      return(al.toArray(new String[al.size()]));
    }   
    public static void mkWrapper()
    {
	     String s = Thread.currentThread().getStackTrace()[1].getClassName();
	     String wrapperName = s;
	     File f = new File(wrapperName);
	     if(!f.exists())
	     {
	         try
	         {
	            PrintWriter pw = new PrintWriter(f);
	            pw.println("#!/bin/bash");
	            pw.println("java -cp .:$CLASSPATH $(basename $0) ${1+\"$@\"}");
	            pw.close();
	            }catch(FileNotFoundException e){System.err.println(e);}
	         }
	         try
	         { 
	             Process p;
	             p = new ProcessBuilder("chmod", "+x", f.getAbsolutePath()).start();
	         }catch(IOException e){System.err.println(e);}
    }

}