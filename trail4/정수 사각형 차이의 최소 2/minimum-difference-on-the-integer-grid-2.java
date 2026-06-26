import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static ArrayList<int[]>[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st =
                    new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] =
                        Integer.parseInt(st.nextToken());
            }
        }

        dp = new ArrayList[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                dp[i][j] = new ArrayList<>();
            }
        }

        // 시작점
        dp[0][0].add(
                new int[]{map[0][0], map[0][0]}
        );

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==0 && j==0)
                    continue;

                // 위에서 이동
                if(i>0){
                    for(int[] state : dp[i-1][j]){
                        int min = Math.min(state[0], map[i][j]);
                        int max = Math.max(state[1], map[i][j]);
                        dp[i][j].add(
                                new int[]{min,max}
                        );
                    }
                }

                // 왼쪽에서 이동
                if(j>0){
                    for(int[] state : dp[i][j-1]){
                        int min = Math.min(state[0], map[i][j]);
                        int max = Math.max(state[1], map[i][j]);
                        dp[i][j].add(
                                new int[]{min,max}
                        );
                    }
                }

                // 중복 제거 및 가지치기
                removeDuplicate(i,j);
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int[] state : dp[N-1][N-1]){
            answer = Math.min(
                    answer,
                    state[1]-state[0]
            );
        }

        System.out.println(answer);

    }

    // 같은 결과 제거 + 필요없는 상태 제거
    static void removeDuplicate(int x, int y){
        ArrayList<int[]> list = dp[x][y];
        ArrayList<int[]> temp = new ArrayList<>();
        for(int[] a : list){
            boolean exist = false;
            for(int[] b : temp){
                if(a[0]==b[0] && a[1]==b[1]){
                    exist = true;
                    break;
                }
            }
            if(!exist)
                temp.add(a);
        }
        dp[x][y] = temp;
    }
}