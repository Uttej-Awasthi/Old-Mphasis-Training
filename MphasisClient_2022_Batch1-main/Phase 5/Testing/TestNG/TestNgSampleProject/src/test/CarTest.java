package test;

import org.testng.annotations.Test;

public class CarTest {
  @Test(groups = {"loan"},priority = 1)
  public void carLoan() {
	  System.out.println("Car loan testing");
  }
  @Test(groups = {"price"})
  public void carColor() {
	  System.out.println("Car color testing");
  }
  @Test
  public void carPrice() {
	  System.out.println("Car price testing");
  }
}
