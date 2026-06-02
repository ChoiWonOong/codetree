import java.util.*;
public class Main {
    static int n;
    static boolean flag = false;
    static ArrayList<Integer> chosen = new ArrayList<>();
    public static boolean isMultiSequence(ArrayList<Integer> list){
        int size = list.size();
        if(size==1){
            return false;
        }
        for(int i=0; i<size/2; i++){
            //System.out.println("i : "+ i);
            int a = 0;
            int b = 0;
            int cnt = 1;
            for(int j=0; j<i+1; j++){
                // n = 2, i = 0, j = 0
                // n = 4, i = 1, j = 0 1 , idx -> 3 2, 1 0
                //System.out.println("size : " + size);
                //System.out.println("size-j-1 : "+(size-j-1));
                //System.out.println("size-i-j-2 : "+(size-i-j-2));
                a+=chosen.get(size-j-1)*cnt;
                b+=chosen.get(size-i-j-2)*cnt;
                cnt*=10;
            }
            if(a==b){
                return true;
            }
        }
        return false;
    }
    public static void choose(int cnt, int prevNum){
        if(flag)return;
        // 수를 구하면 출력 후 flag 를 true 로 바꿈
        if(cnt==n){
            for(int i=0; i<chosen.size(); i++){
                System.out.print(chosen.get(i));
            }
            System.out.println();
            flag = true;
            return;
        }
        for(int i=4; i<=6; i++){
            if(prevNum!=i){
                chosen.add(i);
                if(!isMultiSequence(chosen)){
                    choose(cnt+1, i);
                }
                chosen.remove(chosen.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        choose(0, 0);
    }
}