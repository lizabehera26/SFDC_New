import java.util.Scanner;

public class time_inwords {
	public static void printtime(int h ,int m) {
		
		
		String nums[] = {
				 "zero", "one", "two", "three", "four", 
                 "five", "six", "seven", "eight", "nine", 
                 "ten", "eleven", "twelve", "thirteen", 
                 "fourteen", "fifteen", "sixteen", "seventeen", 
                 "eighteen", "nineteen", "twenty", "twenty one", 
                 "twenty two", "twenty three", "twenty four", 
                 "twenty five", "twenty six", "twenty seven", 
                 "twenty eight", "twenty nine", 
             }; 

    if (m == 0) {
    	System.out.println(nums[h] + " o'clock");
	
		}
    else if(m==1) {
    	System.out.println(" one minute past " +nums[h]);
    }
    else if(m==30) {
    	System.out.println(" half past " + nums[h]);
    }
    else if(m<30) {
    	System.out.println(nums[m]+" minutes past " +nums[h]);
    }
    else if(m==45) {
    	System.out.println(" quarter to " +nums[(h%12)+1]);
    }
    else if(m>30) {
    	System.out.println(nums[60-m]+ " minutes to " +nums[(h%12)+1]);
    }


	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		System.out.println("Your entered hour is " +s);
		int k = sc.nextInt();
		System.out.println("Your entered minute is" +k);
		printtime( s,k );
		
		/*printtime(5,0);
		printtime(5,1);
		printtime(5,10);
		printtime(5,15);
		printtime(5,30);
		printtime(5,40);
		printtime(5,45);
		printtime(5,47);
		printtime(5,28);*/
		

	}
	
	

}
