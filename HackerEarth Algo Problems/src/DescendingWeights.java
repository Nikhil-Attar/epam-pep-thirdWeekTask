import java.util.*;
 
public class DescendingWeights {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        final int k = sc.nextInt();
 
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
           list.add(sc.nextInt());
        }
        
        Collections.sort(list, new Comparator<Integer>() {
           public int compare(Integer a, Integer b) {
               if (a % k > b % k) return -1;
               
               if (a % k < b % k) return 1;
               
               if(a % k == b % k) {
                   if(a < b) {
                       return -1;
                   }else {
                       return 1;
                   }
               }
               return 0;
           } 
        });
        
        for(int i = 0;i < n; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}