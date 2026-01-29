package base;

//This class is placed in base package 
//It contains : Driver setup ,Test intialization,common framework configurations 
//Driver factory is responsible for browser creation 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


//This centralized place to create WebDriver instances 
//Follows factory Design Pattern
//Makes browser management clean and stable 
public class DriverFactory {

	
	//public ---accessible throughout the framework 
	//static ---called without creating object 
	//WebDriver createChrome() ---This allows easy switching of browsers 
	public static WebDriver createChrome() {
		
		//Download correct chromedriver 
		//matches it with installed versions 
		//sets system properties internally 
		WebDriverManager.chromedriver().setup();
		
		//Launches chrome browser 
		//start a new automation session 
		//returns webdriver object 
		//Caller receives ready to use driver 
		return new ChromeDriver();

	}

}
