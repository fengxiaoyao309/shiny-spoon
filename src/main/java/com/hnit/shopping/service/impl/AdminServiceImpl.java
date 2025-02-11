package com.hnit.shopping.service.impl;

import org.springframework.stereotype.Service;

import com.hnit.shopping.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
    @Override
    public void login(String username, String password) {
        // 在这里实现登录逻辑，可以调用DAO层方法验证用户名和密码
        if ("admin".equals(username) && "password".equals(password)) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
}