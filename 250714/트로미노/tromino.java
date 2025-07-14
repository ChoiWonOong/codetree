import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[] ax = {1, 0, -1, 0, 1};
        int[] ay = {0, 1, 0, -1, 0};

        int[] bx = {-1, 1, 0, 0};
        int[] by = {0, 0, -1, 1};

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //System.out.println("(" + j + ", " + i + ")");
                //System.out.println();

                // ㄴ 모양
                for (int k = 0; k < 4; k++) {
                    int temp = 0;
                    int y1 = i + ay[k];
                    int x1 = j + ax[k];

                    int y2 = i + ay[k + 1];
                    int x2 = j + ax[k + 1];

                    if ((x1 >= m) || (x1 < 0) || (x2 >= m) || (x2 < 0)
                            || (y1 >= n) || (y1 < 0) || (y2 >= n) || (y2 < 0)) {
                        continue;
                    }

                    temp += grid[i][j];
                    temp += grid[y1][x1];  // ✅ 올바른 순서
                    temp += grid[y2][x2];

                    if (result < temp) {
                        result = temp;
                        //System.out.println("ㄴ");
                        //System.out.println("(" + j + ", " + i + ") = " + grid[i][j]);
                        //System.out.println("(" + x1 + ", " + y1 + ") = " + grid[y1][x1]);
                        //System.out.println("(" + x2 + ", " + y2 + ") = " + grid[y2][x2]);
                        //System.out.println(result);
                    }
                }

                // ㅣ 모양 (bx, by 기반)
                for (int k = 0; k < 2; k++) {
                    int temp = 0;
                    int y1 = i + by[2 * k];
                    int x1 = j + bx[2 * k];

                    int y2 = i + by[2 * k + 1];
                    int x2 = j + bx[2 * k + 1];

                    if ((x1 >= m) || (x1 < 0) || (x2 >= m) || (x2 < 0)
                            || (y1 >= n) || (y1 < 0) || (y2 >= n) || (y2 < 0)) {
                        continue;
                    }

                    temp += grid[i][j];
                    temp += grid[y1][x1];  // ✅ 순서 정정
                    temp += grid[y2][x2];

                    if (result < temp) {
                        result = temp;
                        //System.out.println("ㅣ");
                        //System.out.println("(" + j + ", " + i + ") = " + grid[i][j]);
                        //System.out.println("(" + x1 + ", " + y1 + ") = " + grid[y1][x1]);
                        //System.out.println("(" + x2 + ", " + y2 + ") = " + grid[y2][x2]);
                        //System.out.println(result);
                    }
                }
            }
        }

        //System.out.println();
        System.out.println(result);
    }
}
