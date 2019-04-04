package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.TestUtil.TestUtil;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() {
		
		 prop = new Properties();
		
		 try {
			FileInputStream fle = new FileInputStream("C:\\Users\\world\\eclipse-workspace\\dell.qa\\src\\main\\java\\com\\Config\\Config.properties");	
			 prop.load(fle);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initil() {
		
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("FF")) {
					System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitlyWait,TimeUnit.SECONDS);
		
		
		driver.get(prop.getProperty("url"));
		
	
	}
	
	
	
}
	
	
	
	
	
	
	

