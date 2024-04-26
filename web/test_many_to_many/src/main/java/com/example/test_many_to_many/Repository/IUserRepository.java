package com.example.test_many_to_many.Repository;

import com.example.test_many_to_many.model.User;

import java.util.List;

public interface IUserRepository {
    List<User> display_list_user();
    Boolean add_user(User user);
}
