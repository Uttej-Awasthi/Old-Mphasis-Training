package test;

import org.testng.annotations.Test;

public class BikeTest {
	 @Test(groups = {"loan"},priority = 1)
	  public void bikeLoan() {
		  System.out.println("Bike loan testing");
	  }
	  @Test(groups = {"price"})
	  public void bikeColor() {
		  System.out.println("Bike color testing");
	  }
	  @Test
	  public void bikePrice() {
		  System.out.println("Bike price testing");
	  }
}
