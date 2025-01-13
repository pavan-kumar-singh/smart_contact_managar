package com.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.User1;

@Repository
public interface UserRepo extends JpaRepository<User1, String>{

}
