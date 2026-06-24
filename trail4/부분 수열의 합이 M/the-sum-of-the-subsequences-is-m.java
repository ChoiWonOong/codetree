import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int[] dp = new int[m+1];
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);
        
        for(int i=0; i<=m; i++){
            dp[i] = 10000;
        }
        dp[0] = 0;
        for(int i=0; i<n; i++){
            int num = arr.get(i);
            for(int j=m; j>=num; j--){
                dp[j] = Math.min(dp[j], dp[j-num]+1);
            }
        }
        //for(int i=0; i<m+1; i++){
        //    System.out.print(dp[i]+ " ");
        //}
        //System.out.println();
        if(dp[m]==10000){
            System.out.println(-1);
        }else{
            System.out.println(dp[m]);
        }
    }
}