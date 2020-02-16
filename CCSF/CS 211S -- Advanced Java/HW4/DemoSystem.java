/*
 
 Author: Abbas Moghtanei 
 Date  : 09/30/14
 Program Name: DemoSystem.java
 Objective: demoing the system method that runs shell command(s).
 
*/
 
import java.util.*;
import java.io.*;
 
class DemoSystem
{
//********************************system()********************************
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
//*****************************displayArray()*****************************
   public static void displayArray(String s[])
   {
      for(String t : s) System.out.println(t);
   }
//*********************************main()*********************************
   public static void main(String args[])
   {
      displayArray(system("ls -l *.java")); 
      displayArray(system("ls -l *.java|wc -l")); 
      displayArray(system("ls -l *.java > xxx; ls xxx; rm -f xxx")); 
      displayArray(system("date; ps -ef | wc -l; time")); 
   }
}
