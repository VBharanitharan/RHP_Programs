import java.util.*;
class Main {
    static int[] p = new int[200005];
    static int f(int i) {
        if (p[i] == i) return i;
        return p[i] = f(p[i]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] a = new int[n];
            HashMap<Integer, Integer> v2r = new HashMap<>();
            HashMap<Integer, Integer> r2v = new HashMap<>();
           
            for (int i = 0; i < n; i++) {
                int v = sc.nextInt();
                if (!v2r.containsKey(v)) {
                    v2r.put(v, i);
                    r2v.put(i, v);
                    p[i] = i;  
                    
                }
                a[i] = v2r.get(v);
            }
            for (int i = 0; i < q; i++) {
                int ty = sc.nextInt();
                if (ty == 1) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    if (x == y || !v2r.containsKey(x)) continue;
                    if (!v2r.containsKey(y)) {
                        int rx = v2r.get(x);
                        v2r.put(y, rx);
                        r2v.put(rx, y);
                        v2r.remove(x);
                    } else {
                        int rx = v2r.get(x);
                        int ry = v2r.get(y);
                        p[rx] = ry;
                        v2r.remove(x);
                    }
                } else {
                    int idx = sc.nextInt();
                    int r = f(a[idx - 1]);
                    System.out.println(r2v.get(r));
                }
            }
        }
        sc.close();
    }
}
