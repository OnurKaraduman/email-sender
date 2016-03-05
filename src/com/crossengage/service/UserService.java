package com.crossengage.service;

import java.util.List;

import com.crossengage.model.User;
import com.crossengage.repository.IUserDAO;
import com.crossengage.repository.UserDAOImpl;

public class UserService implements IUserService {
	private IUserDAO userDao;

	public UserService() {
		super();
		userDao = new UserDAOImpl();
	}

	@Override
	public Boolean save(User user) {
		return userDao.save(user);
	}

	@Override
	public Boolean sendMail(String mailBody, List<User> users) {
		try {
			for (User user : users) {
				System.out.println("To: " + user.getNameSurname() + " \nContent: " + mailBody);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAll();
	}

	@Override
	public List<User> findActiveUser() {
		return userDao.findByState(true);
	}
}
