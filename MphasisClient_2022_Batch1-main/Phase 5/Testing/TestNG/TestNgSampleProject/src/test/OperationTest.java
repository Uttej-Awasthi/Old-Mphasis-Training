package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.service.Operation;

public class OperationTest {
  @Test
  public void testAdd() {
	 Operation op = new Operation();
	 int result = op.add(10, 20);
	 assertEquals(result, 70);
  }
  @Test
  public void testSub() {
	  Operation op = new Operation();
	  int result = op.sub(10, 1);
	  assertEquals(result, 5);
  }
  @Test
  public void testMult() {
	  Operation op = new Operation();
	  int result = op.mul(10, 5);
	  assertEquals(result, 50);
  }
  @Test
  public void testDiv() {
	  Operation op = new Operation();
	  int result = op.div(10, 5);
	  assertEquals(result, 2);
  }
}
