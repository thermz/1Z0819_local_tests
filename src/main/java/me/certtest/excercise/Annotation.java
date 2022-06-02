
package me.certtest.excercise;

import java.lang.annotation.Repeatable;
import me.certtest.excercise.ann.MyAnn;

/**
 *
 * @author Riccardo
 */
@MyAnn(aClass = Annotation.class)
public class Annotation {
    
    @SafeVarargs 
    static void testVarargsAnn( String ... va ){
	
    }
    
}



