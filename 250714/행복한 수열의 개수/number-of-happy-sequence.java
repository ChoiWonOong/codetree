import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        // Please write your code here.
        // n - m 번
        int cnt = 0;
        for(int i=0; i<n-m; i++){
            for(int j=0; j<n-m; j++){
                int v = grid[i][j];
                // 가로만
                // m 번만 나오면 break 로 다음 열로
                for(int k = 0; k<m; k++){
                    if(grid[i][j+k] == v){
                        // 같은 수가 m 번 반복
                        cnt++;
                        break;
                    }
                }
                // 세로만
                for(int k=0; k<m; k++){
                    if(grid[i+k][j] == v){
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}