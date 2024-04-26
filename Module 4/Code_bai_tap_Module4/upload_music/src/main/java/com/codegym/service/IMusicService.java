package com.codegym.service;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicService {
    boolean checkFile(String file);
    boolean add(Music fileMusic);
    List<Music> showList();
}
