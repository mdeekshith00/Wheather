package com.example.wheather.Repositary;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.wheather.Entites.User;

public interface UserRepositary extends JpaRepository<User , Integer> {
	
	User findByName(String name);
	List<User> findByHomeLocation(String homelocation);
	List<User> findByOfficeLocation(String officelocation);
	List<User> findByOtherLocation(String otherLocation);
	
	

}
