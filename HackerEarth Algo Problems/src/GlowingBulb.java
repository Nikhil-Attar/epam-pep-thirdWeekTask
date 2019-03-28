
import java.util.*;
 
class GlowingBulb {
    public static void main(String args[] ) throws Exception {
       
        Scanner sc = new Scanner(System.in);
        long testCase = Long.parseLong(sc.nextLine());
 
        while((testCase--) > 0){
            String Switch = sc.nextLine();
            
            long k = Long.parseLong(sc.nextLine());
            long result = solve(Switch, k);
            System.out.println(result);
            sc.close();
        }
    }
    
    public static long solve(String Switch, long k){
        ArrayList<Integer> onSwitches = new ArrayList<>();
        long first_switch = -1;
        for(int i=0;i<Switch.length();i++){
            if(Switch.charAt(i) == '1'){
                if(first_switch == -1)
                    first_switch = i+1;
                onSwitches.add(i+1);
            }
        }
        
        long sol = 0;
        long l = 1, r=first_switch*k;
        
        while(l<=r){
            long mid = (l+r)/2;
            long result = findMultiple(mid, onSwitches);
            if(result < k)
                l = mid+1;
            else{
                r = mid-1;
                sol = mid;
            }
        }
        return sol;
    }
    
    public static long findMultiple(long x, ArrayList<Integer> primes){
        long result = 0;
        for(long i=1;i<(1<<primes.size());i++){
            long p=1;
            long sign = -1;
            for(int j=0;j<primes.size();j++){
                if(((i >> j) & 1) == 1){
                    p*=primes.get(j);
                    sign *= -1;
                }
            }
            
            result += (x/p)*sign;
        }
        
        return result;
    }
}