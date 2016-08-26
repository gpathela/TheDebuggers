/** Import some Java libraries and specify the package in which the classes are organized */
package datamanagement;
import java.util.*;
import java.io.*;

/**
*@author Jean Claude Jino Rousseau
*@course Master of Information Technology
*@subject Professional Programming Practice
*@lecturer Dr Recep Ulusoy
*@due date 26.08.2016
*@version 1.5
*
*The AppProperties class is a program that uses private variables to create instances
*with a no-arg constructor. It has two methods, namely the getInstance, and getProperties
*methods which can be used to return an instance of the class or its properties.
*/

/** Start of the class AppProperties */
public class AppProperties{
	/** Declare and initialize the variable for the class
		with private visibility modifiers */
	private static AppProperties self = null; // Declare and initialize the variable self to null 
	private Properties properties;

	/** The no-args constructor, which contains  a try and catch
		method, is used to create an instance of an AppProperties 
		which loads the file "Properties.prop" */
	private AppProperties(){
		properties = new Properties();
		try{
			properties.load(new FileInputStream("Properties.prop"));
			} 
		catch(IOException e){
			throw new RuntimeException("Could not read property file");
			}
	} // End of the no-arg constructor
	
	/** An instance of the AppProperties class can use the getInstance method to return itself */
	public static AppProperties getInstance(){
		if(self == null ){
			self = new AppProperties();
		} 
		return self;
	} // End of the getInstance method 

	/** The getProperties method returns the properties of an instance of AppProperties*/
	public Properties getProperties(){
		return properties;
	} // End of the getProperties method 
} // End of the class AppProperties