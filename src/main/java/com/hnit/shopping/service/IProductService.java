package com.hnit.shopping.service;

import java.util.List;
import java.util.Map;

import com.hnit.shopping.entity.Product;

public interface IProductService {
	
	int add(Product product);
	
	List<Product> finds(Product product);
	
	Map<String, Object> findPage(Map<String, Object> map);

	Product findById(Integer id);


}
