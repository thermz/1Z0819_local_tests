/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Riccardo
 */
public class ExceptionTests extends SuperExceptionTests{
    
    public static void main(String[] args) throws Exception{
        var tc1 = new TestCloseable();
        var tc2 = new TestCloseable();
        var tc3 = new TestCloseable();
        var tc4 = new TestCloseable();
        var tc5 = new TestCloseable();

        try(tc1; tc2; tc3; tc4; tc5;){
            throw new RuntimeException();
        } catch (RuntimeException e){
            System.out.println("Exception!!!");
        } finally {
//            throw new Exception();
        }
	
	testCollectionException(new ArrayList());
                
    }

    protected void checkedExceptionMethod() throws IOException {
        
    }
    
    static void testCollectionException(Collection<? super Exception> exc){
	exc.add(new RuntimeException());
	exc.add(new Exception());
	exc.add(new IllegalStateException());
	
	System.out.println("size is "+exc.size());
    }
    
}

class NumberException extends NumberFormatException {}

class SuperExceptionTests {
    protected void checkedExceptionMethod() throws IOException {
        var nnnnb2 = "";
    }
}

class BeOrNot2Be extends Exception {}

class TestCloseable implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("closing "+this.toString());
    }
    
}
