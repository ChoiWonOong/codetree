import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int oneStep = 3;

        int[][] dp = new int[n + 1][4];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 3; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;

        dp[1][1] = coins[0];
        dp[2][0] = coins[1];
        dp[2][1] = coins[0] + coins[1];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= oneStep; j++) {
                int prev2 = dp[i - 2][j];

                if (j == 0) {
                    dp[i][j] = (prev2 == -1) ? -1 : prev2 + coins[i - 1];
                } else {
                    int prev1 = dp[i - 1][j - 1];
                    if (prev1 == -1 && prev2 == -1) {
                        dp[i][j] = -1;
                    } else if (prev1 == -1) {
                        dp[i][j] = prev2 + coins[i - 1];
                    } else if (prev2 == -1) {
                        dp[i][j] = prev1 + coins[i - 1];
                    } else {
                        dp[i][j] = Math.max(prev1, prev2) + coins[i - 1];
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i <= 3; i++) {
            max = Math.max(dp[n][i], max);
        }
        System.out.println(max);
    }
}