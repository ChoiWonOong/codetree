import java.util.*;
public class Main {
    static int n; 
    static int k;
    static int u;
    static int d;
    static int[][] grid;
    static boolean[][] visited;
    static int maxCities = 0;
    static ArrayList<int[]> chosenCities = new ArrayList<>();
    static ArrayList<int[]> cities = new ArrayList<>();

    public static void visit(int[] city){
        visited[city[0]][city[1]] = true;
    }
    public static boolean isInRange(int y, int x){
        if(y<0 || y>=n || x<0 || x>=n) return false;
        if(visited[y][x]) return false;
        return true;
    }
    public static int bfs(int[] city){
        int[] dy = {1, 0, 0, -1};
        int[] dx = {0, 1, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        
        int cnt = 1;
        queue.add(city);
        visit(city);
        //System.out.println("y, x : "+ city[0] +"," + city[1] );
        while(!queue.isEmpty()){
            int[] pair = queue.poll();

            for(int i=0; i<4; i++){
                int ny = pair[0] + dy[i];
                int nx = pair[1] + dx[i];

                if(!isInRange(ny, nx)) continue;

                int sub = Math.abs(grid[ny][nx]-grid[pair[0]][pair[1]]);
                if(sub < u || sub > d) continue;
                int[] newCity = {ny, nx};
                //System.out.println("ny, nx : " + ny + ", " + nx);
                queue.add(newCity);
                visit(newCity);
                cnt++;
            }
        }
        return cnt;
    }
    public static void choose(int cnt, int index){
        if(cnt==k){
            int cityNum = 0;
            visited = new boolean[n][n];
            for(int[] city:chosenCities){
                if(!visited[city[0]][city[1]]){
                    cityNum += bfs(city);
                }
            }
            maxCities = Math.max(cityNum, maxCities);
            return;
        }
        if(index==cities.size()) return;
        
        int[] city = cities.get(index);
        chosenCities.add(city);
        choose(cnt+1, index+1);
        chosenCities.remove(chosenCities.size()-1);
        choose(cnt, index+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                cities.add(new int[] {i, j});
            }
        }
        choose(0, 0);
        System.out.println(maxCities);
    }
}