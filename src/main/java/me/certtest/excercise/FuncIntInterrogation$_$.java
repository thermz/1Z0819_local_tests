package me.certtest.excercise;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static me.certtest.excercise.Utils.uncheck;

final class Attempt{
	String ifName, correctAnswer, givenAnswer;
	private final boolean outcome;

	public Attempt(String ifName, String correctAnswer, String givenAnswer) {
		this.ifName = ifName;
		this.correctAnswer = correctAnswer;
		this.givenAnswer = givenAnswer;
		this.outcome = correctAnswer.equals(givenAnswer);
	}

	public boolean getOutcome() {
		return outcome;
	}

	public String getReadableOutcome(){
		return FuncIntInterrogation$_$.wrongRight(outcome);
	}

	@Override
	public String toString() {
		return MessageFormat.format("[ FI {0}, real answer {1}, given answer {2}, outcome {3} ]" ,ifName, correctAnswer, givenAnswer, getReadableOutcome() );
	}
}

public class FuncIntInterrogation$_$ {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	static final List<String> FUNCTIONAL_IF_NAMES = List.of("BiConsumer",
			"BiFunction",
			"BinaryOperator",
			"BiPredicate",
			"BooleanSupplier",
			"Consumer",
			"DoubleBinaryOperator",
			"DoubleConsumer",
			"DoubleFunction",
			"DoublePredicate",
			"DoubleSupplier",
			"DoubleToIntFunction",
			"DoubleToLongFunction",
			"DoubleUnaryOperator",
			"Function",
			"IntBinaryOperator",
			"IntConsumer",
			"IntFunction",
			"IntPredicate",
			"IntSupplier",
			"IntToDoubleFunction",
			"IntToLongFunction",
			"IntUnaryOperator",
			"LongBinaryOperator",
			"LongConsumer",
			"LongFunction",
			"LongPredicate",
			"LongSupplier",
			"LongToDoubleFunction",
			"LongToIntFunction",
			"LongUnaryOperator",
			"ObjDoubleConsumer",
			"ObjIntConsumer",
			"ObjLongConsumer",
			"Predicate",
			"Supplier",
			"ToDoubleBiFunction",
			"ToDoubleFunction",
			"ToIntBiFunction",
			"ToIntFunction",
			"ToLongBiFunction",
			"ToLongFunction",
			"UnaryOperator");

	private final static String FI_PACKAGE = "java.util.function";

	public static void main(String[] args) {
		List<Class<?>> functionalInterfaces =  getClasses();

		var attempts = new ArrayList<Attempt>();

		List<Method> allIfMethods = functionalInterfaces.stream().map(Class::getMethods)
				.map( methods -> Stream.of(methods)
						.filter(m -> Modifier.isAbstract(m.getModifiers()))
						.findFirst().orElseThrow(RuntimeException::new) )
				.collect(Collectors.toList());

		boolean continueInterrogation = true;

		do {
			Collections.shuffle(allIfMethods);
			Method randomFi = allIfMethods.stream().findAny().get();

			String className = randomFi.getDeclaringClass().getSimpleName();

			System.out.println("\nEnclosing Functional Interface is "+ANSI_CYAN + className + ANSI_RESET);
			System.out.println("Which is the method name? (type EXIT to close program)");
			Scanner scanner = new Scanner(System.in);

			String response = getNextInput(scanner);

			if( EXIT.equals( response ) ){
				System.out.println("Closing program");
				continueInterrogation = false;
			} else {
				Attempt attempt = new Attempt(className, randomFi.getName(), response);
				attempts.add(attempt);

				System.out.printf( "Correct response is %s, you said %s and got it %s\n",
						randomFi.getName(),
						response,
						attempt.getReadableOutcome()
				);

			}
		} while (continueInterrogation);

		System.out.println("Your responses were");
		attempts.forEach(System.out::println);

		long rightResponsesCounter = attempts.stream().filter(Attempt::getOutcome).count();
		long totalResponsesCounter = attempts.size();

		System.out.printf("\nYou got %s%% of correct responses", ANSI_PURPLE+getRate(rightResponsesCounter, totalResponsesCounter)+ANSI_RESET );

	}

	private static BigDecimal getRate(Long amount, Long totalAmount){
		return new BigDecimal(amount)
				.multiply(BigDecimal.valueOf(100L))
				.divide(BigDecimal.valueOf(totalAmount), 2, RoundingMode.HALF_DOWN );
	}

	private static String getNextInput(Scanner s){
		String response = "";
		try {
			response = s.next();
		} catch(Exception e){
			System.err.printf("Hey, you could close the program nicely by typing EXIT! No need to raise a %s :-)", e.getClass().getSimpleName());
			System.exit(1);
		}
		return response;
	}

	final static String EXIT = "EXIT";

	static String wrongRight(boolean condition){
		return (
				(condition)?ANSI_GREEN+"right":ANSI_RED+"wrong"
		) + ANSI_RESET;
	}

	static List<Class<?>> getClasses(){
		return FUNCTIONAL_IF_NAMES.stream()
				.map(FuncIntInterrogation$_$::loadClass)
				.collect(Collectors.toList());
	}

	private static Class<?> loadClass(String className){
		return uncheck(() -> Class.forName(FI_PACKAGE+"."+className));
	}

}
