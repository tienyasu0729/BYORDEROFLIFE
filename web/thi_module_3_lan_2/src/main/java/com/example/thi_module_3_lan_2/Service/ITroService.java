package com.example.thi_module_3_lan_2.Service;

import com.example.thi_module_3_lan_2.model.Tro;

import java.util.List;

public interface ITroService {
    List<Tro> display_tro();
    boolean add_tro(Tro tro);
    boolean delete(int id);


}
