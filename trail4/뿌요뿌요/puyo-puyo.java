import java.util.Scanner;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int areaCnt = 0;
    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, 1, -1, 0};
    static int areaFlag = 0;
    static int area = 0;
    public static void dfs(int y, int x, int num){
        if(y<0 || y>=n || x<0 || x>=n) return;
        if(visited[y][x] || grid[y][x]!=num) return;
        visited[y][x] = true;
        areaFlag++;
        for(int i=0; i<4; i++){
            dfs(y+dy[i], x+dx[i], num);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        int maxNum = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int num = sc.nextInt();
                grid[i][j] = num;
                maxNum = Math.max(maxNum, num);
            }
        }
        for(int num = 1; num<=maxNum; num++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    areaFlag = 0;
                    if(grid[i][j]!=num || visited[i][j]) continue;
                    dfs(i, j, num);
                    area=Math.max(area, areaFlag);
                    if(areaFlag>=4){
                        areaCnt++;
                    }
                }
            }
        }
        System.out.println(areaCnt + " " + area);
    }
}