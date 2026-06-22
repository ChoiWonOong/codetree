import java.util.Scanner;

public class Main {
    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, 1, -1, 0};
    static int[][] grid;
    static int n;
    static int[][] dp;
    public static boolean isInRange(int y, int x){
        if(y<0 || y>= n || x<0 || x>=n) return false;
        return true;
    }
    public static int dfs(int y, int x){
        if(dp[y][x]!=0) return dp[y][x];
        dp[y][x] = 1;

        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(!isInRange(ny, nx)) continue;
            if(grid[ny][nx]<=grid[y][x]) continue;
            dp[y][x] = Math.max(dp[y][x], 1 + dfs(ny, nx));
        }
        return dp[y][x];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                max = Math.max(max, dfs(i, j));
            }
        }
        System.out.println(max);
    }
}