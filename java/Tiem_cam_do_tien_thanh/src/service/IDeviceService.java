package service;

import java.util.List;

public interface IDeviceService<T> {
    void displayList();
    void add();
    void edit(int idEdit);
    void delete(int idDelete);
    void extend(int idExtend);
    void takeTheProduct(int idToTake);
    int checkIdIsExist();
    T findById(int idToFind);
    List<T> findListFollowId(String id);
    List<T> findListFollowName(String name);
}
