package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dao.ProductDao;
import com.service.ProductService;

@ExtendWith(MockitoExtension.class)
class ProductServiceMockTest {

	@Mock
	ProductDao productDao;
	
	@InjectMocks
	ProductService productService;
	
	@Test
	void testGetProductInfo() {
	
		Mockito.when(productDao.getProducts()).thenReturn("Fake Product Info return");
		//Mockito.when(productDao.getProducts()).thenCallRealMethod();
			
		String result = productService.getProductInfo();		// it is not calling actual method. 
		assertEquals("Fake Product Info return", result);
		//assertEquals("Get Product Info from Product Dao layer", result);
	}

}
