package com.example.wheather.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wheather.Entites.User;
import com.example.wheather.Repositary.UserRepositary;

@Service
public class UserserviceImpl implements UserService {
	@Autowired
	private UserRepositary repositary;
	

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		User user = repositary.save(u);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return repositary.findAll();
	}

	@Override
	public User getUserById(int id) {
		
		User u = repositary.findById(id).orElseThrow();
		return u;
			
		
	}

	@Override
	public String updateUser(User u, int id) {
		// TODO Auto-generated method stub
		User user = repositary.findById(id).get();
		if(user == null) {
			throw new UserDetailsNotFound("User Details Not Founf On This Id : " + user);
		}
		user.setName(u.getName());
		user.setPhno(u.getPhno());
		user.setHomeLocation(u.getHomeLocation());
		user.setOfficeLocation(u.getOfficeLocation());
		user.setOtherLocation(u.getOtherLocation());
		
		repositary.save(u);
		
		return "New User Details Updated On " + user;
	}
	@Override
	public List<User> getUserByhomeLocation(String homelocation) {
		// TODO Auto-generated method stub
		
		List<User> user1 =  repositary.findByHomeLocation(homelocation);
		return user1;
		
	}


	@Override
	public List<User> getUserByofficeLocation(String officelocation) {
		// TODO Auto-generated method stub
		return repositary.findByOfficeLocation(officelocation);
	}

	@Override
	public List<User> getUserByotherLocation(String otherLocation) {
		// TODO Auto-generated method stub
		return repositary.findByOtherLocation(otherLocation);
	}

	@Override
	public String deleteUserById(int id) {
		// TODO Auto-generated method stub
		if(repositary.findById(id) != null) {
		repositary.deleteById(id);
		} else {
			throw new RuntimeException("This Id " + id + "User not Found On DATABASE :");
		}
		return "deleted User By Id : " ;
	}

	
}
