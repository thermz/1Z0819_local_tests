/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

import java.text.MessageFormat;
import me.certtest.excercise.inter.AnotherTestInterface;
import me.certtest.excercise.inter.TestInterface;

/**
 *
 * @author Riccardo
 */
public class FTest extends SuperIFTest{
    final public long variable=1;
    final public int variable2=4;

    static {System.out.println("sc");}
    { System.out.println("6"); }

    public FTest() {
        System.out.println("3");
    }
    
    void testMe() {
        
    }
    
    public void FinalTest (){
        System.out.println("method same name like class");
    }

    @Override
    int anAbstractMethod() {
	String superString = check("");
	System.out.println(superString);
	
	return superString.length();
    }
    
    final protected class SubClass {
        final public long variable = 5;
        
        void test(){
           String s = String.valueOf(this.variable);
           String s2 = String.valueOf(FTest.this.variable);

           System.out.println(s);
        }
    }
        
    public static void main(String[] args) {
        new FTest().FinalTest();
	
	double i = (Double.valueOf(2.0)+ Integer.valueOf(1));
	
	new FTest().anAbstractMethod();
    }
    
    public static long testRes(){
        return 5;
    }
    
    static void testMyIF(){
	int variable = MyIF.num;
	
    }
    
}

abstract class SuperIFTest implements TestInterface, AnotherTestInterface {

    public String check(CharSequence seq) {
	String color1 = AnotherTestInterface.super.check(seq);
	String color2 = (String) TestInterface.super.check(seq);
	
	var res = MessageFormat.format("OK {0}, {1} and then again {0}",color1, color2);

	return res;
    }
    
    abstract int anAbstractMethod();
    
}

abstract class SuperFTest {
    static { System.out.println("sa");}
    public SuperFTest() {
        System.out.println("1");
    }
    
    { System.out.println("5"); }
    
    abstract void testMe();
    
}

interface MyIF {
    
    int num = 1;
    
    public static String testStaticInIF(){
        return "ASD";
    }
    
    private String privateMethodInIF(){
        return "pr";
    }
    
}