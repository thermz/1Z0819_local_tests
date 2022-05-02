/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

/**
 *
 * @author Riccardo
 */
public class FTest extends SuperFTest{
    final public long variable=1;
    final public int variable2=4;

    static {System.out.println("sc");}
    { System.out.println("6"); }

    public FTest() {
        System.out.println("3");
    }
    
    @Override
    void testMe() {
        
    }
    
    public void FinalTest (){
        System.out.println("method same name like class");
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
	
	Double i = (Double.valueOf(2.0)+ Integer.valueOf(1));
    }
    
    public static long testRes(){
        return 5;
    }
    
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
    
    public static String testStaticInIF(){
        return "ASD";
    }
    
    private String privateMethodInIF(){
        return "pr";
    }
    
}