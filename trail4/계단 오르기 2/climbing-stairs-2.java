import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] coins = new int[n + 1]; // coins[0] = 시작점(동전 없음), coins[1..n] = 각 층
        for (int i = 1; i <= n; i++) {
            coins[i] = sc.nextInt();
        }

        final int NEG = Integer.MIN_VALUE / 2;
        int[][] dp = new int[n + 1][4]; // dp[i][k]: i층, 1계단 이동 k번 사용

        for (int[] row : dp) java.util.Arrays.fill(row, NEG);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= 3; k++) {
                // 1계단 이동으로 도착 (k-1번 상태에서 옴)
                if (k >= 1 && dp[i - 1][k - 1] != NEG) {
                    dp[i][k] = Math.max(dp[i][k], dp[i - 1][k - 1] + coins[i]);
                }
                // 2계단 이동으로 도착
                if (i >= 2 && dp[i - 2][k] != NEG) {
                    dp[i][k] = Math.max(dp[i][k], dp[i - 2][k] + coins[i]);
                }
            }
        }

        int answer = 0;
        for (int k = 0; k <= 3; k++) {
            answer = Math.max(answer, dp[n][k]);
        }

        System.out.println(answer);
    }
}