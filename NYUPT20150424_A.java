//fails on test 5
//Algorithm and data structure are not difficult but requires interesting observations
//If you put all odd numbers and then even numbers sequentially
//All cases with larger n can be solved with all even and then all odd

import java.util.*;
public class Main {
   public static void main(String[] args) {
    //add all numbers to queue
    //pop top of queue and check end of current list
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    longest(n);
  }
  private static void longest(int n) {
    Queue<Integer> q = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    int count = 1;
    int last = 1;
    int first = 1;
    StringBuilder s = new StringBuilder("1");
    for(int i=2; i<=n; i++) {
      if((i-last)==1) {
        q.add(i);
      } else {
        s.append(" "+i);
        last = i;
        count++;
      }
      if(q.size()>0) {
        while(q.size()>0) {
          int temp = q.poll();
          if(Math.abs((temp-last))==1) {
            q2.add(temp);
          } else {
            s.append(" "+temp);
            last = temp;
            count++;
          }
        }
        while(q2.size()>0) {
          q.add(q2.poll());
        }
      }
    }
    if(q.size()>0) {
      int temp = q.poll();
      if(Math.abs(temp-first)!=1) {
        s.insert(0,temp+" ");
        count++;
        first = temp;
      }
    }
    System.out.println(count);
    System.out.println(s);
  }
}
