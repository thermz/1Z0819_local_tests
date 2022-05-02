/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

import java.io.File;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Riccardo
 */
public class TypesTest {

    int n1, n2=0;
    
    public static void main(String[] args) {
	testStrings();
	
    }
    
    static void testLists(){
	List<Object> l = List.of(1,2,"3");
	List<Object> l1 = asList(1,2,"3",4);
	List<Number> l2 = List.of(1,2.2,3.3,4.4);
	var l3 = asList(1,2.2,3.3,4.4);
	List<?> objects = new ArrayList<String>();
	
	System.out.println(l3.getClass());
	
	var stringList = List.of("aa","bb","ccc");
    }
    
    
    static void testStrings(){
	StringBuffer sb =  new StringBuffer().append("12345");
	sb.reverse();
	
	System.out.println(sb.toString());
	
	String s = "123aaa321";
	System.out.println(s.substring(0, s.length() -1));
	
	sb = new StringBuffer("astring");
	sb.substring(2);
	sb.replace(0, 2, "OK");
	System.out.println(sb);
	
	StringBuilder sbd = new StringBuilder("astring");
	sbd.substring(2);
	sbd.replace(0, 2, "OK");
	System.out.println(sbd);
	
    }
    
    static void testTypeDeclarations(){
	var decimalVar = 4.13;
	float decimalFloat = 3.14f;
	double decimalDouble = 3.14;
	Comparator<String> c = (var a1, var a2) -> 0;
    }
    
    
}