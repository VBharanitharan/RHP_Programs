import java.util.*;
public class Dlsj{
	public static int find(int[] ldr,int i) {
		if(ldr[i]==i) {
			return i;
		}
		 return find(ldr, ldr[i]); 
		
	}
	public static void Munion(int[] ldr,int lt,int rt) {
		int ldlft=find(ldr,lt);
		int ldrt=find(ldr,rt);
		ldr[ldrt]=ldlft;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] ldr = new int[n+1];
		for(int i=1;i<=n;i++) {
			ldr[i]=i;
		}
		int m=sc.nextInt();
		for(int i=0;i<m;i++) {
			int lt=sc.nextInt();
			int rt=sc.nextInt();
			Munion(ldr,lt,rt);
		}
		Set<Integer> s = new HashSet<>();
		for(int i=1;i<=n;i++) {
			s.add(find(ldr,i));
		}
		System.out.println(s.size());
	}
}
