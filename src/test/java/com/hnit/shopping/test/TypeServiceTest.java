package com.hnit.shopping.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hnit.shopping.entity.Type;
import com.hnit.shopping.service.ITypeService;
import com.hnit.shopping.service.impl.TypeServiceImpl;

public class TypeServiceTest {
	
	@Test
	public void testFindAll() {
		String resource = "spring-config.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(resource);
		ITypeService service = context.getBean(TypeServiceImpl.class);
		List<Type> list = service.findAll();
		for(Type t:list) {
			System.out.println(t);
		}
	}

}
