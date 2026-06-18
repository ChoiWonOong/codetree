import java.util.*;
public class Main {
    static int n;
    static ArrayList<int[]> humans = new ArrayList<>();
    static ArrayList<int[]> spaces = new ArrayList<>();
    static boolean[][] visited;
    static int[][] a;
    static int[][] result;
    static int[][] distance;
    static boolean isInRange(int y, int x){
        if(y<0 || y>=n || x<0 || x>=n) return false;
        return true;
    }
    static boolean canGo(int y, int x){
        if(!isInRange(y, x)) return false;
        if(visited[y][x]) return false;
        if(a[y][x]==1) return false;
        return true;
    }
    static void visit(int y, int x, int num){
        visited[y][x] = true;
        distance[y][x] = num;
    }
    static boolean isAvoidable(int y, int x){
        for(int[] space : spaces){
            if(space[0]==y && space[1]==x) return true;
        }
        return false;
    }
    static void bfs(int y, int x){
        int[] dy = {1, 0, 0, -1};
        int[] dx = {0, 1, -1, 0};

        distance = new int[n][n];
        visited = new boolean[n][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y,x});
        visit(y, x, 0);

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int score = distance[pair[0]][pair[1]];
            for(int i=0; i<4; i++){
                int ny = pair[0] + dy[i];
                int nx = pair[1] + dx[i];
                
                if(!canGo(ny, nx)) continue;

                queue.add(new int[] {ny, nx});
                visit(ny, nx, score+1);

                if(isAvoidable(ny, nx)){
                    result[y][x]=distance[ny][nx];
                    return;
                }
            }
        }
        result[y][x]=-1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int h = sc.nextInt();
        int m = sc.nextInt();
        result = new int[n][n];
        a = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++){
                int num = sc.nextInt();
                a[i][j] = num;
                if(num==2){
                    humans.add(new int[] {i, j});
                }
                if(num==3){
                    spaces.add(new int[] {i, j});
                }
            }
        for(int[] human:humans){
            bfs(human[0], human[1]);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}