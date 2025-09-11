package com.mizan.practice.Service;

import com.mizan.practice.Entity.User;
import com.mizan.practice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //GET all
    public  List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET by Id
    public User getUserById(Long Id) {
        return userRepository.findById(Id).orElse(null);
    }

    //Save
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //update
    public User updateUser(Long Id , User userDetails) {
        User existingUser = userRepository.findById(Id).orElse(null);
        if (existingUser !=null) {
            existingUser.setUserName(userDetails.getUserName());
            existingUser.setCollegeId(userDetails.getCollegeId());
            existingUser.setCampusId(userDetails.getCampusId());
            existingUser.setUniversityId(userDetails.getUniversityId());
            existingUser.setDepartmentId(userDetails.getDepartmentId());
            existingUser.setFirstName(userDetails.getFirstName());
            existingUser.setLastName(userDetails.getLastName());
            existingUser.setEmailId(userDetails.getEmailId());
            existingUser.setContactNo(userDetails.getContactNo());
            existingUser.setPreferredLanguage(userDetails.getPreferredLanguage());
            existingUser.setStaff(userDetails.isStaff());
            existingUser.setSuperUser(userDetails.isSuperUser());
            existingUser.setCollegeAdmin(userDetails.isCollegeAdmin());
            existingUser.setCampusAdmin(userDetails.isCampusAdmin());
            existingUser.setDepartmentAdmin(userDetails.isDepartmentAdmin());
            existingUser.setCourseCoordinator(userDetails.isCourseCoordinator());
            existingUser.setActive(userDetails.isActive());

            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id: " + Id);

        }

    }

    // Delete by Id
    public Long deleteUserById(Long Id) {
        if (userRepository.existsById(Id)) {
            userRepository.deleteById(Id);
            return Id;
        } else {
            throw new RuntimeException("User not found with id: " + Id);
        }
    }
}
