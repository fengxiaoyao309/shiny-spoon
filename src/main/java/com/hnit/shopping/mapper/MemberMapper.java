package com.hnit.shopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hnit.shopping.entity.Member;

public interface MemberMapper {

	
	List<Member> findAll(); 
    
    Member findByMno(Integer mno);
    
    @Insert("insert into tb_member (nickName, sex, password, tel, mpic, state, temp01)"
    		+ "valuse(#{nickName}, #{sex}, #{password}, #{tel}, #{mpic}, 1, #{temp01})")
    
    int add(Member member);
    
    @Select("select * from tb_member where (nickName =#{nickName} or tel=#{nickName})"
    		+ " and password=#{password}")
    
    Member login(Member member);

	int insertMember(Member member);
	
	// 使用正确的列名
    @Select("SELECT * FROM tb_member WHERE nickName = #{nickName}")
    Member findByNickName(@Param("nickName") String nickName);
	
	


}
