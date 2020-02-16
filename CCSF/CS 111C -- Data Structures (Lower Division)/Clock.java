public class Clock  
{
   private int minute, hour, seconds;

   public Clock()
	{
	  minute = 0;
	  hour = 0;
	  seconds = 0;
	}

   public Clock(int h, int  m, int s)
	{
	  hour = h;
	  minute = m;
	  seconds = s;
	}
 
  public void setTime(int h, int m, int s)
  {
     hour = h;
	  minute = m;
	  seconds = s;
  }  
  
  public void addSeconds()
  {
    seconds++;
	 
	 if (seconds > 59)
	 {
	   seconds = 0;
		minute++;
    }
	 
	 if (minute > 59)
	 {
	   minute = 0;
		hour++;
	 }
	 
	 if (hour > 24)
	 {
	   hour = 0;
	 }
  }
  
  public int timeDif(int h, int m, int s)
  {
     int total;
     int sum1 = h * 3600 + m * 60 + s;
	  int sum2 = hour * 3600 + minute * 60 + seconds;
	  total = sum1 - sum2; 
	  if (total < 0)
	      total = total * -1;
	  return total;   

  }
  
  public void addMinutes(int m)
  {
    minute = minute + m;
	  
  	 if (minute > 59)
	 {
		hour = hour + Math.round(minute / 60);
		minute = minute % 60;
	 }
	 
	 if (hour > 24)
	 {
	   hour = hour % 24;
	 }
  }
  
  public void display12()
  {
    if (hour > 12)
	 {
	   int hourAM = hour - 12;
	   System.out.println("The current time is " + hourAM + ":" + minute + ":" +
		                     seconds + " PM");
	 }
	 else
	 {
	   System.out.println("The current time is " + hour + ":" + minute + ":" +
		                     seconds + " AM");
	 }
  }
  
  public void display24()
  {
    if (hour > 10)
	 {
      System.out.println("The current time is " + hour + ":" + minute + ":" +
		                     seconds);
	 }
	 else
	 {
	   System.out.println("The current time is 0" + hour + ":" + minute + ":" +
		                     seconds); 
	 }
  }
  
}