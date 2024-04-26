package com.example.test_many_to_many.Service.Impl;

import com.example.test_many_to_many.Repository.Impl.RoleRepositoryImpl;
import com.example.test_many_to_many.Service.IRoleService;
import com.example.test_many_to_many.model.Role;

import java.util.List;

public class RoleServiceImpl implements IRoleService {
    private RoleRepositoryImpl roleRepository = new RoleRepositoryImpl();

    @Override
    public List<Role> display_role() {
        return roleRepository.display_role();
    }
}
