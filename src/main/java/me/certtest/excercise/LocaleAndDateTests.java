/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

import java.nio.file.AccessDeniedException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
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

	static void testLocale() {
		Locale.setDefault(Locale.Category.FORMAT, Locale.UK);
		System.out.println(Stream.of(Locale.getISOCountries()).count());
		String s = NumberFormat.getCurrencyInstance().format(234512.55);
		System.out.println(s);

	}

	public static void main(String[] args) {
		//testDates();
//	testDecimalFormat(2.0, 4.33, 0.664, 1000, 10000000, 4.5);
		testLocale();

		testResourceBundle();

		testFormat();

	}

	static void testFormat() {
		Locale.setDefault(Locale.Category.FORMAT, Locale.CHINA);
		String ukFormat = NumberFormat.getCurrencyInstance(new Locale("it", "IT")).format(1.1);
		System.out.println(ukFormat);

		System.out.println("Now let's print all the currencies of all the ISO countries!");

		Stream.of(Locale.getISOCountries())
			.map(country -> new Locale(country.toLowerCase(), country.toUpperCase()))
			.forEach(l
				-> System.out.println(l.getCountry() + " " + NumberFormat.getCurrencyInstance(l).format(1.1))
			);

	}

	static void testResourceBundle() {
		var resources = bundleOf(Locale.ITALY);
		printLabel(resources);
		resources = bundleOf(Locale.US);
		printRBAvailableKeys(resources);
		resources = bundleOf(Locale.UK);
		printRBAvailableKeys(resources);

		resources = bundleOf(new Locale.Builder()
			.setLanguage("fr")
			.setRegion("FR")
			.build()
		);
		printRBAvailableKeys(resources);

		resources = bundleOf(new Locale("en", "UK"));
		printRBAvailableKeys(resources);

		resources = bundleOf(new Locale("es"));
		printRBAvailableKeys(resources);

		resources = bundleOf(new Locale("it", "IT"));
		printRBAvailableKeys(resources);

		resources = bundleOf(new Locale("IT"));
		printRBAvailableKeys(resources);

		resources = bundleOf(new Locale("it", "CH"));
		printRBAvailableKeys(resources);

	}

	private static ResourceBundle bundleOf(Locale loc) {
		return ResourceBundle.getBundle("props", loc);
	}

	private static void printLabel(ResourceBundle bundle) {
		printLabel(bundle, "label");
	}

	private static void printLabel(ResourceBundle bundle, String key) {
		printBundleLocale(bundle);
		System.out.println(key + " is " + bundle.getString(key));
	}

	private static void printBundleLocale(ResourceBundle rb) {
		System.out.print("Language is " + rb.getLocale().getLanguage() + " - ");
		System.out.println("Country is " + rb.getLocale().getCountry());
	}

	private static void printRBAvailableKeys(ResourceBundle rb) {
		printBundleLocale(rb);
		Enumeration<String> keysEnum = rb.getKeys();
		var keys = new ArrayList<String>();
		while (keysEnum.hasMoreElements()) {
			keys.add(keysEnum.nextElement());
		}
		Map<String, String> res = keys.stream().collect(Collectors.toMap(i -> i, rb::getString));

		System.out.println("RB includes: " + res);
		System.out.println("");
	}

}
