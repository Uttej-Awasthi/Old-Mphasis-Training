package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SimpleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// assign the driver in properties with the help of System class
		//System.setProperty("webdriver.chrome.driver", "D:\\Desktop\\Mphasis Client Session\\Feb 2022 Batch\\Repository\\Phase 5\\Testing\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "D:\\Desktop\\Mphasis Client Session\\Feb 2022 Batch\\Repository\\Phase 5\\Testing\\msedgedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		System.out.println("Driver loaded successfully..");
		WebDriver driver = new EdgeDriver();
		driver.get("D:\\Desktop\\Mphasis Client Session\\Feb 2022 Batch\\Repository\\Phase 5\\Testing\\index.html");
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println(url);
		System.out.println(title);
		
		WebElement ele1 	= driver.findElement(By.tagName("h1"));
		WebElement ele2 	= driver.findElement(By.id("d1"));
		WebElement ele3 	= driver.findElement(By.name("button"));
		System.out.println(ele1.getText());
		System.out.println(ele2.getText());
		System.out.println(ele3.getTagName());
	
	}

}
