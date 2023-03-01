package model.service.impl;

import model.User;
import model.repository.IUserRepository;
import model.repository.impl.UserRepository;
import model.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    IUserRepository iUserRepository = new UserRepository();
    @Override
    public List<User> showListUser() {
        return iUserRepository.showListUser();
    }

    @Override
    public void create(User user) {
        iUserRepository.create(user);
    }

    @Override
    public User selectUser(int id) {
        return iUserRepository.selectUser(id);
    }

    @Override
    public void updateUser(User user) {
        iUserRepository.updateUser(user);
    }

    @Override
    public List<User> selectUser_by_country(String country) {
        return iUserRepository.selectUser_by_country(country);
    }

    @Override
    public List<User> sort() {
        return iUserRepository.sort();
    }

    @Override
    public void deleteUser(int id) {
        iUserRepository.deleteUser(id);
    }


}
