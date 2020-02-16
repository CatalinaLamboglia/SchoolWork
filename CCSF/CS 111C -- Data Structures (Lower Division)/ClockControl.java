import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class ClockControl extends Clock
{
  public static void main(String []args)
  {
    Clock emptyClock = new Clock();
    int hour, minute, seconds;
    int sentinel = 0;
    Scanner scan = new Scanner(System.in);
  
    System.out.println("Input an hour");
    hour = scan.nextInt();
    System.out.println("Input a minute");
    minute = scan.nextInt();
    System.out.println("Input the seconds");
    seconds = scan.nextInt();
  
    emptyClock.setTime(hour, minute, seconds);
	 
	 System.out.println("The current time is " + hour + ":" + minute + ":" +
		                     seconds);
	 
	 System.out.println("Input an hour");
    hour = scan.nextInt();
    System.out.println("Input a minute");
    minute = scan.nextInt();
    System.out.println("Input the seconds");
    seconds = scan.nextInt();
	 
	 int dif = emptyClock.timeDif(hour, minute, seconds);
	 
	 System.out.println("The difference is " + dif);
  
    while (sentinel != -99)
    {
      System.out.println("Add minutes, input -99 to exit");
	   sentinel = scan.nextInt();
	   emptyClock.addMinutes(sentinel);
	   emptyClock.display24();
  	   emptyClock.display12();
    }
  }
}