package main.com.cap;

public class Factorial {
	public int fac(int n) {
		int pro=1;
		while(n>=1) {
			pro*=n;
			n--;
		}
		return pro;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
