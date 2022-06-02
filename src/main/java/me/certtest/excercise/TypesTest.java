/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.Comparator;
import java.util.List;

class OutsideTT {

	String invisible = "invisible";

	OutsideTT() {
		System.out.println("ROOT constructor");
	}

	{
		System.out.println("initialized block in superclass");
	}

	OutsideTT(int c) {
		System.out.println("Constructor root with int");
	}

	void doSomethingRoot(Number n) {

	}

	void doIO() throws IOException {

	}

	CharSequence getStr() {
		return "";
	}

	static void doSomethingRootStatic() {

	}
}

/**
 *
 * @author Riccardo
 */
public class TypesTest {

	class Inner extends OutsideTT {

		public Inner() throws Exception, IOException {
			super(0);
		}

		@Override
		String getStr() {
			return "a";
		}

		@Override
		void doIO() {
			var b = true;
			if (b = false) {

			}

		}

	}

	static class Nested extends OutsideTT {

		public Nested() {
			super(2);
		}

		{
			System.out.println("initialized block in subclass");
		}

		public Nested(int c) {
			super(2);
			System.out.println("Nesting constructor with int!");
		}

		static void doSomething() {
			OutsideTT o = new Nested();
			var s = o.invisible;
			var k = 3 & 7;
			var b = true | false;

		}

	}

	enum TEST_ENUM {
		A("AA"), B("BB"), C("CC");

		TEST_ENUM() {
			this("");
		}

		enum InnerEnum {
			ASD, LOL
		};

		public String val;
		public int count;

		public static final String valEnumStatic = "val";

		class InnerEnumClass {

			String val;

			public InnerEnumClass(String val) {
				if (TEST_ENUM.A.val.equalsIgnoreCase(val)) {
					this.val = val;
				}
			}

		}

		TEST_ENUM(String value) {
			this.val = value;
		}

		@Override
		public String toString() {
			return val;
		}

		public static String checkV() {
			return valEnumStatic.toUpperCase();
		}
	}

	enum ANOTHER {
		A(1), B(2);

		ANOTHER(int val) {
		}
	}

	static int n1, n2 = 0;

	private String invisibleOutside = "I";

	double dou = .76;

	static void testEnum() {
		TEST_ENUM.A.count ++;
		TEST_ENUM.B.count ++;

		System.out.println(TEST_ENUM.C.count);
		System.out.println(TEST_ENUM.B.count);

		var ie = TEST_ENUM.A.new InnerEnumClass("A");

		class InsideStatic {

			{
				var a = n2;
				main(new String[]{""});
				TypesTest tt = new TypesTest();
				var s = tt.invisibleOutside;
			}
		}

		var outsideTTInstance = new OutsideTT();
		String see = outsideTTInstance.invisible;
		class Local extends OutsideTT {

			void doSomething() {

			}

			Local() {

			}

		}

	}

	public static void main(String[] args) {
		int a, b, c;
		a = b = c = n2 = 1;

		b ++;

		OutsideTT o = new Nested(5);

		testStrings();

	}

	static void testLists() {
		List<Object> l = List.of(1, 2, "3");
		List<Object> l1 = asList(1, 2, "3", 4);
		List<Number> l2 = List.of(1, 2.2, 3.3, 4.4);
		var l3 = asList(1, 2.2, 3.3, 4.4);
		List<?> objects = new ArrayList<String>();

		System.out.println(l3.getClass());

		var stringList = List.of("aa", "bb", "ccc");
	}

	static void testStrings() {
		StringBuffer sb = new StringBuffer().append("12345");
		sb.reverse();

		System.out.println(sb.toString());

		String s = "123aaa321";
		System.out.println(s.substring(0, s.length() - 1));

		sb = new StringBuffer("astring");
		sb.substring(2);
		sb.replace(0, 2, "OK");
		System.out.println(sb);

		StringBuilder sbd = new StringBuilder("astring");
		sbd.substring(2);
		sbd.replace(0, 2, "OK");
		System.out.println(sbd);

	}

	static void testTypeDeclarations() {
		var decimalVar = 4.13;
		float decimalFloat = 3.14f;
		double decimalDouble = 3.14;
		Comparator<String> c = (var a1, var a2) -> 0;
	}

	static void testSwitch() {
		String s = "asd";

	}

	enum ASD {
		ASD, OK
	};

	private void switchMet(String s) {
		final String con = "toConcat";
		switch (s) {
			case "a":
				System.out.println("a");
			default:
			case "b":
				System.out.println("b");
			case "asd"+con:
				System.out.println("ok");
		}
	}

	private void switchMet(char c) {
		switch (c) {
			case 'a':
				System.out.println("a");
			default:
			case 'b':
				System.out.println("b");
			case 'k':
				System.out.println("ok");
			case 123:
				System.out.println("int works too!");
		}
	}

	private void switchMet(short c) {
		switch (c) {
			case 'a':
				System.out.println("a");
			default:
			case 'b':
				System.out.println("b");
			case 'ù':
				System.out.println("ok");
			case 1293:
				System.out.println("int works too!");
		}
	}

	private void switchEnth(char n) {
		var ca = new char[]{'a', 'b', 'c', 'd'};
		var i = 0;
		final var toBWor = 122;
		for (var c : ca) {
			switch (c) {
				case 'a':
					i ++;
				case 'b':
					 ++ i;
				case 'j'|toBWor:
					i ++;
			}
		}
		System.out.println("i = " + i);
	}

}
