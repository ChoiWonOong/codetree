import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        sc.nextLine();

        LinkedList<Character> list = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            list.add(c);
        }
        ListIterator<Character> iter = list.listIterator();
        while(iter.hasNext()){
            iter.next();
        }
        for (int i = 0; i < m; i++) {
            String command = sc.nextLine();
            String[] tokens = command.split(" ");
            if(tokens[0].equals("R")){
                if(iter.hasNext()){
                    iter.next();
                }
            }else if(tokens[0].equals("L")){
                if(iter.hasPrevious()){
                    iter.previous();
                }
            }else if(tokens[0].equals("D")){
                if(iter.hasNext()){
                    iter.next();
                    iter.remove();
                }
            }else if(tokens[0].equals("P")){
                iter.add((char)tokens[1].charAt(0));
            }else{
                System.out.println("Wrong Command : " + command);
            }
        }
        
        // Please write your code here.
        iter = list.listIterator();
        while(iter.hasNext()){
            System.out.print((char)iter.next());
        }
    }
}