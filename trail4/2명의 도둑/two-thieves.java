import java.util.*;

public class Main {
    static int n, m, c;
    static int[][] grid;
    static boolean[][] visited;
    static int bestWeight = 0;
    static int maxWeight = 0;

    static void choose(int idx, int sum, int weight, ArrayList<Integer> items) {
        if (sum <= c) {
            bestWeight = Math.max(bestWeight, weight);
        }
        for (int i = idx; i < items.size(); i++) {
            int item = items.get(i);
            choose(i + 1, sum + item, weight + item * item, items);
        }
    }

    static void solve(int cnt, int result) {
        if (cnt == 2) {
            maxWeight = Math.max(maxWeight, result);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - m + 1; j++) {
                // visited 체크
                boolean valid = true;
                for (int k = 0; k < m; k++) {
                    if (visited[i][j + k]) { valid = false; break; }
                }
                if (!valid) continue;

                // weight 계산
                bestWeight = 0;
                ArrayList<Integer> items = new ArrayList<>();
                for (int k = 0; k < m; k++) items.add(grid[i][j + k]);
                choose(0, 0, 0, items);

                // visited 표시
                for (int k = 0; k < m; k++) visited[i][j + k] = true;

                solve(cnt + 1, result + bestWeight);

                // visited 복원
                for (int k = 0; k < m; k++) visited[i][j + k] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt(); c = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        solve(0, 0);
        System.out.println(maxWeight);
    }
}