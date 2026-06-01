import java.util.*;
public class Main {
    static int n;
    static int[] arr;
    static int min = 3000;
    static ArrayList<Integer> chosenIdx = new ArrayList<Integer>();
    static int sum=0;
    public static void choose(int idx, int cnt){
        if(idx==2*n){
            return;
        }
        if(cnt==n+1){
            int chosenSum = 0;
            for(int i=0; i<n; i++){
                chosenSum+=arr[chosenIdx.get(i)];
            }
            int sub = Math.abs(sum - chosenSum*2);
            min = Math.min(min, sub);
        }
        chosenIdx.add(idx);
        choose(idx+1, cnt+1);
        chosenIdx.remove(chosenIdx.size()-1);
        choose(idx+1, cnt);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            sum+=num;
        }
        choose(0, 1);
        System.out.println(min);
    }
}