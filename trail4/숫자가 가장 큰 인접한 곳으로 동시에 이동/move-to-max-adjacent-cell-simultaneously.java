import java.util.*;

public class Main {
    static int N, M, T;
    static int[][] grid;
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt(); T = sc.nextInt();
        
        grid = new int[N+1][N+1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                grid[i][j] = sc.nextInt();
        
        List<int[]> marbles = new ArrayList<>();
        for (int i = 0; i < M; i++)
            marbles.add(new int[]{sc.nextInt(), sc.nextInt()});
        
        for (int t = 0; t < T; t++) {
            // 각 구슬 이동
            List<int[]> next = new ArrayList<>();
            for (int[] m : marbles) {
                int r = m[0], c = m[1];
                int bestVal = -1, bestDir = -1;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    if (nr < 1 || nr > N || nc < 1 || nc > N) continue;
                    if (grid[nr][nc] > bestVal) {
                        bestVal = grid[nr][nc];
                        bestDir = d;
                    }
                }
                if (bestDir != -1) {
                    next.add(new int[]{r + dr[bestDir], c + dc[bestDir]});
                } else {
                    next.add(new int[]{r, c});
                }
            }
            
            // 같은 위치 구슬 충돌 제거
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int[] m : next) {
                int key = m[0] * 100 + m[1];
                cnt.merge(key, 1, Integer::sum);
            }
            marbles = new ArrayList<>();
            for (int[] m : next) {
                int key = m[0] * 100 + m[1];
                if (cnt.get(key) == 1) marbles.add(m);
            }
        }
        
        System.out.println(marbles.size());
    }
}