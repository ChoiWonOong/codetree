import java.util.Scanner;

public class Main {
    static final int MAX = 100000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[n];
        int[] dp = new int[m+1];
        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();
        dp[0] = 0;
        for(int i=1; i<=m; i++){
            dp[i] = MAX;
        }
        for(int i=1; i<=m; i++){
            for(int coin : coins){
                if(i-coin>=0){
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        if(dp[m]==MAX){
            System.out.println(-1);
        }else{
            System.out.println(dp[m]);
        }
    }
}