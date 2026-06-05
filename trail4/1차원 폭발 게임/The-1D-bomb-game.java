import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++) {
            bombs[i] = sc.nextInt();
        }
        boolean flag = true;
        int tempSize = bombs.length;
        while(flag){
            boolean removed = false;
            for(int i=0, cnt=0, prevNum=0; i<bombs.length; i++){
                if(bombs[i]==prevNum){
                    cnt++;
                }else{
                    if(cnt>=m){
                        for(int j=0; j<cnt; j++){
                            bombs[i-1-j] = 0;
                        }
                        tempSize-=cnt;
                        removed = true;
                    }
                    cnt=1;
                    prevNum = bombs[i];
                }
                if(i == bombs.length-1 && cnt>=m){
                    for(int j=0; j<cnt; j++){
                        bombs[i-j] = 0;
                    }
                tempSize-=cnt;
                removed = true;
                }
            }
            int[] temp = new int[tempSize];
            for(int i=0, idx=0; i<bombs.length; i++){
                if(bombs[i]!=0){
                    temp[idx]=bombs[i];
                    idx++;
                }
            }
            bombs = temp;
            if(!removed){
                flag = false;
            }
        }
        System.out.println(tempSize);
        for(int i=0; i<tempSize; i++){
            System.out.println(bombs[i]);
        }
    }
}