import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        int range = grid[r][c];
        grid[r][c] = 0;
        for(int i=1; i<range; i++){
            for(int j=0; j<4; j++){
                int y = r+i*dy[j];
                int x = c+i*dx[j];
                if(y>=0 && y<n && x>=0 && x<n){
                    grid[y][x] = 0;
                }
            }
        }
        for(int i=0; i<n; i++){
            int[] temp = new int[n];
            int idx=n-1;
            for(int j=n-1; j>=0; j--){
                if(grid[j][i]!=0){
                    temp[idx] = grid[j][i];
                    idx--;
                }
            }
            for(;idx>0; idx--){
                temp[idx] = 0;
            }
            for(int j=n-1; j>=0; j--){
                grid[j][i] = temp[j];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}