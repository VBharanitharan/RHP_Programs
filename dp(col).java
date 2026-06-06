// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       int[][] a  = new int[n][m];
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               a[i][j]=sc.nextInt();
           }
       }
       long[][] c = new long[n][m];
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(i==0){
                   c[i][j]=a[i][j];
               }
           }
           
       }
       for(int i=1;i<n;i++){
           long[] fmax=getFSmax(a,i-1,n,m);
           for(int j=0;j<m;j++){
              c[i][j]=a[i][j]+(c[i-1][j]==fmax[0]?fmax[1]:fmax[0]);
              
           }
           import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int m = sc.nextInt(); 

        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        long[][] dp = new long[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][0] = a[i][0];
        }

        for (int j = 1; j < m; j++) {

            long[] maxs = getFSmax(dp, j - 1, n);
            long firstMax = maxs[0];
            long secondMax = maxs[1];

            for (int i = 0; i < n; i++) {

                dp[i][j] = a[i][j]
                        + (dp[i][j - 1] == firstMax
                           ? secondMax
                           : firstMax);
            }
        }

        long ans = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i][m - 1]);
        }

        System.out.println(ans);
    }

    private static long[] getFSmax(long[][] dp, int col, int n) {

        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (dp[i][col] > firstMax) {
                secondMax = firstMax;
                firstMax = dp[i][col];
            }
            else if (dp[i][col] > secondMax) {
                secondMax = dp[i][col];
            }
        }

        return new long[] { firstMax, secondMax };
    }
}
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            System.out.print(c[i][j]+" ");
        }
        System.out.println();
    }
}
private static long[] getFSmax(long[][] c,int k,int n,int m){
    int fsmax=0;
    int ssmax=0;
    for(int j=0;j<m;j++){
        if(c[k][j]>fsmax){
            ssmax=fsmax;
            fsmax=c[k][j];
        }
        else if(c[k][j]>ssmax){
            ssmax=c[k][j];
        }
    }
    return new long[]{fsmax,ssmax};
}
}