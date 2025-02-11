package com.hnit.shopping.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hnit.shopping.entity.Type;
import com.hnit.shopping.mapper.TypeMapper;

public class TypeMapperTest {

    @Test
    public void testAdd() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 默认事务手动提交 设置自动提交 true
        SqlSession session = factory.openSession(true);
        TypeMapper mapper = session.getMapper(TypeMapper.class);

        // 插入粤菜
        Type type1 = new Type();
        type1.setTname("粤菜");
        int value1 = mapper.add(type1);
        System.out.println("Inserted 粤菜: " + value1);

        // 插入湘菜
        Type type2 = new Type();
        type2.setTname("湘菜");
        int value2 = mapper.add(type2);
        System.out.println("Inserted 湘菜: " + value2);

        session.close();
    }

    @Test
    public void testFindAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        TypeMapper mapper = session.getMapper(TypeMapper.class);
        List<Type> list = mapper.findAll();
        for (Type t : list) {
            System.out.println(t);
        }
        session.close();
    }
}

