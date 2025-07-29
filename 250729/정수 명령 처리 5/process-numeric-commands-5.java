import java.util.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String command = sc.nextLine();
            String[] tokens = command.split(" ");
            if(tokens[0].equals("push_back")){
                int num = Integer.parseInt(tokens[1]);
                list.add(num);
            }else if(tokens[0].equals("pop_back")){
                list.remove(list.size()-1);
            }else if(tokens[0].equals("size")){
                System.out.println(list.size());
            }else if(tokens[0].equals("get")){
                int num = Integer.parseInt(tokens[1]);
                System.out.println(list.get(num-1));
            }else{
                System.out.println("Wrong Command " + command);
            }
        }
    }
}