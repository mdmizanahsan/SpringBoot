package com.mizan.user_dashboard_api.service;

import com.mizan.user_dashboard_api.entity.User;

import java.util.List;

public interface UserService {

     User create(User user);
     List<User> getAll();
     User findById(String id);
     void deleteById(String id);
    User update(String id , User user);

}
