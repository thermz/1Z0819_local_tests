
package me.certtest.excercise.ann;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

/**
 *
 * @author Riccardo
 */

enum COUNTRIES { IT, FR, EN, DE }

@Retention(RetentionPolicy.RUNTIME)
@Target({CONSTRUCTOR, ANNOTATION_TYPE, TYPE_PARAMETER, TYPE_USE})
@MyAnn(aSettableString = "asdasd", aClass = MyAnn.class) @Documented @Inherited
public @interface MyAnn {
    static String aString = "kkkkkkk";
    int anInt = 1;
    String aSettableString() default aString;
    String anotherString() default "";
    Class<?> aClass();
    COUNTRIES c() default COUNTRIES.IT;
    AnotherAnn ann() default @AnotherAnn;
}


@interface AnotherAnn {
    int value = 100;
    int value() default value;
}