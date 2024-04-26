package com.codegym.service.Impl;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {
    List<Music> list = new ArrayList<>();

    @Autowired
    IMusicService iFileMusicService;

    @Override
    public boolean checkFile(String file) {
        int index = file.lastIndexOf(".");
        String fileExtension = file.substring(index + 1);
        if (fileExtension.equals("mp3") ||
                fileExtension.equals("wav") ||
                fileExtension.equals("ogg") ||
                fileExtension.equals("m4p")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(Music fileMusic) {
        list.add(fileMusic);
        return true;
    }

    @Override
    public List<Music> showList() {
        return list;
    }
}
