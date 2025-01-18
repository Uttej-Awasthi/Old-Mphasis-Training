package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import com.bean.Product;
import com.service.ProductService;

public class ProductServiceTest {

  @Test
  public void findProductTest() {
    //throw new RuntimeException("Test not implemented");
	  ProductService ps = new ProductService();
	  Product pp = ps.findProduct(1);
	  assertNotNull(pp);
	  assertEquals(pp.getPid(), 1);
	  assertEquals(pp.getPname(), "Tv");
	  assertEquals(pp.getPrice(), 12000);
  }

  @Test
  public void storeProductTest() {
   // throw new RuntimeException("Test not implemented");
	  ProductService ps = new ProductService();
	  Product pp = new Product();
	  pp.setPid(4);
	  pp.setPname("Pen Drive");
	  pp.setPrice(1200);
	  String result = ps.storeProduct(pp);
	  assertEquals(result, "Prodcut added successfully");
  }
}
