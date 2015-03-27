// 
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int cases = input.nextInt();
    for(int p=0;p<cases;p++) {
      int l = input.nextInt();
      String s = input.next();
      System.out.println(ordered(s));
    }
    
  }
  private static String ordered(String s) {
    char[] s2 = s.toCharArray();
    for(int i=0;i<s.length();i++) {
      int swap = smallest(s2,i);
      if(swap==i) {
        continue;
      }
      char temp = s2[i];
      s2[i] = s2[swap];
      s2[swap] = temp;
      break;
    }
    return new String(s2);
  }
  private static int smallest(char[] s, int i) {
    int ans = i++;
    while(i<s.length) {
      if(s[i]<s[ans]) {
        ans=i;
      }
      i++;
    }
    return ans;
  }
}
