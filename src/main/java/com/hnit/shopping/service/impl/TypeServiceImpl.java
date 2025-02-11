package com.hnit.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnit.shopping.entity.Type;
import com.hnit.shopping.mapper.TypeMapper;
import com.hnit.shopping.service.ITypeService;

@Service
public class TypeServiceImpl implements ITypeService {
	
	@Autowired
	private TypeMapper mapper;
	
	@Override
	public List<Type> findAll() {
		return mapper.findAll();
	}
	
}
