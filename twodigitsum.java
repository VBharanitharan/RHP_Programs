import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int seelcs(String x, String y) {
        int r = x.length();
        int c = y.length();
        int[] mx = new int[r];
        int[] my = new int[c];
        
        mx[0] = x.charAt(0) - '0';
        my[0] = y.charAt(0) - '0';
        
        for (int i = 1; i < r; i++) {
            mx[i] = (mx[i - 1] + x.charAt(i) - '0') % 10;
        }
        for (int i = 1; i < c; i++) {
            my[i] = (my[i - 1] + y.charAt(i) - '0') % 10;
        }
        
        if (mx[r - 1] != my[c - 1]) {
            return -1;
        }
        
        int[][] dp = new int[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (mx[i - 1] == my[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[r][c];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.summary ? "" : System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            String x = sc.next();
            String y = sc.next();
            res[i] = seelcs(x, y);
        }
        
        for (int i : res) {
            System.out.println(i);
        }
        sc.close();
    }
}
