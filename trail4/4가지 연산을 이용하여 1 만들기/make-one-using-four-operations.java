import java.util.*;
public class Main {
    static boolean[] visited;
    static int[] scores;
    static int n;
    static int minOp = Integer.MAX_VALUE;
    static void visit(int num, int score){
        visited[num] = true;
        scores[num] = score;
    }
    static void checkScore(int num, int score){
        if(visited[num]){
            if(score<scores[num]){
                scores[num] = score;
            }
        }
    }
    static void bfs(int num){
    Queue<Integer> queue = new LinkedList<>();
    queue.add(num);
    visit(num, 0);
    while(!queue.isEmpty()){
        int curNum = queue.poll();
        int curScore = scores[curNum];

        if(curNum == 1){
            minOp = curScore;
            return;
        }

        int[] nexts = {
            curNum - 1,
            curNum + 1,
            curNum % 2 == 0 ? curNum/2 : -1,
            curNum % 3 == 0 ? curNum/3 : -1
        };

        for(int newNum : nexts){
            if(newNum < 0 || newNum >= 1000000) continue;
            if(visited[newNum]) continue;
            visit(newNum, curScore+1);
            queue.add(newNum);
        }
    }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        visited = new boolean[1000001];
        scores = new int[1000001];

        bfs(n);
        
        System.out.println(minOp);
        for(int i=0; i<=16; i++){
            //System.out.print(scores[i] + " ");
        }
        //System.out.println();
    }
}