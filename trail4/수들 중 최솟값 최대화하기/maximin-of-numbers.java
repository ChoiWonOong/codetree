import java.util.*;
public class Main {
    static int n;
    static boolean[] visited;
    static int max = 0;
    static int[][] grid;
    static int[] chosen;
    static void choose(int cnt){
        if(cnt == n){
            int[] temp = chosen.clone();
            Arrays.sort(temp);
            max = Math.max(max, temp[0]);
            return;
        }
        for(int i=0; i<n; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            int val = grid[cnt][i];
            chosen[i] = val;
            choose(cnt+1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n];
        chosen = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        choose(0);
        System.out.println(max);
    }
}