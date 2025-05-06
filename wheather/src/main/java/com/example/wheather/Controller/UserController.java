package com.example.wheather.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wheather.Entites.User;
import com.example.wheather.service.UserserviceImpl;

@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserserviceImpl service;
	
	@PostMapping("/addNewUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
	   User u = service.addUser(user);
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUser(){
		return new ResponseEntity<>(service.getAllUser(),HttpStatus.OK);
		
	}
	@GetMapping("/getUserBy/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
    	return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }
	
	@GetMapping("/getUserByHomeLocation/{homelocation}")
	public ResponseEntity<List<User>> getUserByhomeLocation1( @PathVariable String homelocation){
		return new ResponseEntity<>(service.getUserByhomeLocation(homelocation), HttpStatus.OK);
	}
	@GetMapping("/getUserByOfficeLocation/{officelocation}")
	public ResponseEntity<List<User>> getUserByofficeLocation(@PathVariable String officelocation){
	return new ResponseEntity<>(service.getUserByofficeLocation(officelocation),HttpStatus.OK);
	}
	@GetMapping("/getUserByOtherLocation/{otherLocation}")
	public ResponseEntity<List<User>> getUserByotherLocation(@PathVariable String otherLocation){
		return new ResponseEntity<>(service.getUserByotherLocation(otherLocation),HttpStatus.OK);
	}
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User u, @PathVariable int id) {
		return new ResponseEntity<>(service.updateUser(u, id) ,HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteUserBy/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable int id) {
		return new ResponseEntity<>(service.deleteUserById(id)  + id,HttpStatus.OK);
	}
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return service.register(user);
	}
	@PostMapping("/login")
	public String login(@RequestBody User user) {
//		service.login(user);
		System.out.println(user);
		return "sucess";
	}
	

}
