/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

import java.util.*;
import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.sound.sampled.BooleanControl;

class ArrWrap {
	String [] arr;

	public ArrWrap(String[] arr) {
		this.arr = arr;
	}
	
}

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

	static int[][] game = new int[6][6];

	static void testArrayPrimitive2() {
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
//	testFor();
		testArrs();

//	
//	System.out.println("---------- HASH ");
//	testHashMap();
//	testMatrix();
//	Arrays.sort(args);
//	
//	Stream.of(args).forEachOrdered(System.out::println);
	}

	static void testListOf() {
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

	static void getExceptions(Collection<? super Exception> exceptions) {
		exceptions.add(new RuntimeException());
		exceptions.add(new Exception());
	}

	static void testComparatorLength() {
		Stream.of("a", "aa", "jjjjjjj", "11", "aaa").sorted(new MyComparator()).forEachOrdered(System.out::println);
	}

	private static int[][] mat;

	static void arr(String[] arr) {

	}

	static void testArrayPrimitive() {
		String[] s = {};
		String[] st1 = {};
		String[] st2 = {"AAA", "BBB", "CCC"};
		String[] st3 = {};
		String[] st4 = {"a", "b"};

		arr(new String[]{""});

		var arr = new ArrayList<>();

		int out = Arrays.compare(st2, st4);

		System.out.println(Arrays.toString(st2));

		int res = Arrays.binarySearch(st2, "BBB");
		System.out.println(res);

		System.out.println("OUT is " + out);

		mat[3][3] = 5;

		s[0] = "asd";

		System.out.println(st2[2]);
	}

	static void testMatrix() {
		char[][] c = new char[3][3];
		char[] anotherCharMatrix[] = new char[2][2];
		char anotherCharMatrix2[][] = new char[2][5];

		System.out.println("length is " + c.length);

		c[3][3] = 'x'; //IOOB EXCEPTION
	}

	static void testMath() {

	}

	static void testSet() {
		Set<Integer> s = new HashSet<>(1);
		s.add(1);
		s.add(3);
		s.add(4);
		s.add(null);
		s.forEach(System.out::println);
	}

	static void testHashMap() {
		var s = new HashMap<Integer, Integer>();
		s.put(1, 1);
		s.put(3, 2);
		s.put(4, 5);
		s.put(7, null);
		s.put(null, 7);
		s.put(null, null);

		var ht = new Hashtable<Integer, Integer>();
		ht.put(1, 1);
		ht.put(3, 2);
		ht.put(4, 5);
		//ht.put(7,null);
//	ht.put(null,7);
//	ht.put(null,null);

		s.forEach((i1, i2) -> System.out.println("" + i1 + " _ " + i2 + ""));
		ht.forEach((i1, i2) -> System.out.println("" + i1 + " _ " + i2 + ""));

//	s.forEach(System.out::println);
	}

	static void testArrayDequeue() {
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

		var q = new LinkedList<>();

	}
	
	static final Comparator<Comparable> ASCENDING = (a, b) -> a.compareTo(b);

	static void testSorting() {
		String[] s = new String[]{"Z", "aaaa", "bbbb", "cccc"};
		Arrays.sort(s);

		int search = Arrays.binarySearch(s, "bbaa");
		System.out.println(search);

		testSorting( sa -> new ArrayList<String>(asList(sa)));
		testSorting( sa -> asList(sa));
		testSorting( sa -> List.of(sa));
	}
	
	static void testSorting(Function<String[],List<String>> listSupplier){
		String[] sa = {"charlie", "bob", "andy", "dave"};
		List<String> l = listSupplier.apply(sa);
		l.sort(ASCENDING);
		System.out.println(sa[0] + " " + l.get(0));
	}

	private static List<Integer> boxPrimitiveArrays(int[] a1) {
		return IntStream.of(a1).boxed().collect(Collectors.toList());
	}

	static void testArraysCompare(int[] a1, int[] a2) {
		int res = Arrays.compare(a1, a2);
		List<Integer> l1 = boxPrimitiveArrays(a1);
		List<Integer> l2 = boxPrimitiveArrays(a2);
		System.out.println(asList(a1).getClass());
		System.out.println("Compared " + l1 + " with " + l2 + " with result " + res);
	}

	static void testArraysMismatch(int[] a1, int[] a2) {
		int res = Arrays.mismatch(a1, a2);
		List<Integer> l1 = boxPrimitiveArrays(a1);
		List<Integer> l2 = boxPrimitiveArrays(a2);
		System.out.println("Mismatched " + l1 + " with " + l2 + " with result " + res);
	}

	static void testBothArraysMethods(int[] a1, int[] a2) {
		testArraysCompare(a1, a2);
		testArraysMismatch(a1, a2);
	}

	static void testArrs() {
		int[] a1 = {1, 2, 6};
		int[] a2 = {2, 3};
		int[] a3 = {1, 2, 4};
		int[] a4 = {9};
		int[] a5 = {0, 3};
		int[] empty = {};

		int[] many = {1, 2, 6, 8, 7, 56, 4, 3, 3, 3};

		testBothArraysMethods(a1, a2);
		testBothArraysMethods(a3, a1);
		testBothArraysMethods(a2, a4);
		testBothArraysMethods(a1, a3);
		testBothArraysMethods(a4, a2);
		testBothArraysMethods(a2, a5);
		testBothArraysMethods(a1, a1);
		testBothArraysMethods(a1, many);
		testBothArraysMethods(a4, empty);
		testBothArraysMethods(empty, a1);

	}

	static void hangs1() {
		do {
		} while (true);
	}

	static void hangs2() {
		for (;;) {

		}
	}

	static void hangs3() {
		while ( ! false) {
		}
	}

	static void testFor() {
		var l = List.of(3, 4, 56, 3, 2, 653, 2, 3, 5, 6);
		for (int i = 0; i < l.size();  ++ i) {
			System.out.println(l.get(i));
		}
		System.out.println("---------------");
		for (int i = 1; i <= l.size(); i += 1) {
			System.out.println(l.get(i - 1));

		}
		System.out.println("---------------");
		for (var i : l) {
			System.out.println(i);
		}

		hangs2();

		int a = 0;
		if ((a += 1) == 0) {
			System.out.println("true a is " + a);
		} else {
			System.out.println("false a is " + a);
		}
	}
}
