import java.util.ArrayList;

//use a filter to filter out all the non-Prime numbers
public class Solution {
	//filter by the prime factor
	public static ArrayList<Integer> getPrime2(int n) {
		ArrayList<Integer> prime = new ArrayList<Integer>();
		boolean [] flag = new boolean [n+1]; 
		for (int i = 2; i <= n; i++) {
			if (!flag[i]) {
				prime.add(i);
				for(int j = 2; j * i <= n; j++ ) {
					flag[j*i] = true;
				}
			}
		}
		return prime;
	}
	//filter by the minimum prime factory only
	public static ArrayList<Integer> getPrime(int n) {
		ArrayList<Integer> prime = new ArrayList<Integer>();
		boolean [] flag = new boolean [n+1]; 
		/* Starting from 2, iterate through all the elements
		 * for every element, filter out the product of all the prime number and the current element. 
		 * What was left will be the the prime number
		 */
		for (int i = 2; i <= n; i++) {
			if (!flag[i])
				prime.add(i);
			for (int j = 0; j < prime.size() && prime.get(j) * i <= n; j++) {
				flag[prime.get(j) * i] = true;
				if (i % prime.get(j) == 0) // stop if hit the minimum prime factor
					break;
			}
		}
		return prime;
	}
	
	public static void main(String [] args) {
		System.out.println(getPrime2(20));
	}
}

