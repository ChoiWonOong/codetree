import java.util.*;

public class Main {
    static final int MIN = -10000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[m+1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        for(int i=1; i<m+1; i++){
            dp[i] = MIN;
        }
        Collections.sort(list);
        for(int i=0; i<n; i++){
            int num = list.get(i);
            for(int j=m; j>=0; j--){
                if(j-num>=0){
                    dp[j] = Math.max(dp[j], dp[j-num]+1);
                }
            }
        }

        if(dp[m]<0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
    }
}