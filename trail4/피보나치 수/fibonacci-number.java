import java.util.*;
public class Main {
    static int[] memo = new int[46];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // memoization 배열을 -1 로 채운다.
        Arrays.fill(memo, -1);
        int num = fibbo2(n);
        System.out.println(num);
    }
    public static int fibbo1(int num){
        if(num==1 || num==2) return 1;
        if(memo[num]==-1){
            memo[num] = fibbo1(num-1) + fibbo1(num-2);
            return memo[num];
        }
        return memo[num];
    }
    public static int fibbo2(int num){
        int[] dp = new int[46];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<=num; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[num];
    }
}