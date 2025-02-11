package com.hnit.shopping.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnit.shopping.entity.Product;
import com.hnit.shopping.mapper.ProductMapper;
import com.hnit.shopping.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductMapper mapper;
	
	@Override
	public int add(Product product) {
		return mapper.add(product);
	}

	@Override
	public List<Product> finds(Product product) {
		return mapper.finds(product);
	}
	
	//page页码 rows每页行数
	@Override
	public Map<String, Object> findPage(Map<String, Object> map) {
	    Map<String, Object> obj = new HashMap<>();
	    
	    if (map != null) {
	        // 分页参数处理
	        if (map.containsKey("page") && map.containsKey("rows")) {
	            int page = Integer.parseInt(map.get("page").toString());
	            int rows = Integer.parseInt(map.get("rows").toString());
	            int start = (page - 1) * rows;
	            map.put("start", start);
	            map.put("rows", rows); // 确保 'rows' 也被传递
	        }

	        // 处理类型过滤
	        if (map.containsKey("type")) {
	            // 根据 'type' 进行过滤
	            // 确保 'type' 被传递到 Mapper 层
	            Object typeObj = map.get("type");
	            if (typeObj != null && !typeObj.toString().isEmpty()) {
	                map.put("tno", Integer.parseInt(typeObj.toString())); // 修改为 'tno'
	            }
	        }
	    }
	    
	    // 打印参数
	    System.out.println("Service 层接收到的参数: " + map);

	    // 获取总记录数（根据是否有类型过滤）
	    int total = mapper.total(map);
	    System.out.println("查询到的总数: " + total);
	    
	    // 获取分页后的产品列表
	    List<Product> list = mapper.findPage(map);
	    System.out.println("查询到的产品列表: " + list);

	    obj.put("count", total); // 正确设置总记录数
	    obj.put("products", list);
	    return obj;
	}
	
	
	@Override
	public Product findById(Integer id) {
	    return mapper.findById(id);
	}




}
