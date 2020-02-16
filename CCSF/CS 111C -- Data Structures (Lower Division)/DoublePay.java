public class DoublePay
{
  public static void main(String []args)
  {  
    payDouble(1, 31, 1);
   
  }

  private static void payDouble(int pay, int days, int current)
  {
    if (current == days)
    {
      System.out.println("Your total pay will be " + pay);
    }
    
    else
    {
	   System.out.println("Day " + current + " pay is " + pay);
      payDouble(pay * 2, days, current + 1);
    } 
  }
}