/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package me.certtest.excercise.inter;

/**
 *
 * @author Riccardo
 */
public interface TestInterface {
    
    int NUMBER = 9;
    
    default Object check(CharSequence seq){
	return "GREEN";
    }
    
}
