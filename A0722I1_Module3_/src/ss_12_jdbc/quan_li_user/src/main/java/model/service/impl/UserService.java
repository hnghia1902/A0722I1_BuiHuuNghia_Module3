package model.service.impl;

import model.User;
import model.repository.IUserRepository;
import model.repository.impl.UserRepository;
import model.service.IUserService;
import org.omg.PortableServer.IdUniquenessPolicy;

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

}
