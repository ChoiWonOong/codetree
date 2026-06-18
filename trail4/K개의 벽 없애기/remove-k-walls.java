import java.util.*;

public class Main {
    static int n;
    static int k;
    static int r1;
    static int c1;
    static int r2;
    static int c2;
    static int[][] grid;
    static boolean[][] visited;
    static int[][] scores;
    static int minTime = Integer.MAX_VALUE;
    static ArrayList<int[]> walls = new ArrayList<>();
    static ArrayList<int[]> chosenWalls = new ArrayList<>();
    static boolean isInRange(int y, int x){
        if(y<0 || y>=n || x<0 || x>=n) return false;
        return true;
    }
    static boolean canGo(int y, int x){
        if(!isInRange(y, x)) return false;
        if(visited[y][x]) return false;
        if(grid[y][x]==1){
            if(isChosenWall(y, x)){
                //System.out.println("Can go : " + y + " " + x);
                return true;
            }
            return false;
        }
        
        //System.out.println("Can go : " + y + " " + x);
        return true;
    }
    static boolean isChosenWall(int y, int x){
        for(int[] wall : chosenWalls){
            if(wall[0]==y && wall[1]==x) return true;
        }
        return false;
    }
    static void visit(int y, int x, int num){
        visited[y][x] = true;
        scores[y][x] = num;
    }
    static int bfs(int y, int x, int goalY, int goalX){
        int dy[] = {1, 0, 0, -1};
        int dx[] = {0, 1, -1, 0};
        
        visited = new boolean[n][n];
        scores = new int[n][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y, x});
        visit(y, x, 0);
        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int weight = scores[pair[0]][pair[1]];
            for(int i=0; i<4; i++){
                int ny = pair[0] + dy[i];
                int nx = pair[1] + dx[i];

                if(!canGo(ny, nx)) continue;
                visit(ny, nx, weight+1);
                
                if(ny==goalY && nx==goalX){
                    return scores[ny][nx];
                }
                
                queue.add(new int[] {ny, nx});
            }
        }
        return -1;
    }
    static void choose(int cnt, int index){
        if(cnt==k){
            int time = bfs(r1, c1, r2, c2);
            if(time != -1){
                minTime = Math.min(time, minTime);
            }
            return;
        }
        if(index==walls.size()) return;
        int[] wall = walls.get(index);
        chosenWalls.add(wall);
        choose(cnt+1, index+1);

        chosenWalls.remove(chosenWalls.size()-1);
        choose(cnt, index+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                grid[i][j] = num;
                if(num==1){
                    walls.add(new int[] {i, j});
                }
            }
        }
        r1 = sc.nextInt()-1;
        c1 = sc.nextInt()-1;
        r2 = sc.nextInt()-1;
        c2 = sc.nextInt()-1;
        
        choose(0, 0);
        if(minTime==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(minTime);
        }
    }
}