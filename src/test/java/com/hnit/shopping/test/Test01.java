package com.hnit.shopping.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hnit.shopping.entity.Admin;
import com.hnit.shopping.entity.Member;
import com.hnit.shopping.mapper.AdminMapper;
import com.hnit.shopping.mapper.MemberMapper;

public class Test01 {

	/*
	 * 每个映射文件对应这一个映射接口
	 * 
	 * 
	 * 
	 */

	@Test
	public void test01() throws IOException {
		// 加载全局配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory.getClass().getName());
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println(session.getClass().getName());
		// 命名空间名称.id
		Object obj = session.selectOne("com.hnit.shopping.mapper.MemberMapper.findByMno", 1);
		System.out.println(obj);
		session.close();
	}

	@Test
	public void test02() throws IOException {

		// 加载全局配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		System.out.println(mapper.getClass().getName());
		List<Member> list =mapper.findAll();
		for(Member m:list) {
			System.out.println(m);
		}
		
		session.close();
		
	}
	
	@Test
	public void test03() throws IOException {

		// 加载全局配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		AdminMapper mapper = session.getMapper(AdminMapper.class);
		System.out.println(mapper.getClass().getName());
		List<Admin> list =mapper.findAll();
		for(Admin m:list) {
			System.out.println(m);
		}
		
		session.close();
		
	}
}
