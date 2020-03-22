

public class Solution {
  public static void main(String args[]) {
	  Solution sol = new Solution();
	  System.out.println(sol.answer("0"));
  }
  
  int answer (String S) {
	  int num = Integer.parseInt(S,2);
	  return step(num,0);
  }
  
  private int step(int num,int count) {
	  if(num==0) {
		  return count;
	  }
	  count++;
	  
	  
	  if(num % 2 ==0) {
		  return step(num/2,count);
		  
	  }else {
		  return step(num-1,count);
	  }
	  
  }
}