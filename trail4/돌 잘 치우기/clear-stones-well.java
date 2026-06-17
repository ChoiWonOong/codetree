import java.util.*;
public class Main {
    static int n;
    static int k;
    static int m;
    static int[][] grid;
    static boolean[][] visited;
    static int[][] startPoints;
    static ArrayList<int[]> rocks = new ArrayList<>();
    static ArrayList<int[]> chosenRocks = new ArrayList<>();
    static int maxArea = 0;

    public static void choose(int cnt, int index){
        if(cnt == m){
            visited = new boolean[n][n];
            for(int[] pair:chosenRocks){
                //System.out.println("y x : " + pair[0] + " " + pair[1]);
            }
            int area = 0;
            for(int i=0; i<k; i++){
                int[] pair = startPoints[i];
                int bfsArea = bfs(pair[0], pair[1]);
                //System.out.println("bfsArea : " + bfsArea);
                area += bfsArea;
            }
            maxArea = Math.max(maxArea, area);
            return;
        }
        // 남은 돌로 M개를 채울 수 없으면 조기 종료
        if(rocks.size() - index < m - cnt) return;
        if(index == rocks.size()) return;

        int[] pair = rocks.get(index);
        chosenRocks.add(pair);
        choose(cnt+1, index+1);
        chosenRocks.remove(chosenRocks.size()-1);
        choose(cnt, index+1);
    }

    public static int bfs(int y, int x){
        int dy[] = {1, 0, 0, -1};
        int dx[] = {0, 1, -1, 0};
        int cnt = 0;
        if(visited[y][x]) return cnt;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y,x});
        visited[y][x] = true;
        cnt++;
        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            //System.out.println("y x " + pair[0] + " " +pair[1]);
            for(int i=0; i<4; i++){
                int ny = pair[0] + dy[i];
                int nx = pair[1] + dx[i];
                if(ny<0 || ny>=n || nx<0 || nx>=n) continue;
                if(visited[ny][nx]) continue;
                if(grid[ny][nx]==1 && !isChosen(new int[] {ny, nx})) continue;
                //System.out.println("ny nx "+ ny + " " + nx);
                queue.add(new int[] {ny, nx});
                visited[ny][nx] = true;
                cnt++;
            }
        }
        return cnt;
    }
    public static boolean isChosen(int[] pair){
        for(int[] chosenPair:chosenRocks){
            if(chosenPair[0]==pair[0] && chosenPair[1]==pair[1]) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j]==1){
                    rocks.add(new int[] {i, j});
                }
            }
        }
        startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt()-1;
            startPoints[i][1] = sc.nextInt()-1;
        }
        choose(0, 0);
        //int num = bfs(0, 0);
        //System.out.println(num);
        System.out.println(maxArea);
    }
}