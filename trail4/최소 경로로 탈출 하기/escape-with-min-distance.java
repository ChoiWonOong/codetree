import java.util.*;
public class Main {
    static int n;
    static int m;
    static int[][] a;
    static boolean[][] visited;
    static int[][] scores;
    static void visit(int y, int x, int score){
        visited[y][x] = true;
        scores[y][x] = score;
    }
    static boolean isInRange(int y, int x){
        if(y<0 || y>=n || x<0 || x>=m) return false;
        if(visited[y][x]) return false;
        return true;
    }
    public static void bfs(int y, int x){
        int[] dy = {1, 0, 0, -1};
        int[] dx = {0, 1, -1, 0};
        
        visited = new boolean[n][m];
        scores = new int[n][m];
        scores[n-1][m-1] = -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y,x});
        visit(y,x,0);

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            //System.out.println("y x : " + pair[0] + " " + pair[1]);
            for(int i=0; i<4; i++){
                int ny = pair[0] + dy[i];
                int nx = pair[1] + dx[i];

                if(!isInRange(ny, nx)) continue;
                if(a[ny][nx]==0) continue;
                //System.out.println("ny nx : " + ny + " " + nx);
                queue.add(new int[]{ny, nx});
                int score = scores[pair[0]][pair[1]];
                visit(ny, nx, score+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        bfs(0,0);
        System.out.print(scores[n-1][m-1]);
    }
}