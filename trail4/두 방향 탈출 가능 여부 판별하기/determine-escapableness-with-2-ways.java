import java.util.Scanner;
public class Main {
    static int n;
    static int m;
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};
    static boolean[][] visited;
    static int[][] grid;
    static int flag = 0;
    static void dfs(int y, int x){
        if(flag==1)return;
        if(y == n-1 && x == m-1){
            flag = 1;
            return;
        }
        if(y<0 || y>=n || x<0 || x>=m){
            return;
        }
        if(!visited[y][x] && grid[y][x]==1){
            visited[y][x] = true;
            for(int i=0; i<2; i++){
                dfs(y+dy[i], x+dx[i]);
            }   
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n][m];
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        dfs(0, 0);
        System.out.println(flag);
    }
}