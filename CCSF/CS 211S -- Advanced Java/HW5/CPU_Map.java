import java.util.*;
import java.io.*;

public class CPU_Map implements Tools
{
    public static void main(String ... args)
    {
        ArrayList<HashMap> cpuList = new ArrayList<HashMap>();
        HashMap<String,String> cpu = new HashMap<String,String>();
        try{
            Scanner cpuFile = new Scanner(new File("cpuinfo"));
            while(cpuFile.hasNext())
            {
                String[] kv = cpuFile.nextLine().split(":");
             //   Tools.println(kv.length + " " + kv[0]);
             //   Tools.println(kv[0] +"w");
                kv[0]= kv[0].trim();
             //   Tools.println(""+kv[0] + "w");
                if(cpu.isEmpty() || !kv[0].contains("processor"))
                {
                    if(kv.length == 2)
                    cpu.put(kv[0],kv[1]);
                    else if(kv.length == 1)
                    cpu.put(kv[0], null);
                }
                else if(kv[0].contains("processor"))
                {
                    cpuList.add(cpu);
                    cpu = new HashMap<>();
                    cpu.put(kv[0],kv[1]);
                } 
            }
            cpuList.add(cpu);
            
     /*       for(HashMap map : cpuList)
            {
                ArrayList<String> mapElems = new ArrayList<>();
                mapElems.addAll(map.values());
                for(String e : mapElems)
                Tools.println(e);
            }
       */     String cpu3 = (String)cpuList.get(2).get("core id");
           // Tools.println(cpu3);
            String cpu5 = (String)cpuList.get(4).get("core id");
           // Tools.println(cpu5);
            String cpu4 = (String)cpuList.get(3).get("cpu MHz");
          //  Tools.println(cpu4);
            
            String flags = (String)cpuList.get(1).get("flags");
          //  Tools.println(flags);
            String[] cpu2 = flags.split("\\s+");
            //Tools.println("cpu2");
        
            Tools.println("CPU 3's core id is: " + cpu3);
            Tools.println("CPU 5's core id is: " + cpu5);
            Tools.println("CPU 2's MHz is: " + cpu4);
            Tools.println("The number of flags for CPU 2 is: " + cpu2.length);
            Tools.println("CPU 2's flags are: ");
            for(String flag : cpu2)
                Tools.print(flag + " ");
        }catch(FileNotFoundException e){Tools.println(e);}
    }
}