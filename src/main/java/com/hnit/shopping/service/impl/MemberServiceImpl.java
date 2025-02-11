package com.hnit.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnit.shopping.entity.Member;
import com.hnit.shopping.mapper.MemberMapper;
import com.hnit.shopping.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public Member login(Member member) {
		return mapper.login(member);
	}
	
	@Override
	public boolean register(Member member) {
	        // 调用DAO层方法将用户信息存储到数据库中
	        int rowsInserted = mapper.insertMember(member);
	        return rowsInserted > 0;
	    }
	
	@Override
    public Member getMemberByNickName(String nickName) {
        // 添加日志以调试
        System.out.println("查询用户昵称: " + nickName);
        return memberMapper.findByNickName(nickName);
    }
	
}
