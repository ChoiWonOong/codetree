import java.util.Scanner;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
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
        visited = new boolean[n][m];
        BFS(grid);
        System.out.println(result);
    }
    public static void BFS(int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        int[] start = {0,0};
        queue.add(start);
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            
            // System.out.println("현재 위치: (" + y + ", " + x + ")");
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if((y == grid.length-1)&&(x == grid[0].length-1)){
                    result = 1;
                    return;
                }
                if (ny >= 0 && ny < grid.length &&
                    nx >= 0 && nx < grid[0].length &&
                    grid[ny][nx] == 1 &&
                    !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }
}