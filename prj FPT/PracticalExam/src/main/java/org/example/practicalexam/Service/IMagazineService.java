package org.example.practicalexam.Service;

import org.example.practicalexam.model.Magazine;

import java.util.List;

public interface IMagazineService {
    List<Magazine> getAll();
    void newMagazine(Magazine magazine);
}
