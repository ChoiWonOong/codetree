import java.util.*;
public class Main {
    public static int n;
    public static boolean[] visited;
    public static ArrayList<Integer> selected = new ArrayList<>();
    static void choose(int cnt){
        // 함수 호출이 n+1 번째일 경우 - n 개의 숫자가 선택되었을 경우
        if(cnt==n+1){
            for(int i=0; i<selected.size(); i++){
                System.out.print(selected.get(i)+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=n; i++){
            if(visited[i]==true){
                continue;
            }else{
                selected.add(i);
                visited[i] = true;
                choose(cnt+1);
                selected.remove(selected.size()-1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // 1부터 n 까지 접근 할 수 있는 visited 배열 생성
        visited = new boolean[n+1];
        choose(1);
    }
}