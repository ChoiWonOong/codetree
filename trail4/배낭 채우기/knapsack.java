import java.util.*;

public class Main {
    static final int MIN = -10000;
    static class Jewel implements Comparable<Jewel>{
        public int weight;
        public int value;
        public Jewel(int w, int v){
            this.weight = w;
            this.value = v;
        }
        @Override
        public int compareTo(Jewel c){
            return weight - c.weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Jewel> jewels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            Jewel jewel = new Jewel(weight, value);
            jewels.add(jewel);
        }
        Collections.sort(jewels);
        int[] dp = new int[m+1];
        dp[0] = 0;
        for(int i=1; i<=m; i++){
            dp[i] = MIN;
        }
        for(int i=0; i<n; i++){
            Jewel jewel = jewels.get(i);
            int weight = jewel.weight;
            int value = jewel.value;
            for(int j=m; j>=0; j--){
                if(j-weight>=0){
                    dp[j] = Math.max(dp[j], dp[j-weight] + value);
                }
            }
        }
        int max = 0;
        for(int i=0; i<m+1; i++){
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}