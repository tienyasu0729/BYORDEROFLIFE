package com.example.test_many_to_many.Service;

import com.example.test_many_to_many.model.Midd;

import java.util.List;

public interface IMiddService {
    List<Midd> list_midd();
    Boolean add_midd(Midd midd);

}
