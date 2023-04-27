package dao.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.model.User;

public class UserDAO implements IDAO<User>{
	
	private final static UserDAO INSTANCE = new UserDAO();
	private final static String INSERT_USER = "INSERT INTO USER (login,pwd,firstname,lastname) VALUES (?,?,?,?)";
	
	
	public static UserDAO getInstance() {
		return INSTANCE;
	}
	
	private UserDAO() {}

	public User create(User user) {
		PreparedStatement pst = null;
		try {
			pst = JdbcSingleton.getInstance().getConnection().prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, user.getLogin());
			pst.setString(2, user.getPwd());
			pst.setString(3, user.getFirstName());
			pst.setString(4, user.getLastName());
			pst.execute();
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()) {
				user.setId(rs.getInt(1));
			}
			if (rs!=null) {
				rs.close();
			}
			if (pst!=null) {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

}
