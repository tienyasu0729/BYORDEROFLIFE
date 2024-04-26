package com.example.thi_module_3_lan_2.Service.Impl;

import com.example.thi_module_3_lan_2.Repository.Impl.TroRepositoryImpl;
import com.example.thi_module_3_lan_2.Service.ITroService;
import com.example.thi_module_3_lan_2.model.Tro;

import java.util.List;

public class TroServiceImpl implements ITroService {
    private TroRepositoryImpl troRepository = new TroRepositoryImpl();

    @Override
    public List<Tro> display_tro() {
        return troRepository.display_tro();
    }

    @Override
    public boolean add_tro(Tro tro) {
        return troRepository.add_tro(tro);
    }

    @Override
    public boolean delete(int id) {
        return troRepository.delete(id);
    }

}
