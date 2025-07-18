import java.util.Scanner;
public class Main {
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        // grid[x][y]
        visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        DFS(grid, 0, 0);
        System.out.println(result);
    }
    public static void DFS(int[][] grid, int y, int x){
        for(int i=0; i<2; i++){
            if(canGo(grid, y+dy[i], x+dx[i])){
                if((y+dy[i]==grid.length-1)&&(x+dx[i]==grid[0].length-1)){
                    result = 1;
                }
                visited[y+dy[i]][x+dx[i]] = true;
                //System.out.println(y+dy[i] + " " + x+dx[i]);
                DFS(grid, y+dy[i], x+dx[i]);
            }
        }
    }
    public static boolean canGo(int[][] grid, int y, int x){
        if(
            (y>=0) && (y<grid.length) &&
            (x>=0) && (x<grid[0].length) &&
            (grid[y][x] != 0) && 
            (visited[y][x] == false)
        ){
            return true;
        }else{
            return false;
        }
    }
}