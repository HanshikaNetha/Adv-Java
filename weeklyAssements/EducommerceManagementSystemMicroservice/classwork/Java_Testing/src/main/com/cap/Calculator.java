package main.com.cap;

public class Calculator {
	public int add(int a, int b) {
		return a+b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		System.out.println(c.add(2, 3));
	}
	public int subtract(int a, int b) {
		return a-b;
	}
	public boolean IsEven(int a) {
		if(a%2==0) {
			return true;
		}else {
			return false;
		}
	}
	public int divide(int a, int b) {
		return a/b;
	}

}
