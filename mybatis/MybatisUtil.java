package com.huatec.edu.mobileshop.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static MybatisUtil instance = new MybatisUtil();
	private SqlSessionFactory factory;
	
	private MybatisUtil(){
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession(){
		return instance.factory.openSession();
	}
}
