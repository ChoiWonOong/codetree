import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        
        long[] dp = new long[N + 1];
        dp[0] = 1; // 아무것도 안 쓰는 경우 (base case)
        
        for (int i = 1; i <= N; i++) {
            if (i >= 1) dp[i] = (dp[i]+dp[i - 1])%10007;
            if (i >= 2) dp[i] = (dp[i]+dp[i - 2])%10007;
            if (i >= 5) dp[i] = (dp[i]+dp[i - 5])%10007;
        }
        
        System.out.println(dp[N]);
    }
}