package com.example.wheather.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wheather.Entites.User;

public interface UserRepositary extends JpaRepository<User , Integer> {

}
