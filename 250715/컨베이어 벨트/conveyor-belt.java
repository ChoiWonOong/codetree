import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] belt = new int[2*n];
        
        for(int i=0; i<2*n; i++){
            int v = sc.nextInt();
            belt[i] = v;
        }
        int mod = t % (2*n);
        // logic
        for(int i=0; i<mod; i++){
            int temp = belt[0];
            for(int j=2*n-1; j>=0; j--){
                int index = (j+1)%(2*n);
                belt[index] = belt[j];
            }
            belt[1] = temp;
        }
        for(int i=0; i<2;i++){   
            for(int j=0; j<n; j++){
                System.out.print(belt[j+n*i] + " ");
            }
            System.out.println();
        }
    }
}