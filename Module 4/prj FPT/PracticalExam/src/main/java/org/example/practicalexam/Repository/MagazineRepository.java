package org.example.practicalexam.Repository;

import org.example.practicalexam.model.Magazine;

import java.util.List;


public interface MagazineRepository {
    List<Magazine> getAll();
    void newMagazine(Magazine magazine);
}

