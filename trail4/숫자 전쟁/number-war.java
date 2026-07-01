import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();

        int[][] dp = new int[n + 1][n + 1];
        // dp[n][*] = 0, dp[*][n] = 0 (기본값 0이라 별도 초기화 불필요)

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int battle;
                if (a[i] < b[j]) {
                    // 상대방이 이김: 상대방 카드만 버려짐, 남우 카드는 유지
                    battle = dp[i + 1][j];
                } else if (a[i] > b[j]) {
                    // 남우가 이김: 남우가 점수 얻고, 남우 카드만 버려짐
                    battle = b[j] + dp[i][j + 1];
                } else {
                    // 같으면 둘 다 버려짐, 점수 없음
                    battle = dp[i + 1][j + 1];
                }
                int discard = dp[i + 1][j + 1]; // 카드 버리기: 둘 다 버려짐, 점수 없음
                dp[i][j] = Math.max(battle, discard);
            }
        }

        System.out.println(dp[0][0]);
    }
}