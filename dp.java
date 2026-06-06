import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a1[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a1[i][j] = sc.nextInt();
            }
        }

        long c[][] = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    c[i][j] = a1[i][j];
                }
            }
        }

        for (int i = 1; i < n; i++) {

            long fsmax[] = getFSmax(c, i - 1);

            for (int j = 0; j < m; j++) {
                c[i][j] = a1[i][j]
                        + (c[i - 1][j] == fsmax[0] ? fsmax[1] : fsmax[0]);
            }
        }

        long max = Long.MIN_VALUE;

        for (int j = 0; j < m; j++) {
            max = Math.max(max, c[n - 1][j]);
        }

        System.out.println(max);
    }

    private static long[] getFSmax(long[][] c, int row) {

        long fmax = Long.MIN_VALUE;
        long smax = Long.MIN_VALUE;

        for (int j = 0; j < c[0].length; j++) {

            if (c[row][j] > fmax) {
                smax = fmax;
                fmax = c[row][j];
            } else if (c[row][j] > smax) {
                smax = c[row][j];
            }
        }

        return new long[] { fmax, smax };
   }
}