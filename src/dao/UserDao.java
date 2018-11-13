package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import model.User;

public class UserDao {

	public User findByLoginInfo(String loginId, String password) {
		Connection conn = null;
		try {

			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, md5(password));
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
			return new User(loginIdData, nameData);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	public List<User> findAll() {
		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {

			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDay = rs.getDate("birthday");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, loginId, name, birthDay, password, createDate, updateDate);

				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}

	public User findById(String id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			String loginId = rs.getString("login_id");
			String name = rs.getString("name");
			Date birthDay = rs.getDate("birthday");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");
			return new User(Integer.parseInt(id), loginId, name, birthDay, createDate, updateDate);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	public User insertUser(String loginId, String username, String birthDay, String password) throws SQLException {

		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO user (login_id, name, birthday, password, create_date, update_date) VALUES (?,?,?,?,now(),now())";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, loginId);
			pStmt.setString(2, username);
			pStmt.setString(3, birthDay);
			pStmt.setString(4, md5(password));

			int result = pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}

	public User updateUser(String id, String loginId, String username, String birthDay, String password) {
		Connection conn = null;
		int status = 0;

		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE user SET login_id = ?, name = ?, password = ?,  birthday = ?, update_date = now() WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, loginId);
			pStmt.setString(2, username);
			pStmt.setString(3, md5(password));
			pStmt.setString(4, birthDay);
			pStmt.setString(5, id);

			status = pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}

	public int deleteUser(int id) {

		Connection conn = null;
		int status = 0;

		try {
			conn = DBManager.getConnection();
			String sql = "Delete FROM user WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			status = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return status;
	}

	public User getUser(String uname, String pass) {

		Connection conn = null;

		String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			conn = DBManager.getConnection();

			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, uname);
			pStmt.setString(2, pass);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getString("login_id"), rs.getString("name"));

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	private String md5(String password) {
		Charset charset = StandardCharsets.UTF_8;
		String algorithm = "MD5";

		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);
		System.out.println(result);
		return result;
	}
}
