import java.util.*;
public class Main {
    static int n;
    static boolean[] visited;
    static ArrayList<Integer> selected = new ArrayList<>();
    static void choose(int cnt){
        if(cnt==n+1){
            for(int i=0; i<n; i++){
                System.out.print(selected.get(i)+" ");
            }
            System.out.println();
            return;
        }else{
            for(int i=n; i>=1; i--){
                if(visited[i]==true){
                    continue;
                }else{
                    selected.add(i);
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
        visited = new boolean[n+1];
        choose(1);
    }
}