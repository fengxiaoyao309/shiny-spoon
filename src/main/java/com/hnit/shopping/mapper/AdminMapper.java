package com.hnit.shopping.mapper;

import java.util.List;

import com.hnit.shopping.entity.Admin;

public interface AdminMapper {

	List<Admin> findAll();
    
    int add(Admin admin);
    
    Admin login(Admin admin);
}
