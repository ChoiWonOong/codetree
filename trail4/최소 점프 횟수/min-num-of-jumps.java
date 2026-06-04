import java.util.*;
public class Main {
    static int n;
    static int min = 10;
    static int[] jumpRange = new int[10];
    public static void choose(int cnt, int location){
        if(location==n-1){
            min = Math.min(min, cnt);
            return;
        }
        if(jumpRange[location]==0){return;}
        for(int i=1; i<=jumpRange[location]; i++){
            if(location+i>=n)return;
            choose(cnt+1, location+i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0; i<n; i++){
            jumpRange[i] = sc.nextInt();
        }
        choose(0, 0);
        if(min==10){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }
}