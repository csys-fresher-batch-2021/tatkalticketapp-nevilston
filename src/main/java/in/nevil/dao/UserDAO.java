package in.nevil.dao;

import java.util.ArrayList;
import java.util.List;

import in.nevil.model.User;

public class UserDAO {
	private  static final List<User> userList = new ArrayList<>();
	static {
		userList.add(new User("Nevil", 9566087158l, "Lobo@9145"));
	}

	public static void addUser(User user) {
		userList.add(new User(user.getUserName(), user.getUserNumber(), user.getUserPassword()));
	}

	public List<User> getUserList() {
		return userList;
	}

}
