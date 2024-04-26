package com.codegym.Service;

import org.springframework.stereotype.Service;

@Service
public class Dictionary implements IDictionary{
    static final String[] VN = {"Qua dua hau", "Qua cam", "Qua xoai", "Qua dua", "Qua chanh"};
    static final String[] US = {"Water Melon", "Orange", "Mango", "Pineapple", "Lemon"};
    @Override
    public String checkText(String text) {
        for (int i = 0; i < US.length; i++) {
            if (text.equals(US[i])){
                return VN[i];
            }
        }
        return "Not found";
    }
}