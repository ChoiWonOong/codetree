import java.util.Scanner;
public class Main {
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] u = new int[m];
        int[] v = new int[m];

        visited = new boolean[n];
        visited[0] = true;
        for (int i = 0; i < m; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            // u 에는 v 보다 작은 숫자만
            if(temp1<temp2){
                u[i] = temp1;
                v[i] = temp2;
            }else{
                u[i] = temp2;
                v[i] = temp1;
            }
        }
        // Please write your code here.
        DFS(1, m, u, v);
        System.out.println(cnt);
    }
    public static void DFS(int vertex, int m, int[] u, int[] v){
        for(int i=0; i<m; i++){
            if((u[i]==vertex)&&(!visited[v[i]-1])){
                cnt++;
                visited[v[i]-1] = true;
                DFS(v[i], m, u, v);
            }else if((v[i]==vertex)&&(!visited[u[i]-1])){
                cnt++;
                visited[u[i]-1] = true;
                DFS(u[i], m, u, v);
            }
        }
    }
}