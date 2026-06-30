import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            arr[i] = num;
            sum+= num;
        }
        if(sum%2==1){
            System.out.println("No");
            return;
        }
        int[] dp = new int[sum+1];
        dp[0] = 0;
        for(int i=1; i<=sum; i++){
            dp[i] = -1;
        }
        for(int i=0; i<n; i++){
            for(int j=sum; j>=1; j--){
                if(j-arr[i]<0) continue;
                if(dp[j-arr[i]]==-1) continue;
                dp[j] = dp[j-arr[i]] + 1;
            }
        }

        if(dp[sum/2]==-1){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
    }
}