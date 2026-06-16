import java.util.*;
public class Main {
    static int[][] grid;
    static boolean[][] visited;
    static int n;
    static int m;
    static int maxArea = 0;
    static int resultHeight = 1;
    public static void dfs(int y, int x, int height){
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        if(y<0 || y>=n || x<0 || x>=m) return;
        if(visited[y][x] || grid[y][x] <= height) return;
        visited[y][x] = true;
        for(int i=0; i<4; i++){
            dfs(y+dy[i], x+dx[i], height);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int maxHeight = 0;
        grid = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++){
                int height = sc.nextInt();
                maxHeight = Math.max(maxHeight, height);
                grid[i][j] = height;
            }
        }
        
        
        for(int h=1; h<maxHeight; h++){
            int areaCnt = 0;
            visited = new boolean[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(grid[i][j]<=h || visited[i][j]) continue;
                    areaCnt++;
                    dfs(i, j, h);
                }
            }
            //System.out.println(areaCnt);
            if(areaCnt > maxArea){
                maxArea = areaCnt;
                resultHeight = h;
            }
        }
        System.out.println(resultHeight + " " + maxArea);
    }
}