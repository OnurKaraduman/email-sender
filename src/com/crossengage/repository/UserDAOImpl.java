package com.crossengage.repository;

import java.io.IOException;
import java.util.List;

import com.crossengage.model.User;
import com.crossengage.util.FileFactory;

public class UserDAOImpl implements IUserDAO {

	private FileFactory fileFactory;

	public UserDAOImpl() {
		super();
		this.fileFactory = new FileFactory();
	}

	@Override
	public Boolean save(User user) {
		try {
			fileFactory.save(user);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public User update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		try {
			return fileFactory.readTextFileAndReturnUsersByState(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findByState(Boolean state) {
		try {
			return fileFactory.readTextFileAndReturnUsersByState(state);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
