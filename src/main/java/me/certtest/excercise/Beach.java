/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

import java.io.IOException;

/**
 *
 * @author Riccardo
 */
public class Beach {
    
    class TideException extends Exception {}
    
    public void surf() throws RuntimeException {
        try{
            throw new TideException();
        } catch(TideException | IllegalStateException e){
            
        }
    }
    
}
