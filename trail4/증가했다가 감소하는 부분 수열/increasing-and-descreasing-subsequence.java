import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i])
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
            }
        }

        int max = 0;
        for (int k = 1; k < n; k++) {
            int cnt = dp1[k];
            if(cnt==1)
                Arrays.fill(dp2, 1);  // 매 k마다 초기화
            else{
                Arrays.fill(dp2, 0);
            }
            for (int i = k + 1; i < n; i++) {
                for (int j = k; j < i; j++) {
                    if (arr[j] > arr[i])
                        dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }

            int sub = 0;
            for (int i = k + 1; i < n; i++) {  // k+1부터 (꼭짓점 중복 제외)
                sub = Math.max(dp2[i], sub);
            }

            max = Math.max(max, cnt + sub);
        }
        System.out.println(max);
    }
}