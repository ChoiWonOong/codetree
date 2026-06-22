import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dp[0] = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(j+arr[j]>=i){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        int max = 0;
        for(int i=1; i<n; i++){
            //System.out.print(dp[i] + " ");
            if(dp[i]==0){
                max = Math.max(max, dp[i]);
                break;
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}