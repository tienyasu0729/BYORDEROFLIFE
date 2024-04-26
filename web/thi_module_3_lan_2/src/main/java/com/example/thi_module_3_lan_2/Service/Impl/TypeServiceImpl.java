package com.example.thi_module_3_lan_2.Service.Impl;

import com.example.thi_module_3_lan_2.Repository.Impl.TypeRepositoryImpl;
import com.example.thi_module_3_lan_2.Service.ITypeService;
import com.example.thi_module_3_lan_2.model.Type;

import java.util.List;

public class TypeServiceImpl implements ITypeService {
    private TypeRepositoryImpl typeRepository = new TypeRepositoryImpl();

    @Override
    public List<Type> display_type() {
        return typeRepository.display_type();
    }
}
