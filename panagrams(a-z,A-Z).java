// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class bitwise {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int flag1=0;//lowercase
        int flag2=0;//upper
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='a'&&ch<='z'){
            flag1=flag1|(1<<(ch-'a'));}
            else{
                flag2=flag2|(1<<(ch-'A'));
            }
        }
        if((flag1==(1<<26)-1)&&(flag2==(1<<26)-1)){
            System.out.println("yes(both upper and lower case are present)");
        }
	
        else{
            System.out.println("no");
        }
    }
}