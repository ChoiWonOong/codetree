import java.util.Scanner;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int people = 0;
    static ArrayList<Integer> cnt = new ArrayList<>();
    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, 1, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                DFS(grid, i, j);
                if(people!=0){
                    cnt.add(people);
                    people=0;
                }
            }
        }
        Collections.sort(cnt);
        System.out.println(cnt.size());
        for(int i=0; i<cnt.size(); i++){
            System.out.println(cnt.get(i));
        }
    }
    public static void DFS(int[][] grid, int y, int x){
        if(
            (y>=0) && (y<grid.length) &&
            (x>=0) && (x<grid[0].length) &&
            (grid[y][x]==1) &&
            (visited[y][x]!=true)
        ){
            visited[y][x] = true;
            people++;
            for(int i=0; i<4; i++){
                DFS(grid, y+dy[i], x+dx[i]);
            }
        }
    }
}