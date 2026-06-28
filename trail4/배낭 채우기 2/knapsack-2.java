import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        int weightMax = 0;
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            weightMax += w;
            weight[i] = w;
            value[i] = sc.nextInt();
        }
        int[] dp = new int[weightMax+1];
        dp[0] = 0;
        for(int i=1; i<=weightMax; i++){
            dp[i] = -1;
        }
        for(int i=0; i<weightMax; i++){
            for(int j=0; j<n; j++){
                int curWeight = weight[j];
                if(i-curWeight>=0){
                    if(dp[i-curWeight]==-1) continue;
                    dp[i] = Math.max(dp[i], dp[i-curWeight] + value[j]);
                }
            }
        }
        int max = 0;
        
        for(int i=0; i<=m; i++){
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}