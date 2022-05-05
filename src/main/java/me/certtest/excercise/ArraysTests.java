/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.stream.Stream;
import javax.sound.sampled.BooleanControl;

/**
 *
 * @author Riccardo
 */
public class ArraysTests<N> {
    
    public static class MyComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
	    return o2.length() - o1.length();
	}
	
    }
    
    public static class MyComparable implements Comparable<MyComparable> {
	
	@Override
	public int compareTo(MyComparable o) {
	    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	
	
    }
    
    public static class TestGen<Comparable> {
    
    }
    
    static int [][] game = new int[6][6];
    
    static void testArrayPrimitive2(){
	game[3][3] = 6;
	Object[] obj = game;
	obj[3] = "X";
	System.out.println(game[3][3]);
    }

    public static void main(String[] args) {
//	testComparatorLength();
//	testArrayPrimitive();

//	testListOf();

	testSorting();

//	
//	System.out.println("---------- HASH ");
//	testHashMap();

//	testMatrix();

//	Arrays.sort(args);
//	
//	Stream.of(args).forEachOrdered(System.out::println);

    }
    
    static void testListOf(){
	var list = List.of('a', 'c', 'b');
	
	char a = list.get(0);
	Character a1 = list.get(0);
	int a3 = list.get(0);
	long a4 = list.get(0);
	Object a5 = list.get(0);
	
	Object res = new ArrayList().remove(0);
	System.out.println(res);
	
	var arr = new ArrayList<Integer>();
	
    }
    
    static void getExceptions(Collection<? super Exception> exceptions){
	exceptions.add(new RuntimeException());
	exceptions.add(new Exception());
    }
    
    static void testComparatorLength(){
	Stream.of("a","aa","jjjjjjj","11", "aaa").sorted(new MyComparator()).forEachOrdered(System.out::println);
    }
    
    private static int[][] mat;
    
    static void testArrayPrimitive(){
	String[] s = new String[0];
	String[] st1 = new String[]{};
	String[] st2 = new String[]{"AAA", "BBB", "CCC"};
	String[] st3 = new String[]{};
	String[] st4 = new String[]{"a", "b"};
	
	var arr = new ArrayList<>();
	
	int out = Arrays.compare(st2, st4);
	
	System.out.println(Arrays.toString(st2));
	
	int res = Arrays.binarySearch(st2,"BBB");
	System.out.println(res);
	
	System.out.println("OUT is "+out);
	
	mat[3][3] = 5;
	
	s[0] = "asd";
	
	System.out.println(st2[2]);
    }
    
    static void testMatrix(){
	char [][] c = new char [3][3];
	char [] anotherCharMatrix [] = new char[2][2];
	char anotherCharMatrix2[][] = new char [2][5];
	
	System.out.println("length is "+c.length);
	
	c[3][3] = 'x'; //IOOB EXCEPTION
    }
    
    static void testMath(){
	
    }
    
    static void testSet(){
	Set<Integer> s = new HashSet<>(1);
	s.add(1);
	s.add(3);
	s.add(4);
	s.add(null);
	s.forEach(System.out::println);
    }
    
    static void testHashMap(){
	var s = new HashMap<Integer, Integer>();
	s.put(1,1);
	s.put(3,2);
	s.put(4,5);
	s.put(7,null);
	s.put(null,7);
	s.put(null,null);

	
	var ht = new Hashtable<Integer, Integer>();
	ht.put(1,1);
	ht.put(3,2);
	ht.put(4,5);
	//ht.put(7,null);
//	ht.put(null,7);
//	ht.put(null,null);
	
	s.forEach((i1,i2) -> System.out.println(""+i1+" _ "+i2+""));
	ht.forEach((i1,i2) -> System.out.println(""+i1+" _ "+i2+""));
	
//	s.forEach(System.out::println);
    }
    
    static void testArrayDequeue(){
	var a = new ArrayDeque<String>();
	a.offer("a");
	a.offer("b");
	a.offer("c");
	a.offer("z");
	
	var ll = new LinkedList<Integer>();
	ll.offer(18);
	ll.offer(13);
	ll.push(1);
	
	Collection<String> c = new ArrayDeque<>();
	
	var b = new ArrayDeque<>();
	b.offer(1);
	b.offer(2);
    }
    
    static void testSorting(){
	String [] s = new String[]{"Z","aaaa","bbbb","cccc"};
	
	Arrays.sort(s);
	
	int search = Arrays.binarySearch(s, "bbaa");
	
	System.out.println(search);
	
    }
}
