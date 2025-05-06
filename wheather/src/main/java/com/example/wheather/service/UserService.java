package com.example.wheather.service;

import java.util.List;

import com.example.wheather.Entites.User;

public interface UserService {
	User addUser(User u);
	List<User> getAllUser();
	User getUserById(int id);
	String updateUser(User u, int id);
	String deleteUserById(int id);
	
	List<User> getUserByhomeLocation(String homelocation);
	List<User> getUserByofficeLocation(String officelocation);
	List<User> getUserByotherLocation(String otherLocation);
	String login(User user);

	

}


