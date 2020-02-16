import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

// TO DO:
// CHECK IF JAR EXISTS
// CHECK FOR CONFLICTS WHEN ADDING TO JAR
// PROMPT USER IF THEY WANT TO OVERWRITE THE FILE
// IN THE JAR, IF SO, ASK FOR CORRECT NAME
// USE SYSTEM TO RENAME FILE
// CANCEL STATEMENT FOR PROMPT SHOULD USE ILLEGAL CHARACTER
// I.E. WHATEVER WINDOWS/LINUX DOESNT ACCEPT AND REALLY WEIRD
// I.E. ABORT_##!


public class srm
{
    public static void main(String ... args)
    {
       // mkWrapper();
        String root = null;
        String path = null;
        Boolean added = false;
        String jarName = ".RecycleBin.jar";
        Scanner scan = new Scanner(System.in);
        
        // Default jar location: root
        root = 
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
        if(possiblePaths.size() == 1) // Only one existing
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
            print("Please enter the number within \"[]\" of the file you want: ");
            index = scan.nextInt();
            path = possiblePaths.get(index);
        }
        
        if(path == null) // Current working dir instead
        path = root;
        //    path = System.getProperty("user.dir");
        File rbJar = new File(path + File.separator + jarName);
        if(!rbJar.exists())
        system("jar -cf " + path + File.separator + jarName);
        
        println("Your jar is placed in: " + path);
        String argument = "";
        String fullPath = path + File.separator + jarName;
        String jarFiles[] = system("jar tf " + fullPath);
        boolean renamed = false;
        for(int i = 0; i < args.length; i++)
        {
            String yn = "";
            try{
                File f = new File(args[i]);
                if(f.exists() && !f.isDirectory()) // FILE
                {
                    for(String jF : jarFiles)
                    {
                        if(jF.equals(f.getName()))
                        {
                            println("File " + f.getName() + " already exists within " +
                            "your jar file.");
                            print("Would you like to overwrite it? [Y/N]");
                            yn = scan.nextLine();
                            if(yn.equalsIgnoreCase("y") ||
                               yn.equalsIgnoreCase("yes"))
                            {
                                system("jar -uf " + path + jarName
                                   + " " + args[i]);
                            }
                            else
                            {
                                println("Retaining both copies. The name of original file is " +
                                jF);
                                print("Please input the new filename you'd like: ");
                                yn = scan.nextLine();
                                system("mv " + args[i] + " " + yn);
                                system("jar -uf " + path + jarName
                                + " " + yn);
                                renamed = true;
                            }
                        }
                        added = true;
                   
                    }
                    if(!added)
                    {
                        system("jar -uf " + path + jarName
                               + " " + args[i]);
                        added = true;
                    }
                    if(renamed)
                    argument += yn;
                    else
                    argument += args[i]; 
                }
                else if(f.exists() && f.isDirectory()) // DIRECTORY
                {
                    for(int j = 0; j < args.length; i++)
                    {
                        if(args[j].startsWith("--") &&
                        args[j].contains("directory"))
                        {
                            argument+= args[i]; //add dir, not option
                            system("jar -uf " + root + jarName
                            + " " + args[i]);
                            added = true;
                        }
                    }
                }
            }catch(Exception e) {System.err.println(e);}
            // Test if args[i] is an option
            if (!added && args[i].startsWith("-") && // OPTION, possibly
               (args[i].contains("--version") ||
            args[i].contains("v") || args[i].contains("--verbose") ||
            args[i].contains("r") || args[i].contains("R") ||
            args[i].contains("--help") || args[i].contains("d") ||
            args[i].contains("--interactive") ||
            args[i].contains("f") || args[i].contains("--force") ||
            args[i].contains("--directory") || 
            args[i].contains("--preserve-root") ||
            args[i].contains("--no-preserve-root")))
            argument += args[i];
            else // File not found
            {
                println("File " + args[i] + " does not exist." +
                " Proceeding...");
            }
            added = false;
        }
        
        callRM(argument);
    }
    
    public static void callRM(String arg)
    {system("rm " + arg);}
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