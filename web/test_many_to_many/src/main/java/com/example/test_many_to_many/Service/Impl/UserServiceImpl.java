package com.example.test_many_to_many.Service.Impl;

import com.example.test_many_to_many.Connections.BaseRepository;
import com.example.test_many_to_many.Repository.IUserRepository;
import com.example.test_many_to_many.Repository.Impl.UserRepositoryImpl;
import com.example.test_many_to_many.Service.IUserService;
import com.example.test_many_to_many.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements IUserService {
   private UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    public List<User> display_list_user() {
        return userRepository.display_list_user();
    }

    @Override
    public Boolean add_user(User user) {
        return userRepository.add_user(user);
    }
}
