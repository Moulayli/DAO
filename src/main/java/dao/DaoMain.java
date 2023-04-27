package dao;

import java.util.Scanner;

import dao.dao.IDAO;
import dao.dao.JdbcSingleton;
import dao.dao.UserDAO;
import dao.gui.Menu;
import dao.model.User;

public class DaoMain {
	public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        for (;;) {
            Menu.print();

            if (!Menu.handleAction(scanner.nextInt())) {
                scanner.close();

                break;
            }
        }

        User user1=new User("Forget");
        user1.setFirstName("Nathalie");
        user1.setLogin("nforget");
        user1.setPwd("pwd1");
        User user2=new User("Buffalo");
        user2.setFirstName("Jean-Bernard");
        user2.setLogin("bbuffalo");
        user2.setPwd("pwd2");
        User user3=new User("Doeuf");
        user3.setFirstName("Jean-Yves");
        user3.setLogin("jdoeuf");
        user3.setPwd("pwd3");
		
		IDAO<User> userDAO = UserDAO.getInstance();
		userDAO.create(user1);
		userDAO.create(user2);
		userDAO.create(user3);
		
				
		
		JdbcSingleton.getInstance().close();
	}

}
