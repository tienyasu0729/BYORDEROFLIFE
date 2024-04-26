package org.example.practicalexam.Service.Impl;

import org.example.practicalexam.Repository.MagazineRepository;
import org.example.practicalexam.Repository.Impl.MagazineRepositoryImpl;
import org.example.practicalexam.Service.IMagazineService;
import org.example.practicalexam.model.Magazine;

import java.util.List;

public class IMagazineServiceImpl implements IMagazineService {
    private MagazineRepository magazineRepository = new MagazineRepositoryImpl();

    @Override
    public List<Magazine> getAll() {
        return magazineRepository.getAll();
    }

    @Override
    public void newMagazine(Magazine magazine) {
        magazineRepository.newMagazine(magazine);
    }
}
