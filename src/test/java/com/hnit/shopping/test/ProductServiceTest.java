package com.hnit.shopping.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hnit.shopping.entity.Product;
import com.hnit.shopping.service.IProductService;
import com.hnit.shopping.service.impl.ProductServiceImpl;

public class ProductServiceTest {
	
	@Test
	public void testAdd() {
		String resource="spring-config.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(resource);
		IProductService service = context.getBean(ProductServiceImpl.class);
		Product product= new Product(null, 1, "辣椒炒肉", 23.4f, 39.5f, "碗",
				"500G", null, 100, "好吃", null, null);
		System.out.println( service.add(product)  );
}
	
	@Test
	public void testFinds() {
		String resource="spring-config.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(resource);
		IProductService service = context.getBean(ProductServiceImpl.class);
		
		Product product =new Product();
		
		List<Product>list =service.finds(product);
		for(Product p:list) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindPage() {
		String resource="spring-config.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(resource);
		IProductService service = context.getBean(ProductServiceImpl.class);
		
		Product product =new Product();
		
		Map<String, Object> list = service.findPage(null);
		List<Product> pps = (List<Product>)list.get("products");
		System.out.println(pps.size());
	}
}
