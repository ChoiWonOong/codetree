import java.util.*;
public class Main {
    static int n;
    static int m;
    static int[] dotX;
    static int[] dotY;
    static ArrayList<Integer> chosen;
    static int min = 10000;
    static void choose(int idx, int cnt){
        if(cnt==m){
            int max = 0;
            int num = chosen.size();
            for(int i=0; i<num-1; i++){
                for(int j=i+1; j<num; j++){
                    int dx = Math.abs(dotX[chosen.get(i)]-dotX[chosen.get(j)]);
                    int dy = Math.abs(dotY[chosen.get(i)]-dotY[chosen.get(j)]);
                    int dist = dx*dx + dy*dy;
                    max = Math.max(max, dist);
                }
            }
            min = Math.min(min, max);
            return;
        }
        if(idx==n){
            return;
        }
        chosen.add(idx);
        choose(idx+1, cnt+1);
        chosen.remove(chosen.size()-1);
        choose(idx+1, cnt);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dotX = new int[n];
        dotY = new int[n];
        for(int i=0; i<n; i++){
            dotX[i] = sc.nextInt();
            dotY[i] = sc.nextInt();
        }
        chosen = new ArrayList<>();
        choose(0,0);
        System.out.println(min);
    }
}