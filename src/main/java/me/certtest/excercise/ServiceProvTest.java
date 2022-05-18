/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

import java.util.ServiceLoader;

/**
 *
 * @author Riccardo
 */
public class ServiceProvTest {
	
	public static interface Service{
		void printSomething();		
	}
	
	public static class ServiceImpl implements Service{

		@Override
		public void printSomething() {
			System.out.println("Something");
		}
		
	}
	
	public static void main(String[] args) {
		ServiceLoader<Service> serviceLocator = ServiceLoader.load(Service.class);
	}
	
}
