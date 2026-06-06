import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt()-1;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int height = n-1;
        int min = n-1;
        for(int i=k; i<k+m; i++){
            for(int j=1; j<n; j++){
                if(grid[j][i]==1){
                    min = Math.min(j-1, min);
                }
            }
        }
        for(int i=k; i<k+m; i++){
            grid[min][i] = 1;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}