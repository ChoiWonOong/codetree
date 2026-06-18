import java.util.*;
public class Main {
    static int n;
    static boolean[][] visited;
    static int[][] scores;
    static boolean isInRange(int y, int x){
        if(y<0 || y>=n || x<0 || x>=n) return false;
        return true;
    }
    static boolean canGo(int y, int x){
        if(!isInRange(y,x)) return false;
        if(visited[y][x]==true) return false;
        return true;
    }
    static void visit(int y, int x, int num){
        visited[y][x] = true;
        scores[y][x] = num;
    }
    static void bfs(int y, int x, int goalY, int goalX){
        int[] dy = {2, 2, 1, 1, -1, -1, -2, -2};
        int[] dx = {1, -1, 2, -2, 2, -2, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y, x});
        visit(y,x,0);

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int score = scores[pair[0]][pair[1]];
            for(int i=0; i<8; i++){
                int ny = pair[0] + dy[i];
                int nx = pair[1] + dx[i];
                
                if(!canGo(ny, nx)) continue;

                queue.add(new int[] {ny, nx});
                visit(ny, nx, score+1);
                //System.out.println("ny nx : " + ny + " " + nx);
                if(ny==goalY && nx== goalX) return;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n][n];
        scores = new int[n][n];

        int r1 = sc.nextInt()-1;
        int c1 = sc.nextInt()-1;
        int r2 = sc.nextInt()-1;
        int c2 = sc.nextInt()-1;
        
        scores[r2][c2] = -1;

        bfs(r1, c1, r2, c2);
        
        System.out.println(scores[r2][c2]);
    }
}