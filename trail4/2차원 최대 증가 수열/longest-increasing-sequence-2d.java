import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        dp[0][0] = 1;
        for(int i=1; i<n; i++){
            dp[i][0] = 0;
        }
        for(int i=1; i<m; i++){
            dp[0][i] = 0;
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                int maxDp = 0;
                for(int k=i-1; k>=0; k--){
                    for(int l=j-1; l>=0; l--){
                        if(dp[k][l] > 0 && dp[k][l]>maxDp && grid[k][l] < grid[i][j]){
                            maxDp = dp[k][l];
                        }
                    }
                }
                dp[i][j]= (maxDp>0) ? maxDp + 1 : 0;
            }
        }
        int max = 0;
        //for(int i=0; i<n; i++){
        //    for(int j=0; j<m; j++){
        //        System.out.print(dp[i][j] + " ");
        //    }
        //    System.out.println();
        //}
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
}