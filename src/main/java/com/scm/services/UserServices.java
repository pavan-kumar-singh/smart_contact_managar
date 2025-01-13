package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.User1;

public interface UserServices {
   User1 saveUser(User1 user);

   Optional<User1> getUserById(String id);

   Optional<User1> updateUser(User1 user);

   void deleteUser(String id);

   boolean isUserExist(String userId);

   boolean isUserExistByEmail(String email);

   List<User1> getAllUsers();

   User1 getUserByEmail(String email);
   
}
