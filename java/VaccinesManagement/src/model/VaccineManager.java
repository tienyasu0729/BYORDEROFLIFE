package model;

import view.Menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class VaccineManager{
    private List<Vaccine> vaccines;

    public VaccineManager() {
        this.vaccines = new ArrayList<>();
    }

    public void addVaccine(Vaccine vaccine){
        vaccines.add(vaccine);
    }

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }
//    public void removeVaccine(Vaccine VaccineCode) {
//
//        for (Vaccine vaccine : vaccines) {
//            if (vaccine.getCode().equals(VaccineCode.getCode())) {
//                vaccines.remove(vaccine);
//            }
//        }
//    }

    public void printVaccineList() {
        for (Vaccine vaccine : vaccines) {
            System.out.println(vaccine);
        }
    }

    public Vaccine findVaccineByCode(String vaccineCode) {
        for (Vaccine vaccine : vaccines) {
            if (vaccine.getCode().equals(vaccineCode)) {
                return vaccine;
            }
        }
        return null;
    }

    public List<Vaccine> searchCondition(Predicate<Vaccine> predicate) {
        List<Vaccine> vaccineList = new ArrayList<>();
        for (Vaccine vaccine : vaccines) {
            if (predicate.test(vaccine)) {
                vaccineList.add(vaccine);
            }
        }
        return vaccineList;
    }

    public void removeVaccine(Vaccine vaccineCode) {
        Iterator<Vaccine> iterator = vaccines.iterator();
        while (iterator.hasNext()) {
            Vaccine vaccine = iterator.next();
            if (vaccine.getCode().equals(vaccineCode.getCode())) {
                iterator.remove();
            }
        }
    }
    public void sortByName(){

    }
}
