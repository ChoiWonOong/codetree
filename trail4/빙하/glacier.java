import java.util.*;
public class Main {
    static int n;
    static int m;
    static int[][] grid;
    static boolean[][] visited;
    static ArrayList<int[]> ices;
    static int remainIceSize;
    public static boolean isContains(int y, int x){
        for(int[] ice:ices){
            if(y==ice[0] && x==ice[1]) return true;
        }
        return false;
    }
    public static int bfs(int y, int x){
        visited = new boolean[n][m];
        int[] dy = {1, 0, 0, -1};
        int[] dx = {0, 1, -1, 0};
        if(visited[y][x]) return 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        ices = new ArrayList<>();
        //System.out.println("y x : " + y + " " + x);
        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            for(int i=0; i<4; i++){
                int ny = pair[0] + dy[i];
                int nx = pair[1] + dx[i];
                if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
                if(visited[ny][nx]) continue;
                if(grid[ny][nx] == 1 && !isContains(ny, nx)){
                    //System.out.println("ny nx : " + ny +" " + nx);
                    ices.add(new int[] {ny, nx});
                }
                if(grid[ny][nx] == 0){
                    queue.add(new int[] {ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
        //System.out.println("while exit");
        // 지울 얼음이 없으면 바로 함수 종료
        if(ices.size()==0){
            return 0;
        }
        // 얼음 녹음
        for(int[] ice : ices){
            grid[ice[0]][ice[1]] = 0;
        }
        remainIceSize = ices.size();
        //System.out.println("remainIceSize : " + remainIceSize);
        //print();
        //System.out.println();
        return 1;
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
        int time = 0;
        while(hasIce()){
            time+=bfs(0,0);
        }
        System.out.println(time + " " + remainIceSize);
    }
    public static boolean hasIce(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1) return true;
            }
        }
        return false;
    }
    public static void print(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(grid[i][j]+ " "); 
            }
            System.out.println();
        }
    }
}