package com.crossengage.repository;

import java.util.List;

import com.crossengage.model.User;

public interface IUserDAO {
	public Boolean save(User user);

	public User update();

	public List<User> findAll();

	public List<User> findByState(Boolean State);
}
