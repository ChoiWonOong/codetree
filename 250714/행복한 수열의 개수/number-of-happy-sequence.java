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
        int cnt = 0;

        // n번
        for(int i=0; i<n; i++){
            for(int j=0; j<=n-m; j++){
                int v = grid[i][j];
                int tempCnt = 0;
                for(int k=0; k<m; k++){
                    if(grid[i][j+k]==v){
                        tempCnt++;
                    }
                }
                if(tempCnt==m){
                    cnt++;
                    break;
                }
                
            }
        }
        // n번
        for(int i=0; i<n; i++){
            for(int j=0; j<=n-m; j++){
                int v = grid[j][i];
                int tempCnt = 0;
                for(int k=0; k<m; k++){
                    if(grid[j+k][i]==v){
                        tempCnt++;
                    }
                }
                if(tempCnt==m){
                    cnt++;
                    break;
                }
                
            }
        }
        System.out.println(cnt);
    }
}