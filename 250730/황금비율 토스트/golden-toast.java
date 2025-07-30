import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Scanner 대신 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        String s = br.readLine();

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) iter.next(); // 커서를 끝으로 이동

        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            if (line.equals("L")) {
                if (iter.hasPrevious()) iter.previous();
            } else if (line.equals("R")) {
                if (iter.hasNext()) iter.next();
            } else if (line.equals("D")) {
                if (iter.hasNext()) {
                    iter.next();
                    iter.remove();
                }
            } else if (line.startsWith("P ")) {
                iter.add(line.charAt(2)); // "P x" 형태에서 x만 추출
            }
        }

        for (char c : list) sb.append(c);
        System.out.println(sb);
    }
}
