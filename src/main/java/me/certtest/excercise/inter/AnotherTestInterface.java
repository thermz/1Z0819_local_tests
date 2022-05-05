package me.certtest.excercise.inter;

/**
 *
 * @author Riccardo
 */
public interface AnotherTestInterface {

    default String check(CharSequence seq){
	return "YELLOW";
    }
    
}
