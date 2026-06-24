import java.util.*;
public class Main {
    static final int MIN = -10000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        int[] dp = new int[m+1];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        for(int i=0; i<=m; i++){
            dp[i] = MIN;
        }
        dp[0] = 0;
        for(int i=1; i<=m; i++){
            for(int j=0; j<n; j++){
                if(i-coin[j]>=0){
                    dp[i] = Math.max(dp[i-coin[j]]+1, dp[i]);
                }
            }
        }

        if(dp[m]<0){
            System.out.println(-1);
        }else{
            System.out.println(dp[m]);
        }
    }
}