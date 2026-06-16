import java.util.*;
public class Main {
    public static final int MAX_NUM = 1000;
    public static int n, m;
    public static boolean[] visited = new boolean[MAX_NUM+1];
    public static int[][] graph;
    public static int vertexCnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n+1][n+1];
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        visited[1] = true;
        dfs(1);
        System.out.println(vertexCnt);
    }
    public static void dfs(int vertex){
        for(int j=1; j<=n; j++){
            if(graph[vertex][j]==1 && !visited[j]){
                visited[j] = true;
                vertexCnt++;
                dfs(j);
            }
        }
    }
}