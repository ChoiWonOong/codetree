import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[][] grid;
    static boolean[][] visited;
    static ArrayList<int[]> rottenList = new ArrayList<>();
    static ArrayList<int[]> mandList = new ArrayList<>();
    static int[][] times;
    static boolean isInRange(int y, int x){
        if(y<0 || y>=n || x<0 || x>=n) return false;
        return true;
    }
    static void visit(int y, int x, int[][] timeGrid, int time){
        visited[y][x] = true;
        timeGrid[y][x] = time;
    }
    static boolean canGo(int y, int x){
        if(!isInRange(y, x)) return false;
        if(grid[y][x]==0) return false;
        if(visited[y][x]) return false;
        return true;
    }
    public static int[][] bfs(){
        int[] dy = {1, 0, 0, -1};
        int[] dx = {0, 1, -1, 0};
        int[][] timeGrid = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                timeGrid[i][j]=-1;
            }
        }
        visited = new boolean[n][n];

        Queue<int[]> queue = new LinkedList<>();
        for(int[] rotten : rottenList){
            visit(rotten[0], rotten[1], timeGrid, 0);
            queue.add(new int[]{rotten[0], rotten[1]});
        }

        while(!queue.isEmpty()){
            int[] dot = queue.poll();
            int curTime = timeGrid[dot[0]][dot[1]];

            for(int i=0; i<4; i++){
                int ny = dot[0] + dy[i];
                int nx = dot[1] + dx[i];

                if(!canGo(ny, nx)) continue;

                visit(ny, nx, timeGrid, curTime+1);
                queue.add(new int[] {ny, nx});
            }
        }
        return timeGrid;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        times = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++){
                int num = sc.nextInt();
                if(num==2){
                    rottenList.add(new int[] {i,j});
                }
                if(num==1){
                    mandList.add(new int[] {i, j});
                }
                grid[i][j] = num;
            }

        times = bfs();
        for(int[] mand : mandList){
            if(times[mand[0]][mand[1]] == -1){
                times[mand[0]][mand[1]] = -2;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    System.out.print(-1 + " ");
                }else{
                    System.out.print(times[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}