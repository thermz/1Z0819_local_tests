package me.certtest.excercise;

/**
 *
 * @author Riccardo
 */
public class Utils {

	public static interface Unchecked<T> {

		T uncheck() throws Exception;
	}

	public static interface UncheckedVoid {

		void uncheck() throws Exception;
	}

	private Utils() {
	}

	public static <T> T uncheck(Unchecked<T> u) {
		try {
			return u.uncheck();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void uncheck(UncheckedVoid u) {
		try {
			u.uncheck();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
