package com.hnit.shopping.service;

import com.hnit.shopping.entity.Member;

public interface IMemberService {
	
	Member login(Member member);

	boolean register(Member member);

	Member getMemberByNickName(String nickName);
	
}
