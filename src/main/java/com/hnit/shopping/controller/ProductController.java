package com.hnit.shopping.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hnit.shopping.entity.Product;
import com.hnit.shopping.service.IProductService;
import com.hnit.shopping.vo.ResultVO;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	private IProductService service;
	
	public static final String PIC_PATH="shopping_pics";
	
	@GetMapping("/findPage")
	public ResultVO findPage(@RequestParam Map<String, Object> map) {
		//查看数据
		Map<String, Object> obj = service.findPage(map);
		if(null==obj || obj.isEmpty()) {
			return new ResultVO(600, "暂无数据");
		}else {
			return new ResultVO(200, "成功", obj);
		}
	}
	
	@PostMapping("/add")
	public ResultVO add(HttpServletRequest request, @RequestPart("pic") MultipartFile pic, Product product) {
	    
	    if (pic.getSize() > 0) {
	        String originalName = pic.getOriginalFilename();
	        
	        // 生成唯一的文件名，避免重复
	        String picStr =  originalName;
	        
	        // 构建相对于 webapp 的路径
	        String relativePath = "images/" + picStr;
	        
	        // 获取绝对路径
	        String savePath = request.getServletContext().getRealPath("/") + relativePath;
	        System.out.println("Saving file to: " + savePath);
	        
	        try {
	            // 保存文件
	            pic.transferTo(new File(savePath));
	        } catch (Exception e) {
	            return new ResultVO(501, "异常信息：文件上传失败。" + e.getMessage());
	        }
	        
	        // 将相对路径存储到数据库
	        product.setPics(relativePath);
	    }
	    
	    product.setBalance(100);
	    System.out.println(product);
	    int result = service.add(product);
	    if (result > 0) {
	        return new ResultVO(200, "添加成功");
	    }
	    return new ResultVO(500, "添加失败");
	}

	
	@GetMapping("/products")
	public ResponseEntity<Map<String, Object>> getProducts(
	        @RequestParam int page, 
	        @RequestParam int rows,
	        @RequestParam(required = false) Integer type) { // 添加类型参数
	    Map<String, Object> params = new HashMap<>();
	    params.put("page", page);
	    params.put("rows", rows);
	    if (type != null) {
	        params.put("tno", type); // 将类型参数添加到参数映射中
	    }
	    Map<String, Object> result = service.findPage(params);
	    return ResponseEntity.ok(result);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
	    Product product = service.findById(id);
	    if (product != null) {
	        return ResponseEntity.ok(product);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}


}

