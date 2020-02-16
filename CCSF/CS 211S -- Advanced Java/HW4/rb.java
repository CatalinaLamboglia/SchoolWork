import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class rb
{
    public static void main(String ... args)
    {
        // mkWrapper();
        String jarFullPath;
        String path = null;
        int c;
        Scanner scan = new Scanner(System.in);
        String jarName = ".RecycleBin.jar";
        GetOpt g = new GetOpt(args, "drs");
        g.opterr(false);  // suppress display error messages 
        
        String root = 
            System.getProperty("user.home");
        
        String allJars = System.getProperty("sun.boot.class.path");
        println(allJars);
        String[] jars = allJars.split(File.pathSeparator);
        ArrayList<String> possiblePaths = new ArrayList<>();
        for(String p : jars) // All existing jars named ".RecycleBin.jar"
        {
            File pFile = new File(p);
            if(pFile.getName().equals(jarName))
                possiblePaths.add(pFile.getAbsolutePath());
        }
        if(possiblePaths.size() == 1) // Only one existing jar
            path = possiblePaths.get(0);
        else if (possiblePaths.size() > 1)
        {
            int index = 0;
            println("Your possible paths and files for " +
                jarName + "and their sizes: ");
            for(String workP : possiblePaths)
            {
                File pFile = new File(workP);
                println("[" + index++ + "] " + workP + " " +
                        pFile.length()/1024 + "KB");
            }
            print("Please enter the number within \"[]\" " +
            "of the file you want: ");
            index = scan.nextInt();
            path = possiblePaths.get(index);
        }
        
        if(path == null) // Current working dir instead
        path = root;
        
        jarFullPath= path+File.separator+jarName;
        String t[] = g.getarg(); 
        String files = "";
        for(String x : t)
        {
            if(new File(x).exists())
                files += x + " ";
        }
        boolean argPresent = false;
        for(String argument: args)
        {
            if(argument.startsWith("-"))
            argPresent = true;
        }
        if(!argPresent)
            system("jar -xf " + jarFullPath + files);
        else
        while((c = g.getopt()) != -1)
        {
            switch(c)
            {
            case 'd': system("zip -d " + jarFullPath + " *"); break;
            case 'r': system("zip -d " + jarFullPath + files); break;
            case 's': String jarFiles[] = system("jar tf " + jarFullPath);
                      System.out.println(jarFiles); break;
            case '?': System.out.println("Wrong option:"+ g.optopt());
                      System.exit(1);
            }
        }
    }
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
}