package com.hautec.edu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.hautec.edu.dao.UserDao;
import com.hautec.edu.dao.impl.UserDaoImpl;
import com.hautec.edu.entity.User;
import com.hautec.edu.entity.UserMapper;
import com.hautec.edu.util.MybatisUtil;

public class UserTest {
	//junit4作为测试   后台人员会继续测试  只是一个简单的测试
	private UserDao dao = new UserDaoImpl();//父类的引用指向了子类的对象 多态
	@Test
	public  void testUpdate(){
		User user= new User(); 
		user.setId(1L);
		user.setUsername("郭德纲");
		dao.update(user);
	}
	@Test
	public void testSave(){
		User user = new User();
		user.setUsername("于谦");
		user.setPassword("123");
		dao.svae(user);
	}
	@Test
	public void testDelete(){
		User uesr = new User();
		dao.delete(9L);
	}

		//定义一个局部变量 设置为空 然后导包 通过实现类 来做  
//		SqlSessionFactory sessionFactory = null;
		
//		InputStream in = null;
		//抽象的 不可以实例化 通过类加载器 来进行读取/或者当前线程,通过流的方式，传递的是字符串，只有放在包的下面才可以通过这方式进行读取
		//如何快速去一个名字，按住alt+/则可以智能取名字！！！！
//		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("SqlMapperConfiger.xml");
//		sessionFactory = new SqlSessionFactoryBuilder().build(in);
//		SqlSession session = sessionFactory.openSession();
//		session.insert("com.hautec.edu.entity.UserMapper.add",user);
//		session.commit();
//		session.close();
	
	@Test
	public void testGet(){
		
		
		
		
//		User user = dao.get(1L);
//		System.out.println(user);
		
	SqlSession session = MybatisUtil.openSession();
	UserMapper mapper = session.getMapper(UserMapper.class);
	System.out.println(mapper.getClass());
	User user = mapper.getUserById(3L);
	System.out.println(user);

	}
	@Test
	public void testGetAll(){
		List<User> userList = dao.list();
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
		}
		
//		for (User user : userList) {
//			System.out.println(user);
//			
//		}
//		
		
	}
	
	
	
}



