/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

import java.lang.annotation.Repeatable;

@interface Authors {
    Author[] value();
    String team() default "enthuware";
}

@Repeatable(Authors.class)
@interface Author {
    int id() default 0;
    String[] value();
	float[] marks() default {1}; 
}


public class AnnTest {
	
	@Authors(value = {@Author("qqq"), @Author("eeee")} )
//	@Authors(value=@Author("qqq"))	
	@Author("AAA")
//	@Author("BBB")
	void method(){
		
	}
	
	@Authors(value=@Author("bob"), team="java") 
	@Author(value = "alice", marks = {45f,8.9f}) 
	void someMethod(int index){ 
	}
}
