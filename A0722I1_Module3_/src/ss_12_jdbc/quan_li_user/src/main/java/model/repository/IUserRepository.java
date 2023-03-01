package model.repository;

import model.User;

import java.util.List;

public interface IUserRepository {
    List<User> showListUser();

    void create(User user);
    User selectUser(int id);
    void updateUser(User user);
    List<User>selectUser_by_country(String country);
    List<User> sort();
    void deleteUser(int id);
}
