package com.example.test_many_to_many.Service.Impl;

import com.example.test_many_to_many.Repository.Impl.IMiddRepositoryImpl;
import com.example.test_many_to_many.Service.IMiddService;
import com.example.test_many_to_many.model.Midd;

import java.util.List;

public class IMiddServiceImpl implements IMiddService {
    private IMiddRepositoryImpl middRepository = new IMiddRepositoryImpl();

    @Override
    public List<Midd> list_midd() {
        return middRepository.list_midd();
    }

    @Override
    public Boolean add_midd(Midd midd) {
        return middRepository.add_midd(midd);
    }

}
