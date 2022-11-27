package model;

import java.security.NoSuchAlgorithmException;

import dao.UserDAO;

public class LoginLogic {
	public UserBean execute(String userName, String pass) {
		// パスワードをハッシュ化
		String hashedPass = null;
		try {
			hashedPass = RegisterLogic.build(pass); //staticメソッドの呼び出し
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		// DBと照合
		UserBean user = new UserBean(userName, hashedPass);
		UserDAO dao = new UserDAO();
		return dao.findUser(user);
	}
}
