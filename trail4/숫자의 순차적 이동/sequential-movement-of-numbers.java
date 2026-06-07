import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 격자 생성
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // 수와 그 수가 있는 격자의 좌표를 HashMap 에 저장
        HashMap<Integer, int[]> map = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map.put(grid[i][j], new int[]{i, j});
            }
        }
        for(int i=0; i<m; i++){
            for(int key=1; key<=n*n; key++){
                // 1부터 n*n 까지 순서대로 수가 가지고 있는 격자의 좌표를 map 에서 조회
                int[] pair = map.get(key);
                int curY = pair[0];
                int curX = pair[1];
                int maxNum = 0;
                // 팔방을 찾아 가장 큰 수와 위치를 교환
                for(int j = 0; j<8; j++){
                    int y = pair[0]+dy[j];
                    int x = pair[1]+dx[j];
                    if(y>=n || y<0 || x>=n || x<0){
                        continue;
                    }
                    if(grid[y][x]>maxNum){
                        maxNum = grid[y][x];
                    }
                }
                
                // 가장 큰 수의 좌표를 map 에서 조회
                int[] maxPair = map.get(maxNum);
                int maxY = maxPair[0];
                int maxX = maxPair[1];
                // 두 수의 격자 위치를 교환
                grid[curY][curX] = maxNum;
                grid[maxY][maxX] = key;
                map.replace(key, new int[]{maxY, maxX});
                map.replace(maxNum, new int[]{curY, curX});
                
            }
            
        }
        // 디버그 출력 추가
            for(int y=0; y<n; y++){
            for(int x=0; x<n; x++){
                System.out.print(grid[y][x] + " ");
            }
            System.out.println();
        }
    }
}