package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
@RequestMapping("/music")
public class Controller {
    @GetMapping("")
    public ModelAndView showFormMusic() {
        ModelAndView modelAndView = new ModelAndView("/showAddMusic");
        modelAndView.addObject("music", new Music());
        return modelAndView;
    }

    @ModelAttribute("musicGenres")
    public String[] musicGenres() {
        return new String[]{"Pop", "Ballad", "Bolero", "indie"};
    }

    @Autowired
    IMusicService musicService;

    @PostMapping("")
    public ModelAndView uploadFile(@ModelAttribute Music fileMusic) {
        ModelAndView modelAndView = new ModelAndView("/showMusic");
        if (musicService.checkFile(fileMusic.getFileMusic())) {
            musicService.add(fileMusic);
            modelAndView.addObject("showList", musicService.showList());
        } else {
            modelAndView = showFormMusic();
            modelAndView.addObject("errorFile", "Nhập sai định dạng file!");
        }
        return modelAndView;
    }
}