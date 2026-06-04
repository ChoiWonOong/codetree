import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int size = arr.length;
            int sub = e-s+1;
            size -= sub;
            int[] temp = new int[size];
            for(int j=0, idx=0; j<arr.length; j++){
                if((j+1>=s)&&(j+1<=e)){
                    continue;
                }else{
                    temp[idx] = arr[j];
                    idx++;
                }      
            }
            arr = temp;
        }
        StringBuilder sb = new StringBuilder();
        //System.out.println(arr.length);
        sb.append(arr.length+"\n");
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i] + "\n");
        }
        System.out.print(sb);
    }
}