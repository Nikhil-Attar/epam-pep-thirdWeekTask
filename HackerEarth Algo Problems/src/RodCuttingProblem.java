import java.util.*;

public class RodCuttingProblem {

	public static void main(String args[] ) throws Exception {
        // Write your code here
        
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        while(testCases>0)
        {
            int specialRods = 0;
            int length = sc.nextInt();
            
            while(length>2)
            {
                length = (length-1)/2;
                specialRods++;
            }
            
            System.out.println(specialRods);
            testCases--;
        }
        
        sc.close();
        
    }
	
}
