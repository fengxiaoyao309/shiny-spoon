package com.hnit.shopping.mapper;

import java.util.List;

import com.hnit.shopping.entity.Type;

public interface TypeMapper {
	
	//update insert delete
	//返回值类型：int void boolean
	/**
	 * 添加类型
	 * @param type
	 * @return
	 */
	int add(Type type);
	
	/**
	 * 查看所有
	 * @return
	 */
	List<Type> findAll();
}
