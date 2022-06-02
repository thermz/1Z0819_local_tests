/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Riccardo
 */
public class LambdaTests {

	public int testValue = 39;
	private final BooleanSupplier testFieldLambda;

	{
		testFieldLambda = () -> testValue > 3;
	}

	void testSupplierOfField() {
		System.out.println(testFieldLambda.getAsBoolean());
		testValue = 29;
		System.out.println(testFieldLambda.getAsBoolean());
		testValue = 0;
		System.out.println(testFieldLambda.getAsBoolean());
		testValue = 15;
		System.out.println(testFieldLambda.getAsBoolean());

	}

	void parallelTest() {

		IntStream.range(1, 6).parallel().limit(2).forEachOrdered(System.out::print);

		CopyOnWriteArrayList<Integer> arr = new CopyOnWriteArrayList<>();
	}

	static void testStream() {
		var list = List.of("aaaa", "bbbb", "cc", "abcd");

		Map<Boolean, List<String>> grouped = list.stream().collect(Collectors.groupingBy(v -> v.length() == 4));

		Map<String, String> cMap = new ConcurrentHashMap();
		cMap.put("K", "V");
		cMap.put("K1", "V1");
		cMap.put("K", "V1");
		cMap.put("K2", "V2");

		cMap.forEach((k, v) -> System.out.println("Key " + k + " Val " + v));

		System.out.println(grouped);
	}

	public static void main(String[] args) {
//		new LambdaTests().testStreamToIntStream();
//
//		IntStream.rangeClosed(1, 20).forEach(i -> {
//			new LambdaTests().parallelTest();
//			System.out.println("---");
//		});
//
//		Predicate<String> pred = (final  var s) -> true;
//
//		testGenerate();

		testReduce();

//		testStream();
//
//		new LambdaTests().testSupplierOfField();
	}

	void testStreamToIntStream() {
		var list = List.of(1, 2, 3, 4, 5);
		int res = list.stream().parallel().peek(System.out::print).reduce((x, y) -> x + y).orElse(0);
		IntStream.rangeClosed(1, 20).forEach(i -> {
			System.out.println("");
			list.stream().parallel().forEachOrdered(System.out::print);
			System.out.println("");
		});
		System.out.println(res);
	}

	static void testGenerate() {
		Stream.generate(() -> "*")
			.limit(3)
			.sorted((s, t) -> s.length() - t.length())
			.distinct()
			.forEach(System.out::println);

		boolean c = Stream.iterate(1, i -> i).limit(5).noneMatch(i -> i > 5);
		System.out.println(c);
	}

	static void testReduce() {
		var l = List.of(1, 3, 5);
		float fres = l.stream().parallel().reduce(0f, (x, y) -> x.floatValue() + y.floatValue(), (x, y) -> x.floatValue() + y.floatValue());

		System.out.println("Float res is "+fres);
		
		List<Integer> ls = Arrays.asList(3,4,6,9,2,5,7);
		var res = new ArrayList<Number>();
		double r = 4.67 % 2.77;
		System.out.println(r);
		ls.stream().reduce(LambdaTests::sum).ifPresent(System.out::println);
		res.add( ls.stream().reduce(0,LambdaTests::sum) );
		res.add( ls.stream().reduce(Integer.MIN_VALUE, LambdaTests::greater) );
		res.add( ls.stream().reduce(Integer.MIN_VALUE, LambdaTests::greater, LambdaTests::maxInt ));
		
		var str = ls.stream().reduce("-", (s , i)-> s+i, (s1,s2)-> s1+"*"+s2 );
		System.out.println(str);
		
		System.out.println("res is " + res);
	}
	
	static int sum(Integer a, Integer b){
		System.out.println("Boxed");
		return a+b;
	}
	static int sum(int a, int b){
		System.out.println("Unboxed");
		return a+b;
	}
	static int maxInt(int a, int b){
		return Integer.MAX_VALUE;
	}
	static int greater(int a, int b){
		return a>b?a:b;
	}
	

}
