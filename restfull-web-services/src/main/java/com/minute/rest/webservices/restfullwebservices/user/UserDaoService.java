package com.minute.rest.webservices.restfullwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.h2.engine.User;
import org.springframework.stereotype.Component;

/**
 * @author gtshihata
 *
 */
@Component
public class UserDaoService {

	private static List<Users> users = new ArrayList<>();
	private static int userCount = 3;

	static {
		users.add(new Users(1, "Adam", new Date()));
		users.add(new Users(2, "eve", new Date()));
		users.add(new Users(3, "Jack", new Date()));

	}

	public List<Users> findAll() {
		return users;
	}

	public Users save(Users user) {

		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);

		return user;
	}

	public Users findOne(int id) {
		for (Users user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public Users deleteById(int id) {
		Iterator<Users> iterator = users.iterator();

		while (iterator.hasNext()) {
			Users user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
