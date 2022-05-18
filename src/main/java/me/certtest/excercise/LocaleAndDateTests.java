/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 *
 * @author Riccardo
 */
public class LocaleAndDateTests {

	public static void testDates() {
		var d = LocalDate.of(2022, 3, 1);

		var dt = LocalDateTime.of(2022, 3, 1, 5, 55);

		var f = DateTimeFormatter.ofPattern("ddMMyyyyhh");

		var dtout = d.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		System.out.println(dtout);

		var output = f.format(dt);
		System.out.println(output);

		Locale.setDefault(new Locale("cn", "CN"));
		var price = NumberFormat.getCurrencyInstance(Locale.US).format(1.4);
		System.out.println(price);
	}

	static void testDecimalFormat(double... varargs) {
		var f1 = "####,###.000";
		var f2 = "#,000.#";

		DecimalFormat format = new DecimalFormat();
		format.applyPattern(f1);

		Double number = 1999d;

		DoubleStream.of(varargs).mapToObj(d -> {
			System.out.println("Number is " + d);
			return format.format(d);
		}).forEach(System.out::println);

		format.applyPattern(f2);
		System.out.println("------------------------------------");

		DoubleStream.of(varargs).mapToObj(d -> {
			System.out.println("Number is " + d);
			return format.format(d);
		}).forEach(System.out::println);

	}

	public static void main(String[] args) {
		testDates();
//	testDecimalFormat(2.0, 4.33, 0.664, 1000, 10000000, 4.5);
		testLocale();
	}

	static void testLocale() {
		Locale.setDefault(Locale.Category.FORMAT, Locale.UK);
		System.out.println(Stream.of(Locale.getISOCountries()).count());
		String s = NumberFormat.getCurrencyInstance().format(234512.55);
		System.out.println(s);

	}

}
