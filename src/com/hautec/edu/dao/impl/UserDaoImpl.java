package com.hautec.edu.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hautec.edu.dao.UserDao;
import com.hautec.edu.entity.User;
import com.hautec.edu.util.MybatisUtil;

public class UserDaoImpl implements UserDao {
	@Override
	public void svae(User obj) {
//		SqlSession  session =  null;
//		try{
//			InputStream in = Resources.getResourceAsStream("SqlMapperConfiger.xml");
//			SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(in);
////			sessionFactory.openSession();
//			session = sessionFactory.openSession();
//			session.insert("com.hautec.edu.entity.User.save",obj);
//			session.commit();
//			
//		}catch(IOException e){
//			e.printStackTrace();
//			
//		}finally{
//			if(session != null)
//				session.close();
//		}
		SqlSession session = MybatisUtil.openSession();
		session.insert("com.hautec.edu.entity.User.insert",obj);
		session.commit();
		session.close();	
	}
	@Override
	public void update(User obj) {
//		SqlSession session = null;
//		try{
//			InputStream in = Resources.getResourceAsStream("SqlMapperConfiger.xml");
//			SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(in);
//			session = sessionFactory.openSession();
//			session.update("com.hautec.edu.entity.User.update",obj);
//			session.commit();
//		}catch(IOException e){
//			
//			e.printStackTrace();
//			
//		}finally{
//			if(session != null)
//				session.close();
//		}
		SqlSession session = MybatisUtil.openSession();
		session.update("com.hautec.edu.entity.User.update",obj);
		session.commit();
		session.close();
	
	}

	@Override
	public void delete(Long id) {
//		SqlSession session = null;
//		try{
//			InputStream in = Resources.getResourceAsStream("SqlMapperConfig.xml");
//			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
//			//先把session 打开，通过sessionFactory调用openSession()这个方法 ，然后将这个对象赋值给 session ，
//			session = sessionFactory.openSession();
//			//下面才可以进行 一列的增删改查操作！！！！
//			session.delete("com.hautec.edu.entity.User.delete",id);
//			//下面就是进行session提交！！！！
//			session.commit();
//			//
//		}catch(IOException e){
//			e.printStackTrace();
//		}finally{
//			if(session != null)
//				session.close();
//		}
		SqlSession session = MybatisUtil.openSession();
		session.delete("com.hautec.edu.entity.User.delete",id);
		session.commit();
		session.close();
	
	}

	@Override
	public User get(Long id) {
//		SqlSession session = null;
//		try{
//			InputStream in = Resources.getResourceAsStream("SqlMapperConfig.xml");
//			
//
//		}catch(IOException e){
//			e.printStackTrace();
	
//		}
//		return null;
		
		
		
		//这是没有优化之前的代码，通过之前的 SqlSession来进行 获取
//		SqlSession session = MybatisUtil.openSession();
//		 User user = session.selectOne("com.hautec.edu.entity.User.getUserById",id );
//		 session.close();
//		 return user;
		
		//下面是  优化之后的 代码 我们通过 在entity下面进行新建一个interface 达到这个目的
		SqlSession session = MybatisUtil.openSession(); 
		User user  = session.selectOne("com.hautec.edu.entity.User.getUserById", id);
		session.close();
		return user;
	}

	@Override
	public List<User> list() {
		SqlSession session = MybatisUtil.openSession();
		List<User> userList = session.selectList("com.hautec.edu.entity.User.getAllUser" );
		session.close();
		return userList;
	}
	
	
	
}
