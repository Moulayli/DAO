package dao.dao;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import dao.model.User;

public class UserDAO implements IDAO<User> {

	private final static UserDAO INSTANCE = new UserDAO();
	private final static String INSERT_USER = "INSERT INTO USER (login,pwd,firstname,lastname) VALUES (?,?,?,?)";
	private final static String SELECT_USERS = "SELECT * FROM USER ";
	private final static String SELECT_USERS_BY_ID = "SELECT * FROM USER where id = ?";
	private final static String UPDATE_USER_BY_ID = "UPDATE `user` SET `login`=?,`pwd`=?,`firstname`=?,`lastname`=? WHERE id= ?";
	private final static String DELETE_USERS_BY_ID = "DELETE FROM `user` WHERE id= ?";

	public static UserDAO getInstance() {
		return INSTANCE;
	}

	private UserDAO() {
	}

	public User create(User user) {
		PreparedStatement pst = null;
		try {
			pst = JdbcSingleton.getInstance().getConnection().prepareStatement(INSERT_USER,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, user.getLogin());
			pst.setString(2, user.getPwd());
			pst.setString(3, user.getFirstName());
			pst.setString(4, user.getLastName());
			pst.execute();
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				user.setId(rs.getInt(1));
			}
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> readAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Connection conn = JdbcSingleton.getInstance().getConnection();
			pst = conn.prepareStatement(SELECT_USERS);
			rs = pst.executeQuery();

			List<User> userList = new ArrayList<>();
			while (rs.next()) {
				User user = new User(
						Integer.parseInt(rs.getString("id")),
						rs.getString("firstName"),
						rs.getString("lastName"),
						rs.getString("login"));
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public User read(Integer id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Connection conn = JdbcSingleton.getInstance().getConnection();
			pst = conn.prepareStatement(SELECT_USERS_BY_ID);
			pst.setInt(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				User user = new User(
						rs.getInt("id"),
						rs.getString("firstName"),
						rs.getString("lastName"),
						rs.getString("login"));
				return user;
			}
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(User user) {
		PreparedStatement pst = null;
		try {
			pst = JdbcSingleton.getInstance().getConnection().prepareStatement(UPDATE_USER_BY_ID,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, user.getLogin());
			pst.setString(2, user.getPwd());
			pst.setString(3, user.getFirstName());
			pst.setString(4, user.getLastName());
			pst.execute();
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				user.setId(rs.getInt(1));
			}
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(Integer id) {
		PreparedStatement pst = null;
		try {
			pst = JdbcSingleton.getInstance().getConnection().prepareStatement(DELETE_USERS_BY_ID,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setLong(1, id);
			pst.execute();
			ResultSet rs = pst.getGeneratedKeys();
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}