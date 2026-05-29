import java.util.*;
public class Main {
    static int n;
    // visited 배열 x,y
    static boolean[] visited;
    static ArrayList<Integer> selected = new ArrayList<>();
    static int max = 0;
    // 격자
    static ArrayList<int[]> land;
    static void choose(int cnt){
        if(cnt==n){
            int sum = 0;
            for(int i=0; i<n; i++){
                sum+=selected.get(i);
            }
            max = Math.max(max, sum);
            return;
        }else{
            for(int i=0; i<n; i++){
                int[] row = land.get(cnt);
                if(visited[i]){
                    continue;
                }else{
                    selected.add(row[i]);
                    visited[i] = true;
                    choose(cnt+1);
                    visited[i] = false;
                    selected.remove(selected.size()-1);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // 격자 크기 설정
        land = new ArrayList<>();
        visited = new boolean[n];
        // 격자 입력
        for(int i=0; i<n; i++){
            int[] row = new int[n];
            for(int j=0; j<n; j++){
                row[j] = sc.nextInt();
            }
            land.add(row);
        }
        choose(0);
        System.out.println(max);
    }
}