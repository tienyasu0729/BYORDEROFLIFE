package controller;

import view.VaccineRepository;

import java.io.IOException;
import java.text.ParseException;

public class Controller {
    public static void main(String[] args) throws ParseException, IOException {
        VaccineRepository vaccineRepository = new VaccineRepository();
        vaccineRepository.run();
    }
}
