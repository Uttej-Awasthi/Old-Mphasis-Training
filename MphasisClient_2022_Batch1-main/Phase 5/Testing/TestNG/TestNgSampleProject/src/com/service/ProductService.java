package com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import com.bean.Product;

public class ProductService {

	List<Product> listOfProdut;
	
	public ProductService() {
		
	//listOfProdut= Arrays.asList(new Product(1, "Tv", 12000),new Product(2, "Computer", 14000),new Product(3, "Laptop", 16000));
	listOfProdut = new ArrayList<>();
	listOfProdut.add(new Product(1, "Tv", 12000));
	listOfProdut.add(new Product(2, "Computer", 14000));
	listOfProdut.add(new Product(3, "Laptop", 16000));
	}
	
	
	public String storeProduct(Product pp) {
//			int flag = 0;
//			ListIterator<Product> li = listOfProdut.listIterator();
//			while(li.hasNext()) {
//				Product p = li.next();
//				if(p.getPid()==pp.getPid()) {
//					flag=1;
//					break;
//				}
//			}
//			if(flag==0) {
//				storeProduct(pp);
//				return "Record stored successfully";
//			}else {
//				return "Record id must be unique";
//			}
		
		boolean bb = listOfProdut.stream().filter(p->p.getPid()==pp.getPid()).findAny().isPresent();
		if(bb) {
			return "Product id must be unique";
		}else {
			listOfProdut.add(pp);
			return "Prodcut added successfully";
		}
	}
	
	public Product findProduct(int pid) {
				Product product = listOfProdut.stream().filter(p->p.getPid()==pid).findAny().get();
				return product;
	}
}
