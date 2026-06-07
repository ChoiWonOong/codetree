import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[] dy = {0, -1, 0, 1};
        int[] dx = {1, 0, -1, 0};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int y = sc.nextInt()-1;
        int x = sc.nextInt()-1;
        char[][] maze = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j);
            }
        }
        int result = -1;
        int cnt = 0;
        int idx = 0;
        int impossibleCnt=0;
        int time=0;
        while(true){
            if(impossibleCnt>=n*n){
                break;
            }
            int nextY = y+dy[idx];
            int nextX = x+dx[idx];

            if(nextY>=n || nextY<0 || nextX>=n || nextX<0){
                cnt++;
                result = cnt;
                break;
            }

            int nextPosition = maze[nextY][nextX];
            if(nextPosition == '#'){
                impossibleCnt++;
                idx++;
                if(idx==4){
                    idx=0;
                }
            }
            if(nextPosition == '.'){
                impossibleCnt++;
                y = nextY;
                x = nextX;
                cnt++;
                //System.out.println("y: "+y+" x: "+x);
                int rightPosition;
                if(idx==0){
                    rightPosition = maze[y+dy[idx+3]][x+dx[idx+3]];
                }else{
                    rightPosition = maze[y+dy[idx-1]][x+dx[idx-1]];
                }
                if(rightPosition == '.'){
                    idx--;
                    if(idx==-1){
                        idx=3;
                    }
                }
            }
        }
        System.out.println(result);
    }
}