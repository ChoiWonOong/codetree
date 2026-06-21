import java.io.*;

public class Main {

    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];

        if (N >= 0) dp[0] = 1;
        if (N >= 1) dp[1] = 2;
        if (N >= 2) dp[2] = 7;

        for (int i = 3; i <= N; i++) {
            dp[i] = (3 * dp[i - 1] + dp[i - 2] - dp[i - 3]) % MOD;

            // 음수 방지
            if (dp[i] < 0) {
                dp[i] += MOD;
            }
        }

        System.out.println(dp[N]);
    }
}