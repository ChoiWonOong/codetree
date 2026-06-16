import java.util.*;
public class Main {
    static int[][] grid;
    static boolean[][] visited;
    static int flag = 0;
    static int n;
    static int m;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        queue.add(new int[] {0, 0});
        visited[0][0] = true;
        bfs();
        System.out.println(flag);
    }
    public static void bfs(){
        int[] dy = {1, 0, 0, -1};
        int[] dx = {0, 1, -1, 0};
        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int y = pair[0];
            int x = pair[1];
            if(y==n-1 && x==m-1){
                flag = 1;
                break;
            } 
            for(int i=0; i<4; i++){
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(grid[ny][nx]==1 && !visited[ny][nx]){
                    //System.out.println("y, x : " + ny + " " + nx);
                    queue.add(new int[] {ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }
}