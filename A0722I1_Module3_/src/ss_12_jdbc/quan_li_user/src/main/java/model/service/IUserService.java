package model.service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> showListUser();
    void create(User user);
    User selectUser(int id);
    void updateUser(User user);
}
