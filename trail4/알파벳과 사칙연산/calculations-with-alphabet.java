import java.util.*;
public class Main {
    static int[] alphabetNums = new int[6];
    static ArrayList<Integer> alphabetUsed = new ArrayList<>();
    static Stack<Character> expressionStack = new Stack<>();
    static String expression;
    static int n;
    static int max = -400;
    public static void choose(int cnt){
        if(cnt==n){
            Stack<Character> cs = new Stack<>();
            for(int i=expression.length()-1; i>=0; i--){
                char c = expression.charAt(i);
                cs.push(c);
            }
            int result = alphabetNums[cs.pop()-'a'];
            char op = 0;
            while(!cs.isEmpty()){
                char c = cs.pop();
                int idx = c-'a';
                if((idx>=0)&&(idx<=5)){
                    int num = alphabetNums[idx];
                    if(op == '*'){
                        result = result * num;
                    }
                    if(op == '+'){
                        result = result + num;                        
                    }
                    if(op == '-'){
                        result = result - num;
                    }    
                //System.out.println("result : "+result);
                }else{
                    op = c;
                }
            }
            max = Math.max(max, result);
            return;
        }
        int idx = alphabetUsed.get(cnt);
        for(int i=1; i<=4; i++){
            alphabetNums[idx] = i;
            //System.out.println("cnt : " + cnt + " i : " + i);
            choose(cnt+1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        expression = sc.next();
        
        for(int i=0; i<expression.length(); i++){
            int idx = expression.charAt(i)-'a';
            if((idx>=0)&&(idx<=5)){
                if(!alphabetUsed.contains(idx)){
                    alphabetUsed.add(idx);
                }
            }
        }
        n = alphabetUsed.size();
        choose(0);
        System.out.println(max);
    }
}