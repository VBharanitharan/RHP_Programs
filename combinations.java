import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int l = s.length();
        
        for (int i = 1; i < (1 << l); i++) {
            String a = "";
            for (int sh = 0; sh < l; sh++) {
                if ((i & (1 << sh)) > 0) {
                    a += s.charAt(sh);
                }
            }
            System.out.println(a); 
        }
    }
}
