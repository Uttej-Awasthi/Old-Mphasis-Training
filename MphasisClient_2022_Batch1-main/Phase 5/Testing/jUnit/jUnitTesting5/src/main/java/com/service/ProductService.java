package com.service;

import com.dao.ProductDao;

public class ProductService {

	ProductDao pd = new ProductDao();
	
	public String getProductInfo() {
		// coding.....
		// This method calling dao method. buiness logic is ready but dao layer code is not ready. 
		
		return pd.getProducts();
		//return null;
	}
}
