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
    }
    public static void BFS(int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        int[] start = {0,0};
        queue.add(start);
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0; i<4; i++){
                if(
                    (y+dy[i]>=0) && (y+dy[i]<grid.length) &&
                    (x+dx[i]>=0) && (x+dx[i]<grid[0].length) &&
                    (visited[y][x] != true) && 
                    (grid[y+dy[i]][x+dx[i]] == 1)
                ){
                    int[] pair = {y+dy[i], x+dx[i]};
                    queue.add(pair);
                    int[] nextPair = queue.poll();
                    visited[nextPair[0]][nextPair[1]] = true;
                }
            }
        }
    }
}