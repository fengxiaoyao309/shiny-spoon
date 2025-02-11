package com.hnit.shopping.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.hnit.shopping.entity.Product;

public interface ProductMapper {
	/**
	 * 多条件查询 单表
	 * @param product
	 * @return
	 */
	List<Product> finds(Product product);

	int add(Product product);
	/**
	 * 分页+多条件查看
	 * @param map
	 * @return
	 */
	List<Product> findPage(Map<String, Object> map);
	/**
	 * 统计记录数
	 * @param map
	 * @return
	 */
	int total(Map<String, Object> map);

	@Select("SELECT * FROM tb_product WHERE pno = #{id}")
	Product findById(Integer id);


	
	


}
