package javaPractice;


public class Test {
	public static void main(String[] args) {
		A a = new C();
		a.printMessage();
	
	}
}


class A {
	void printMessage() {
		System.out.print("In A");
	}
}

class B extends A {
	void printMessage() {
		System.out.println("in B");
	}
}

class C extends B {
	
}