package com.dd.qa.selenium.singleton;

public class Singleton_Demo {
	
	private static Singleton_Demo singleton_instance = null;
	public String str = "I am Debarati";
	
	private Singleton_Demo() {
		System.out.println("Creating an object for Singleton class");
		
	}
	
	public static Singleton_Demo getInstance() {
		 
		if (singleton_instance ==null) {
			singleton_instance = new Singleton_Demo();
			return singleton_instance ;
		}	
		else {
			System.out.println("An object for this class already exists");
			return singleton_instance;
		}	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Singleton_Demo x = Singleton_Demo.getInstance();
		Singleton_Demo y = Singleton_Demo.getInstance();
		Singleton_Demo z = Singleton_Demo.getInstance();
		System.out.println(x.str.toUpperCase());
		
		x.str = x.str.toUpperCase();
		System.out.println(y.str);
		
		System.out.println(z.str);
		
		System.out.println(z.str.toLowerCase());
		
		z.str = z.str.toLowerCase();
		System.out.println(y.str);
		
		System.out.println(x.str);
		
		
		
	}

}
