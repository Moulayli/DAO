package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import dao.dao.IDAO;
import dao.dao.JdbcSingleton;
import dao.dao.UserDAO;
import dao.model.User;

public class DaoMain {
	
	

	public static void main(String[] args) {
		
        User user1=new User();
        user1.setFirstName("Nathalie");
        user1.setLastName("Forget");
        user1.setLogin("nforget");
        user1.setPwd("pwd1");
        User user2=new User();
        user2.setFirstName("Jean-Bernard");
        user2.setLastName("Buffalo");
        user2.setLogin("bbuffalo");
        user2.setPwd("pwd2");
        User user3=new User();
        user3.setFirstName("Jean-Yves");
        user3.setLastName("Doeuf");
        user3.setLogin("jdoeuf");
        user3.setPwd("pwd3");
		
		IDAO<User> userDAO = UserDAO.getInstance();
		userDAO.create(user1);
		userDAO.create(user2);
		userDAO.create(user3);
		
				
		
		JdbcSingleton.getInstance().close();
	}

}
