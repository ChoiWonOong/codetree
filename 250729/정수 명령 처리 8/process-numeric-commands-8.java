import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();
            // Please write your code here.
            String[] tokens = command.split(" ");
            if((tokens[0]).equals("push_front")){
                int num = Integer.parseInt(tokens[1]);
                list.addFirst(num);
            }else if((tokens[0]).equals("push_back")){
                int num = Integer.parseInt(tokens[1]);
                list.addLast(num);
            }else if((tokens[0]).equals("pop_front")){
                System.out.println(list.pollFirst());
            }else if((tokens[0]).equals("pop_back")){
                System.out.println(list.pollLast());
            }else if((tokens[0]).equals("size")){
                System.out.println(list.size());
            }else if((tokens[0]).equals("empty")){
                if(list.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if((tokens[0]).equals("front")){
                System.out.println(list.peekFirst());
            }else if((tokens[0]).equals("back")){
                System.out.println(list.peekLast());
            }else {
                System.out.println("Wrong Commands : " + command);
            }
        }
    }
}