import java.util.*;

public class Main {
    public static class Segment implements Comparable<Segment> {
        int start, end;
        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Segment o) {
            if (this.end != o.end) return this.end - o.end;
            return this.start - o.start;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Segment> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            segments.add(new Segment(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(segments);

        int count = 0;
        int lastEnd = -1;  // 마지막으로 선택한 선분의 end

        for (int i = 0; i < n; i++) {
            Segment cur = segments.get(i);
            if (lastEnd < cur.start) {  // 끝점 공유도 겹침이므로 
                count++;
                lastEnd = cur.end;
            }
        }

        System.out.println(count);
    }
}