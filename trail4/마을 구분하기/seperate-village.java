import java.util.*;

public class Main {
    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, 1, -1, 0};
    static int n;
    static int num = 0;
    static int[][] grid;
    static boolean[][] visited;
    static int cnt = 0;
    public static void dfs(int y, int x){
        if(y<0 || y>=n || x<0 || x>=n) return;
        if(grid[y][x]==0 || visited[y][x])return;
    
        visited[y][x] = true;
        grid[y][x] = 0;
        num++;

        for(int i=0; i<4; i++){
            dfs(y+dy[i], x+dx[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                num = 0;
                if(grid[i][j]==0)continue;
                cnt++;
                dfs(i,j);
                nums.add(num);
            }
        }
        Collections.sort(nums);
        System.out.println(cnt);
        for(int num:nums){
            System.out.println(num);
        }
    }
}