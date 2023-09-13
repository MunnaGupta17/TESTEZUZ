package com.userManagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.userManagement.exceptions.UserException;
import com.userManagement.models.User;

@Service
public interface UserServices {
	
	public User registerUser(User user)throws UserException;
	public User getUser(Integer id)throws UserException;
	public String updateUser(User user)throws UserException;
	public String deleteUser(Integer id)throws UserException;
	public List<User> getAllUsers()throws UserException;

}
