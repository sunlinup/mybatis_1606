package com.hautec.edu.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * 这是mybatis的工具类 ，设计成单例模式，外界不可以进行构造对象
 * 
 * 将构造器私有化 private
 * 
 * 
 * 
 * @author admin
 *	
 */
public class MybatisUtil {
	//饿汉式
	private static MybatisUtil instance = new MybatisUtil();
	private SqlSessionFactory sessionFactory = null ;
	//将构造器私有化
	private MybatisUtil(){
		//给SqlSessionFactory做数据初始化
		try{
			InputStream in = Resources.getResourceAsStream("SqlMapperConfiger.xml");
			 sessionFactory= new SqlSessionFactoryBuilder().build(in);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static SqlSession openSession(){
		return instance.sessionFactory.openSession();
	}
}















