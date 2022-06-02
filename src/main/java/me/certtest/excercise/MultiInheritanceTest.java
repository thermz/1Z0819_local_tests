/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;


interface A2 {
	void doSomething();
}
interface A1 {
	void doSomething();
}
interface D1 {
	default void doSomething(){}
}
interface D2 {
	default void doSomething(){}
}

abstract class AClass1d implements A1, A2 {	
}
abstract class AClass1 implements D1, D2 {
	public void doSomething(){}
}
class BClass2 implements D1, D2 {
	public void doSomething(){}
}
class BClass3 implements A1, D2 {
	public void doSomething(){}
}
abstract class AClass2 implements A1, D2 {
	public void doSomething(){}
}
interface E extends A1, D1 {
	default void doSomething(){}
}

abstract class ADoSomething{
	public void doSomething(){
		
	}
}

class I extends ADoSomething implements A1, A2, D1, D2 {

	@Override
	public void doSomething() {
		super.doSomething();
	}
	
}

public class MultiInheritanceTest {
	
	public static void main(String[] args) {
		
	}
	
}
