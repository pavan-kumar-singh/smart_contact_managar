package com.scm.services.imp;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.scm.helper.ResourceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.User1;
import com.scm.form.UserForm;
import com.scm.repository.UserRepo;
import com.scm.services.UserServices;

@Service
public class UserServiceImp implements UserServices {

   @Autowired
   private UserRepo userRepo;

   private Logger logger = LoggerFactory.getLogger(this.getClass());

   @Override
   public User1 saveUser(User1 user) {
      String userId = UUID.randomUUID().toString();
      user.setUserId(userId);
     
      return userRepo.save(user);


      
   }

   @Override
   public Optional<User1> getUserById(String id) {
      // TODO Auto-generated method stub
      return userRepo.findById(id);

   }

   @Override
   public Optional<User1> updateUser(User1 user) {
      // TODO Auto-generated method stub
      User1 user2 = userRepo.findById(user.getUserId())
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
      // update karenge user2 from user
      user2.setName(user.getName());
      user2.setEmail(user.getEmail());
      user2.setPassword(user.getPassword());
      user2.setAbout(user.getAbout());
      user2.setPhone(user.getPhone());
      user2.setProfilePic(user.getProfilePic());
      user2.setEnabled(user.isEnabled());
      user2.setEmailverified(user.isEmailverified());
      user2.setContactverified(user.isContactverified());
      user2.setProvider(user.getProvider());
      user2.setProviderUserId(user.getProviderUserId());
      // save the user in database
      User1 save = userRepo.save(user2);
      return Optional.ofNullable(save);

   }

   @Override
   public void deleteUser(String id) {
      // TODO Auto-generated method stub
      User1 user2 = userRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
      userRepo.delete(user2);
   }

   @Override
   public boolean isUserExist(String userId) {
      // TODO Auto-generated method stub
      User1 user2 = userRepo.findById(userId).orElse(null);
      return user2 != null ? true : false;
   }

   @Override
   public boolean isUserExistByEmail(String email) {
      // TODO Auto-generated method stub
      User1 user = userRepo.findByEmail(email).orElse(null);
      return user != null ? true : false;
   }

   @Override
   public List<User1> getAllUsers() {
      return userRepo.findAll();
   }

   @Override
   public User1 getUserByEmail(String email) {
      return userRepo.findByEmail(email).orElse(null);

   }

   @Override
   public void saveUser(UserForm userForm) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'saveUser'");
   }

}
