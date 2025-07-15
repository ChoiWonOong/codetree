import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int r = sc.nextInt();
            char d = sc.next().charAt(0);
            transition(a, r, d);
            
        }
        for (int j = 0; j < n; j++){
            for (int k = 0; k < m; k++){
                System.out.print(a[j][k] + " ");
            }
            System.out.println();
        }
    }
    public static void blowLeft(int[] row){
        int temp = row[0];
        for(int i=0; i<row.length-1; i++){
            int index = (i+1)%(row.length);
            row[i] = row[index];
        }
        row[row.length-1] = temp;
    }
    public static void blowRight(int[] row){
    int last = row[row.length - 1];
    for(int i = row.length - 1; i > 0; i--){
        row[i] = row[i - 1];
    }
    row[0] = last;
}

    public static boolean hasSameValueInColumn(int[] row1, int[] row2){
        for(int i=0; i<row1.length; i++){
            //System.out.println("1 : " + row1[i] + ", 2 : " + row2[i]);
            if(row1[i]==row2[i]){
                //System.out.println(true);
                return true;
            }
        }
        return false;
    }
    public static void transition(int[][] mat, int n, char c){
        char direction = c;
        if(direction=='R'){
            blowLeft(mat[n-1]);
            direction = 'L';
        }else{
            blowRight(mat[n-1]);
            direction = 'R';
        }
        for(int i=n-1; i>0; i--){
            if(hasSameValueInColumn(mat[i], mat[i-1])){
                if(direction=='R'){
                    blowLeft(mat[i-1]);
                    direction = 'L';
                }else{
                    blowRight(mat[i-1]);
                    direction = 'R';
                }
            }else{
                break;
            }
        }
        if(c=='R'){
            direction = 'L';
        }else{
            direction = 'R';
        }
        for(int i=n-1; i<mat.length-1; i++){
            
            if(hasSameValueInColumn(mat[i], mat[i+1])){
                if(direction=='R'){
                    blowLeft(mat[i+1]);
                    direction = 'L';
                }else{
                    blowRight(mat[i+1]);
                    direction = 'R';
                }
            }else{
                break;
            }
        }
    }
}