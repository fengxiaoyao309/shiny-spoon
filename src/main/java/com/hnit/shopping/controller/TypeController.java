package com.hnit.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnit.shopping.entity.Type;
import com.hnit.shopping.service.ITypeService;
import com.hnit.shopping.vo.ResultVO;

@RestController
@RequestMapping("/type")
public class TypeController {
	
	@Autowired
	private ITypeService service;
	
	@GetMapping("/findAll")
	public ResultVO findAll() {
		
		List<Type> list = service.findAll();
		if(null == list || list.isEmpty()) {
			return new ResultVO(600, "暂无数据");
		}else {
			return new ResultVO(200, "成功", list);
		}
	}

}
