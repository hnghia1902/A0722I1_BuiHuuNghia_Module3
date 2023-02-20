package model.repository;

import model.User;

import java.util.List;

public interface IUserRepository {
    List<User> showListUser();

    void create(User user);
    User selectUser(int id);
    void updateUser(User user);
}
