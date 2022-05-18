/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

/**
 *
 * @author Riccardo
 */
public class InhTest {
	
	static A anonymousInnerClassAsStaticField = new A(){
		//this is an anonymous inner class that extends class A and it's assigned to a static field
	};

	public static void main(String[] args) {
		Wrapper<B> w1 = new Wrapper<>();
		Wrapper<B> w2 = new Wrapper<B>();
		Wrapper<? super B> w3 = new Wrapper<B>();

//		new B(0);
		
	}
	
	static void testSwitch(){
		switch(1){
			default:
			case 2: System.out.println("impossible"); break;
			case 1: System.out.println("ok"); break;
		}
		
		switch((short) 8){}
		switch('a'){}
		switch("OK"){}
	}

}

class Wrapper<T extends B> {

	public void wrap(T w) {
		System.out.println("Wrapping " + w.getClass());
	}
}

abstract class Z {
	abstract void avv();
}
class Y extends Z {

	@Override
	void avv() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
	
}

class A {
	int num;
	long longnum;
	static String staticString = "asd";
	class Nested {
		int nNum = 1;
		int num = 9;
		final static String s = "";
		{ 
			nNum = A.this.num;
			nNum = nNum + (int)(longnum%Integer.MAX_VALUE);
			System.out.println("static outer is "+staticString);
		}
	}

	public A() {
		System.out.println("empty");
	}
	
	

}

class B extends A {

	public B(int number) {
	
	}

}

class C extends B {

	public C() {
		super(9);
	}

}
