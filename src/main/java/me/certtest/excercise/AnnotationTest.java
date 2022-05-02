
package me.certtest.excercise;

import me.certtest.excercise.ann.MyAnn;

/**
 *
 * @author Riccardo
 */
@MyAnn(aClass = AnnotationTest.class)
public class AnnotationTest {
    
    @SafeVarargs 
    static void testVarargsAnn( String ... va ){
	
    }
    
}
