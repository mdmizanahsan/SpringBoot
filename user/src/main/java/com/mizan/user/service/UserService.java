package com.mizan.user.service;

import com.mizan.user.entity.UserEntity;
import com.mizan.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //GET ALL USER
    public List<UserEntity> getalluser() {
       return userRepository.findAll();
    }

    //GET SINGLE ID
    public UserEntity getUserById(Long id) {
       return userRepository.findById(id).orElse(null);
    }

    // SAVE
    public  UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    // Delete
    public Long deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return id;
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
    // UPDATE USER
    public UserEntity updateUser(Long id, UserEntity userDetails) {

        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Basic fields
        existingUser.setFullName(userDetails.getFullName());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setPhoneNumber(userDetails.getPhoneNumber());
        existingUser.setUsername(userDetails.getUsername());
        existingUser.setPassword(userDetails.getPassword());
        existingUser.setBio(userDetails.getBio());
        existingUser.setAvatarUrl(userDetails.getAvatarUrl());
        existingUser.setDob(userDetails.getDob());
        existingUser.setGender(userDetails.getGender());
        existingUser.setRole(userDetails.getRole());
        existingUser.setIsAuthenticated(userDetails.getIsAuthenticated());

        // Address fields
        if (userDetails.getAddress() != null) {
            if (existingUser.getAddress() == null) {
                existingUser.setAddress(userDetails.getAddress());
            } else {
                existingUser.getAddress().setArea(userDetails.getAddress().getArea());
                existingUser.getAddress().setDistrict(userDetails.getAddress().getDistrict());
                existingUser.getAddress().setState(userDetails.getAddress().getState());
                existingUser.getAddress().setPincode(userDetails.getAddress().getPincode());

                // Coordinate fields
                if (userDetails.getAddress().getCoordinate() != null) {
                    if (existingUser.getAddress().getCoordinate() == null) {
                        existingUser.getAddress().setCoordinate(userDetails.getAddress().getCoordinate());
                    } else {
                        existingUser.getAddress().getCoordinate().setLatitude(
                                userDetails.getAddress().getCoordinate().getLatitude()
                        );
                        existingUser.getAddress().getCoordinate().setLongitude(
                                userDetails.getAddress().getCoordinate().getLongitude()
                        );
                    }
                }
            }
        }

        return userRepository.save(existingUser);
    }


}
