package com.crossengage.service;

import java.util.List;

import com.crossengage.model.User;

public interface IUserService {
	public Boolean save(User user);

	public Boolean sendMail(String mailBody, List<User> users);

	public List<User> findAllUser();

	public List<User> findActiveUser();
}
