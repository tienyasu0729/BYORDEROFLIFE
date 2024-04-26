package com.example.test_many_to_many.Service;

import com.example.test_many_to_many.model.User;

import java.util.List;

public interface IUserService {
    List<User> display_list_user();
    Boolean add_user(User user);

}
