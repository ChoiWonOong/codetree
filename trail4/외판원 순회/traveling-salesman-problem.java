import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] cost;
    static int n;
    static int min = 100000;
    static void choose(int cnt, int num, int curCost){
        if(cnt == n){
            if(cost[num][0]==0){
                return;
            }
            int lastCost = cost[num][0];
            //System.out.println("lastCost : " + lastCost);
            int total = curCost + lastCost;
            min = Math.min(min, total);
            return;
        }else{
            for(int i=1; i<n; i++){
                if(visited[i]||cost[num][i]==0){
                    continue;
                }
                visited[i] = true;
                curCost += cost[num][i];
                //System.out.println(num + "->" +i);
                choose(cnt+1, i, curCost);
                curCost -= cost[num][i];
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        visited[0] = true;
        choose(1, 0, 0);
        System.out.println(min);
    }
}