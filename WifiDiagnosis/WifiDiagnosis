import java.util.Scanner;

public class WifiDiagnosis
{
   public static void main(String[] args) { 
  
   Scanner sc = new Scanner(System.in);
   
   	   System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.");
   	   System.out.println("   ");

       System.out.print("First step: reboot the computer and try to connect.");
      
       System.out.print(" Are you able to connect with the internet? (yes or no)");
       String response = sc.nextLine();
       
       if(response.toLowerCase().equals("no")) {
    	   
    	   System.out.print("Second step: reboot the router and try to connect.");
    	      
           System.out.print(" Are you able to connect with the internet? (yes or no)");
           response = sc.nextLine();
           
           if(response.toLowerCase().equals("no")) {
        	   
        	   System.out.print("Third step: make sure the cables between the router & modem are plugged in firmly.");
        	      
               System.out.print(" Are you able to connect with the internet? (yes or no)");
               response = sc.nextLine();
               
               if(response.toLowerCase().equals("no")) {
            	   
            	   System.out.print("Fourth step: move the router to a new location and try to connect.");
            	      
                   System.out.print(" Are you able to connect with the internet? (yes or no)");
                   response = sc.nextLine();
                   
                   if(response.toLowerCase().equals("no")) {
                	   
                	   System.out.println("Fifth step: contact your ISP.");
                	   System.out.println("Make sure your ISP is hooked up to your router");
                	   
                   }else if(response.toLowerCase().equals("yes")) {
                	   System.out.print("Moving your router seemed to work");
                	   sc.close();
                   }
            	   
               } else if(response.toLowerCase().equals("yes")) {
            	   System.out.print("Checking your cables seemed to work");
            	   sc.close();
               }
               
           } else if(response.toLowerCase().equals("yes")) {
        	   System.out.print("Rebooting your router seemed to work");
        	   sc.close();
           }
    	   
       } else if(response.toLowerCase().equals("yes")) {
    	   
    	   System.out.print("Rebooting your computer seemed to work");
    	   sc.close();
       }
 
   }

} 
