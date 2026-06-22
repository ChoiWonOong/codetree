import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        // 초기값
        dp[0][n-1] = matrix[0][n-1];

        // 첫 행 초기화 (왼쪽으로만)
        for (int j = n-2; j >= 0; j--)
            dp[0][j] = dp[0][j+1] + matrix[0][j];

        // 오른쪽 끝 열 초기화 (아래로만)
        for (int i = 1; i < n; i++)
            dp[i][n-1] = dp[i-1][n-1] + matrix[i][n-1];

        // 점화식
        for (int i = 1; i < n; i++)
            for (int j = n-2; j >= 0; j--)
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j+1]) + matrix[i][j];

        System.out.println(dp[n-1][0]);
    }
}