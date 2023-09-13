package com.userManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userManagement.exceptions.UserException;
import com.userManagement.models.User;
import com.userManagement.repository.UserRepo;

@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
	private UserRepo userRepository;

	@Override
	public User registerUser(User user) throws UserException {
		// TODO Auto-generated method stub
		if(user == null) throw new UserException("user is null");
	    return userRepository.save(user);
	}

	@Override
	public User getUser(Integer id)throws UserException {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		
		throw new UserException("user not found with this id");
	}

	@Override
	public String updateUser(User user)throws UserException {
		// TODO Auto-generated method stub
		if(user == null) throw new UserException("user is null");
		userRepository.save(user);
		return "updated successfully";
	}

	@Override
	public String deleteUser(Integer id)throws UserException {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()) {
			userRepository.delete(optionalUser.get());
			return "deleted successfully";
		}
		throw new UserException("user not found with this id");
	}

	@Override
	public List<User> getAllUsers()throws UserException {
		// TODO Auto-generated method stub
		
		List<User> allUsers = userRepository.findAll();
		if(allUsers.size() == 0) throw new UserException("database is empty");
		return allUsers;
	}

}
