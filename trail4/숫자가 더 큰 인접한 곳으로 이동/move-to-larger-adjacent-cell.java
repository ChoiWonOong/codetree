import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        int[] dx = {0, 0, -1, 1, 0};
        int[] dy = {-1, 1, 0, 0, 0};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1])-1;
        int c = Integer.parseInt(input[2])-1;
        
        int[][] grid = new int[n][n];
        for(int i=0; i<n; i++){
            String[] row = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                grid[i][j] = Integer.parseInt(row[j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        
        ArrayList<Integer> visited = new ArrayList<>();
        boolean flag = true;
        visited.add(grid[r][c]);
        while(flag){
            int idx = 4;
            for(int i=0; i<4; i++){
                int y = r+dy[i];
                int x = c+dx[i];
                if(y<0 || y>=n || x<0 || x>=n){
                    continue;
                }
                if(grid[y][x]>grid[r+dy[idx]][c+dx[idx]]){
                    if(idx>i){
                        idx=i;
                    }
                }
            }
            if(r == r+dy[idx] && c == c+dx[idx]){
                flag = false;
            }else{
                r=r+dy[idx];
                c=c+dx[idx];
                visited.add(grid[r][c]);
            }
        }
        for(int num:visited){
            sb.append(num + " ");
        }
        System.out.print(sb);
    }
}