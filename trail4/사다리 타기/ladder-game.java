import java.util.*;
public class Main {
    static int n;
    static int m;
    static int[] positions;
    static int[] givenPositions;
    static ArrayList<Integer> sortedList = new ArrayList<>();
    // positions 와 givenPositions 가 같은 위치를 같은 최솟값 min
    static int min;

    public static void choose(int idx, int cnt){
        boolean flag = true;
        if(idx == sortedList.size()){
            for(int i=0; i<n; i++){
                if(positions[i] != givenPositions[i]){
                    flag = false;
                    break;
                }
            }
            if(flag) min = Math.min(cnt, min);
            return;
        }
        // cnt 가 min 과 같으면 다음 분기로
        if(cnt==min){
            return;
        }
        for(int i=0; i<n; i++){
            // 한 부분이라도 위치가 다르면 false
            if(positions[i]!=givenPositions[i]){
                flag = false;
                break;
            }
        }
        // positions 와 givenPosions 가 같은 값을 가졌을 때 cnt 와 min 사이에 Math.min 실행
        if(flag){
            //System.out.println("min -> " + cnt);
            min = Math.min(cnt,min);
            return;
        }else{
            int ladderNum = sortedList.get(idx);
            int tempNum = positions[ladderNum];
            int tempNump1 = positions[ladderNum-1];
            // idx 에 해당하는 사다리 위치의 사람 이동
            positions[ladderNum] = positions[ladderNum-1];
            positions[ladderNum-1] = tempNum;
            choose(idx+1, cnt+1);
            // 위치 복구
            positions[ladderNum] = tempNum;
            positions[ladderNum-1] = tempNump1;
            choose(idx+1, cnt);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        min = m;
        // 답을 구하는 데 필요한 위치와 문제에 주어진 위치 초기화
        positions = new int[n];
        givenPositions = new int[n];
        for(int i=0; i<n; i++){
            positions[i] = i+1;
            givenPositions[i] = i+1;
        }
        // m 개의 세로줄을 입력할 수 있는 ArrayList 생성
        ArrayList<Integer>[] rowPositions = new ArrayList[15];
        // ArrayList 초기화
        for(int i=0; i<15; i++){
            rowPositions[i] = new ArrayList<>();
        }
        // b 라는 순서에 a 위치의 가로줄 삽입 
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            rowPositions[b-1].add(a);
        }
        // 정렬된 리스트
        for(int i=0; i<15; i++){
            ArrayList<Integer> rows = rowPositions[i];
            for(int j=0; j<rows.size(); j++){
                sortedList.add(rows.get(j));
            }
        }
        // 문제에 주어진 결과 위치
        for(int i=0; i<sortedList.size(); i++){
            int row = sortedList.get(i);
            int temp = givenPositions[row];
            givenPositions[row] = givenPositions[row-1];
            givenPositions[row-1] = temp;
        }
        choose(0, 0);
        
        System.out.println(min);
    }
}