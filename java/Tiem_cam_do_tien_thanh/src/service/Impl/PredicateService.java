package service.Impl;

import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateService<T> {
    public List<T> searchCondition(Predicate<T> predicate, List<T> list) {
        List<T> searchProduct = new ArrayList<>();
        for (T product : list) {
            if (predicate.test(product)) {
                searchProduct.add(product);
            }
        }
        return searchProduct;
    }
}
